package com.rps.game.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 65000);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String serverMsg;
            while ((serverMsg = in.readLine()) != null) {
                System.out.println(serverMsg);
                if (serverMsg.contains("Choose") ||
                    serverMsg.contains("username") ||
                    serverMsg.contains("password") ||
                    serverMsg.contains("move")) {
                    String input = keyboard.readLine();
                    if (input == null) break;
                    out.println(input);
                }
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
            e.printStackTrace();
        }
    }
}