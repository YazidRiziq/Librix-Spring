package com.example.librix_spring.model;

public class BookCopyModel {
    
    private String copyCode;
    private String bookCode;
    private String bookStatus;
    private String copyNumber;

    public BookCopyModel() {}

    public BookCopyModel(String copyCode, String bookCode, String bookStatus, String copyNumber) {
        this.copyCode = copyCode;
        this.bookCode = bookCode;
        this.bookStatus = bookStatus;
        this.copyNumber = copyNumber;
    }

    public String getCopyCode() {
        return copyCode;
    }

    public void setCopyCode(String copyCode) {
        this.copyCode = copyCode;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

}
