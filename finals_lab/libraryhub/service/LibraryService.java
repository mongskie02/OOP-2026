package com.lib.service;

import com.lib.models.Book;
import com.lib.models.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> books = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<String> records = new ArrayList<>();

    public LibraryService() {
    }

    public LibraryService(JSONObject json) {

        books = new ArrayList<>();
        students = new ArrayList<>();
        records = new ArrayList<>();

        if (json == null) return;

        JSONArray bookArray = json.optJSONArray("books");
        if (bookArray != null) {
            for (int i = 0; i < bookArray.length(); i++) {
                JSONObject obj = bookArray.getJSONObject(i);

                books.add(new Book(
                        obj.getInt("id"),
                        obj.getString("title"),
                        obj.getString("author")
                ));
            }
        }

        JSONArray studentArray = json.optJSONArray("students");
        if (studentArray != null) {
            for (int i = 0; i < studentArray.length(); i++) {
                JSONObject obj = studentArray.getJSONObject(i);

                students.add(new Student(
                        obj.getInt("id"),
                        obj.getString("name")
                ));
            }
        }

        JSONArray recordArray = json.optJSONArray("records");
        if (recordArray != null) {
            for (int i = 0; i < recordArray.length(); i++) {
                records.add(recordArray.getString(i));
            }
        }
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        JSONArray bookArray = new JSONArray();
        for (Book b : books) {
            JSONObject obj = new JSONObject();
            obj.put("id", b.getId());
            obj.put("title", b.getTitle());
            obj.put("author", b.getAuthor());
            bookArray.put(obj);
        }

        JSONArray studentArray = new JSONArray();
        for (Student s : students) {
            JSONObject obj = new JSONObject();
            obj.put("id", s.getId());
            obj.put("name", s.getName());
            studentArray.put(obj);
        }

        JSONArray recordArray = new JSONArray();
        for (String r : records) {
            recordArray.put(r);
        }

        json.put("books", bookArray);
        json.put("students", studentArray);
        json.put("records", recordArray);

        return json;
    }

    // BOOKS
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }

    public void displayBooks() {
        System.out.println("Books:");
        for (Book b : books) {
            System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor());
        }
    }

    // STUDENTS
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added.");
    }

    public void displayStudents() {
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }

    // BORROW
    public void borrowBook(int bookId, String studentName, String dueDate) {
        String record = "Book ID " + bookId +
                " borrowed by " + studentName +
                " due " + dueDate;

        records.add(record);

        System.out.println("Book borrowed successfully.");
    }

    // RETURN
    public void returnBook(int bookId) {
        records.add("Book ID " + bookId + " returned");
        System.out.println("Book returned successfully.");
    }

    // RECORDS
    public void displayRecords() {
        System.out.println("Borrow Records:");
        for (String r : records) {
            System.out.println(r);
        }
    }
}