package com.gson.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "employees.json"; // Save file in root directory

    private static Gson getGson() {
        // Create an adapter for polymorphic deserialization
        RuntimeTypeAdapterFactory<Employee> adapter = RuntimeTypeAdapterFactory.of(Employee.class, "type")
                .registerSubtype(SalariedEmployee.class, EmployeeType.SALARIED.name())
                .registerSubtype(HourlyEmployee.class, EmployeeType.HOURLY.name());

        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(adapter) // Register the adapter factory
                .create();
    }

    // Save employees to a file
    public static void save(ArrayList<Employee> employees) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = getGson();
            gson.toJson(employees, writer);
            System.out.println("Saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load employees from a file
    public static ArrayList<Employee> load() {
        ArrayList<Employee> loadedEmployees = new ArrayList<>();
        try (Reader reader = new FileReader(FILE_NAME)) {
            Gson gson = getGson();
            Type listType = new TypeToken<ArrayList<Employee>>() {
            }.getType();
            loadedEmployees = gson.fromJson(reader, listType);
            if (loadedEmployees == null) {
                loadedEmployees = new ArrayList<>(); // Ensure it's initialized to avoid null
            }

            // Debugging: Print loaded employees to confirm data
            System.out.println("Loaded Employees: ");
            for (Employee employee : loadedEmployees) {
                System.out.println(employee);
            }

        } catch (IOException e) {
            System.out.println("No file found or error loading file. Starting fresh.");
        }
        return loadedEmployees; // Always return an initialized list
    }
}
