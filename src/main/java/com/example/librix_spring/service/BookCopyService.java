package com.example.librix_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librix_spring.model.BookCopyModel;
import com.example.librix_spring.repository.BookCopyRepository;

@Service
public class BookCopyService {
    
    private final BookCopyRepository bookCopyRepository;

    public BookCopyService(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    public List<BookCopyModel> getAllBookCopies() {
        return bookCopyRepository.findAllBookCopies();
    }

    public int deleteBookCopy(String copyCode) {
        int delete =  bookCopyRepository.deleteBookCopy(copyCode);
        if (delete == 0) {
            throw new RuntimeException("Book copy with code " + copyCode + " not found.");
        }
        return delete;
    }

}
