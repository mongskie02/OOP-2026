package com.lib;

import com.lib.models.Book;
import com.lib.models.Student;
import com.lib.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService library = new LibraryService();

        int choice;

        do {

            System.out.println("\n===== LIBRARY HUB =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Student");
            System.out.println("4. View Students");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Borrow Records");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author);

                    library.addBook(book);

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    Student student =
                            new Student(studentId, studentName);

                    library.addStudent(student);

                    break;

                case 4:

                    library.displayStudents();

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    int borrowId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String borrower = sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.nextLine();

                    library.borrowBook(
                            borrowId,
                            borrower,
                            dueDate
                    );

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                case 7:

                    library.displayRecords();

                    break;

                case 8:

                    System.out.println("Program Ended.");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}