package com.rps.game.server;

import com.rps.game.model.Move;
import com.rps.game.model.Player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Server {

    private static final int WIN_SCORE = 10;

    private static Map<String, String> users = new ConcurrentHashMap<>();
    private static Map<String, Integer> leaderboard = new ConcurrentHashMap<>();

    private static final String USERS_FILE = "users.json";
    private static final String LEADERBOARD_FILE = "leaderboard.json";

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        loadUsers();
        loadLeaderboard();
        

        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.setReuseAddress(true);        
            serverSocket.bind(new InetSocketAddress(65000)); 
            int port = serverSocket.getLocalPort();     
            System.out.println("Server started on port " + port + "! Waiting for players...");

            Socket player1 = serverSocket.accept();
            System.out.println("Player 1 connected.");

            Socket player2 = serverSocket.accept();
            System.out.println("Player 2 connected.");

            startGame(player1, player2);

            System.out.println("Server shutting down.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startGame(Socket p1Socket, Socket p2Socket) {
        try (
            BufferedReader in1 = new BufferedReader(new InputStreamReader(p1Socket.getInputStream()));
            PrintWriter out1 = new PrintWriter(p1Socket.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(p2Socket.getInputStream()));
            PrintWriter out2 = new PrintWriter(p2Socket.getOutputStream(), true)
        ) {
            String name1 = loginOrRegister(in1, out1);
            String name2 = loginOrRegister(in2, out2);

            if (name1 == null || name2 == null) return;

            Player p1 = new Player(name1);
            Player p2 = new Player(name2);

            out1.println("Welcome to Rock Paper Scissors! Race to " + WIN_SCORE + " points!");
            out1.println("0 = ROCK | 1 = PAPER | 2 = SCISSORS");
            out2.println("Welcome to Rock Paper Scissors! Race to " + WIN_SCORE + " points!");
            out2.println("0 = ROCK | 1 = PAPER | 2 = SCISSORS");

            while (p1.getScore() < WIN_SCORE && p2.getScore() < WIN_SCORE) {
                Move move1 = getMove(in1, out1);
                Move move2 = getMove(in2, out2);

                if (move1 == null || move2 == null) {
                    out1.println("A player disconnected. Server shutting down.");
                    out2.println("A player disconnected. Server shutting down.");
                    break;
                }

                p1.setMove(move1);
                p2.setMove(move2);

                String result = checkWinner(p1, p2);
                out1.println(result);
                out2.println(result);

                out1.println("Score: " + p1.getScore() + " - " + p2.getScore());
                out2.println("Score: " + p1.getScore() + " - " + p2.getScore());

                p1.resetMove();
                p2.resetMove();
            }

            // winner
            if (p1.getScore() >= WIN_SCORE) {
                out1.println("YOU WIN THE RACE TO " + WIN_SCORE + "!");
                out2.println("YOU LOSE! " + p1.getName() + " wins.");
                updateLeaderboard(p1.getName());
            } else if (p2.getScore() >= WIN_SCORE) {
                out2.println("YOU WIN THE RACE TO " + WIN_SCORE + "!");
                out1.println("YOU LOSE! " + p2.getName() + " wins.");
                updateLeaderboard(p2.getName());
            }

            String board = showLeaderboard(p1, p2);
            out1.println(board);
            out2.println(board);

        } catch (IOException e) {
            System.out.println("A player disconnected. Server shutting down.");
        } finally {
            try {
                p1Socket.close();
                p2Socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String loginOrRegister(BufferedReader in, PrintWriter out) throws IOException {
        while (true) {
            out.println("1. Register");
            out.println("2. Login");
            out.println("3. Exit");
            out.println("Choose:");

            String choice = in.readLine();
            if (choice == null) return null;

            switch (choice) {
                case "1":
                    out.println("Enter username:");
                    String user = in.readLine();
                    out.println("Enter password:");
                    String pass = in.readLine();

                    if(users.containsKey(user)) {
                        out.println("Username already exists!");
                    } else {
                        users.put(user, pass);
                        saveUsers();
                        out.println("Registered successfully!");
                    }
                    break;

                case "2":
                    out.println("Enter username:");
                    user = in.readLine();
                    out.println("Enter password:");
                    pass = in.readLine();

                    if (users.containsKey(user) && users.get(user).equals(pass)) {
                        out.println("Login successful! Game starting...");
                        return user;
                    } else {
                        out.println("Invalid login. Try again.");
                    }
                    break;

                case "3":
                    out.println("Goodbye!");
                    return null;
            }
        }
    }

    private static Move getMove(BufferedReader in, PrintWriter out) throws IOException {
        while (true) {
            out.println("Enter your move (0=Rock, 1=Paper, 2=Scissors):");
            String input = in.readLine();
            if (input == null) return null;

            switch (input) {
                case "0": return Move.ROCK;
                case "1": return Move.PAPER;
                case "2": return Move.SCISSORS;
                default: out.println("Invalid input. Try again!");
            }
        }
    }

    private static String checkWinner(Player p1, Player p2) {
        Move m1 = p1.getMove();
        Move m2 = p2.getMove();

        if (m1 == m2) return "Draw!";

        if ((m1 == Move.ROCK && m2 == Move.SCISSORS) ||
            (m1 == Move.PAPER && m2 == Move.ROCK) ||
            (m1 == Move.SCISSORS && m2 == Move.PAPER)) {
            p1.addScore();
            return p1.getName() + " wins this round!";
        } else {
            p2.addScore();
            return p2.getName() + " wins this round!";
        }
    }

    private static void updateLeaderboard(String name) {
        leaderboard.put(name, leaderboard.getOrDefault(name, 0) + 1);
        saveLeaderboard();
    }

    private static String showLeaderboard(Player p1, Player p2) {
        StringBuilder sb = new StringBuilder("--- LEADERBOARD ---\n");
        leaderboard.putIfAbsent(p1.getName(), 0);
        leaderboard.putIfAbsent(p2.getName(), 0);

        sb.append(p1.getName()).append(" - ").append(leaderboard.get(p1.getName())).append(" wins\n");
        sb.append(p2.getName()).append(" - ").append(leaderboard.get(p2.getName())).append(" wins\n");

        return sb.toString();
    }

    private static void loadUsers() {
        File file = new File(USERS_FILE);
        if(!file.exists()) {
            saveUsers(); 
        }

        try (Reader reader = new FileReader(file)) {
            Map<String, String> map = gson.fromJson(reader, new TypeToken<Map<String, String>>(){}.getType());
            if (map != null) users.putAll(map);
        } catch (IOException e) {
            System.out.println("Failed to load users.json, starting fresh.");
        }
    }

    private static void saveUsers() {
        try (Writer writer = new FileWriter(USERS_FILE)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadLeaderboard() {
        File file = new File(LEADERBOARD_FILE);
        if(!file.exists()) {
            saveLeaderboard(); 
        }

        try (Reader reader = new FileReader(file)) {
            Map<String, Integer> map = gson.fromJson(reader, new TypeToken<Map<String, Integer>>(){}.getType());
            if (map != null) leaderboard.putAll(map);
        } catch (IOException e) {
            System.out.println("Failed to load leaderboard.json, starting fresh.");
        }
    }

    private static void saveLeaderboard() {
        try (Writer writer = new FileWriter(LEADERBOARD_FILE)) {
            gson.toJson(leaderboard, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}