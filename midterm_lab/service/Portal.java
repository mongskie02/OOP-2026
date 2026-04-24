package com.rps.game.service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Portal {

    private static final String FILE_NAME = "users.txt";

    // Load users from file
    private Map<String, String> loadUsers() throws IOException {
        Map<String, String> users = new HashMap<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            users.put(parts[0], parts[1]); // username,password
        }

        reader.close();
        return users;
    }

    // Register
    public boolean register(String username, String password) throws IOException {
        Map<String, String> users = loadUsers();

        if (users.containsKey(username)) {
            return false; 
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        writer.write(username + "," + password);
        writer.newLine();
        writer.close();

        return true;
    }

    // Login
    public boolean login(String username, String password) throws IOException {
        Map<String, String> users = loadUsers();
        return users.containsKey(username) && users.get(username).equals(password);
    }
}