package com.lib.models;

public class BorrowRecord {

    private String studentName;
    private String bookTitle;
    private String dueDate;

    public BorrowRecord(String studentName, String bookTitle, String dueDate) {
        this.studentName = studentName;
        this.bookTitle = bookTitle;
        this.dueDate = dueDate;
    }

    public void displayRecord() {
        System.out.println(studentName + " borrowed "
                + bookTitle + " | Due Date: " + dueDate);
    }
}
