package com.gson.model;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        employees = FileHandler.load();

        int choice;
        do {
            System.out.println("\n--- Payroll System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Save Records");
            System.out.println("4. Load Records");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> FileHandler.save(employees);
                case 4 -> employees = FileHandler.load();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }


    private static void addEmployee() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.println("Select Type: 1. SALARIED  2. HOURLY");
        int typeChoice = sc.nextInt();

        if (typeChoice == 1) {
            System.out.print("Base Salary: ");
            double salary = sc.nextDouble();

            System.out.print("Bonus: ");
            double bonus = sc.nextDouble();

            employees.add(new SalariedEmployee(name, id, salary, bonus));
        } else if (typeChoice == 2) {
            System.out.print("Hours Worked: ");
            int hours = sc.nextInt();

            System.out.print("Hourly Rate: ");
            double rate = sc.nextDouble();

            employees.add(new HourlyEmployee(name, id, hours, rate));
        } else {
            System.out.println("Invalid type.");
        }
    }


    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}