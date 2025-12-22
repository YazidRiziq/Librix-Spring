package com.example.librix_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librix_spring.model.BookModel;
import com.example.librix_spring.repository.BookRepository;

@Service
public class BookService {
    
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public BookModel getBookById(String bookCode) {
        BookModel bm = bookRepository.findById(bookCode);
        if (bm == null) {
            throw new RuntimeException("Book not found with BookCode: " + bookCode);
        }
        return bm;
    }

    public void createBook(String catName, BookModel bookModel) {
        bookRepository.insertBook(catName, bookModel);
    }

    public void updateBook(String bookCode, BookModel bookModel) {
        int update = bookRepository.updateBook(bookCode, bookModel);
        if (update == 0) {
            throw new RuntimeException("Book not found with BookCode: " + bookCode);
        }
    }

    public void deleteBook(String bookCode) {
        int delete = bookRepository.deleteBook(bookCode);
        if (delete == 0) {
            throw new RuntimeException("Book not found with BookCode: " + bookCode);
        }
    }

}