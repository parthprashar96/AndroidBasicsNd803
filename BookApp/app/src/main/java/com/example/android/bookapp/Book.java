package com.example.android.bookapp;

public class Book {
    private String mBookName;
    private String mAuthor;
    private String mPublisher;

    public Book(String bookName, String author, String publisher) {
        mBookName = bookName;
        mAuthor = author;
        mPublisher = publisher;
    }

    public String getBookName() {
        return mBookName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublisher() {
        return mPublisher;
    }

   }