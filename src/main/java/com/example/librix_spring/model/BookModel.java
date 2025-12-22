package com.example.librix_spring.model;

public class BookModel {
    
    private String bookCode;
    private String catCode;
    private String ISBN;
    private String bookTitle;
    private String autName;
    private String publisher;
    private int pubYear;
    private int numPages;
    private int totalCopies;

    public BookModel() {}

    public BookModel(String bookCode, String catCode, String ISBN, String bookTitle, String autName, String publisher, int pubYear, int numPages, int totalCopies) {
        this.bookCode = bookCode;
        this.catCode = catCode;
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.autName = autName;
        this.publisher = publisher;
        this.pubYear = pubYear;
        this.numPages = numPages;
        this.totalCopies = totalCopies;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAutName() {
        return autName;
    }

    public void setAutName(String autName) {
        this.autName = autName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

}
