package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.BookCopyModel;
import com.example.librix_spring.service.BookCopyService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book Copy", description = "API Book Copy Management")
@RestController
@RequestMapping("api/bookcopies")
public class BookCopyController {
    
    private final BookCopyService bookCopyService;
    
    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @Operation(
        summary = "Get all Book Copies",
        description = "Mengambil semua data Book Copy"
    )
    @GetMapping()
    public ResponseEntity<List<BookCopyModel>> getAllBookCopies() {
        return ResponseEntity.ok(bookCopyService.getAllBookCopies());
    }

    @Operation(
        summary = "Delete Book Copy by Copy Code",
        description = "Menghapus data Book Copy berdasarkan Copy Code"
    )
    @DeleteMapping("/{copyCode}")
    public ResponseEntity<String> deleteBookCopy(@PathVariable String copyCode) {
        bookCopyService.deleteBookCopy(copyCode);
        return ResponseEntity.ok("Book copy with code " + copyCode + " has been deleted.");
    }

}
