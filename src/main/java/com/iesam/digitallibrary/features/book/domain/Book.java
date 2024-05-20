package com.iesam.digitallibrary.features.book.domain;

public class Book {
    protected String title;
    protected String author;
    protected String ISBN;
    protected String editorial;
    protected int year;

    public Book(String title, String author, String ISBN, String editorial, int year) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nEditorial: " + editorial + "\nYear: " + year;
    }
}
