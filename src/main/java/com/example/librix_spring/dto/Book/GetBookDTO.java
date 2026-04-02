package com.example.librix_spring.dto.Book;

public class GetBookDTO {
    
    private String bookCode;
    private String catCode;
    private String catName;
    private String isbn;
    private String bookTitle;
    private String autName;
    private String publisher;
    private int pubYear;
    private int numPages;
    private int totalCopies;

    public GetBookDTO() {}

    public GetBookDTO(String bookCode, String catCode, String catName, String isbn, String bookTitle, String autName,
            String publisher, int pubYear, int numPages, int totalCopies) {
        this.bookCode = bookCode;
        this.catCode = catCode;
        this.catName = catName;
        this.isbn = isbn;
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

    public String getCatCode() {
        return catCode;
    }

    public String getCatName() {
        return catName;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAutName() {
        return autName;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPubYear() {
        return pubYear;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

}