package com.example.librix_spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.librix_spring.model.BookModel;
import com.example.librix_spring.service.BookService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book", description = "API Book Management")
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @Operation(
        summary = "Get all Books",
        description = "Menampilkan semua data Buku"
    )
    @GetMapping()
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Operation(
        summary = "Get Book by Id",
        description = "Mengambil data Buku berdasarkan Id"
    )
    @GetMapping("/{bookCode}")
    public ResponseEntity<BookModel> getBookById(@PathVariable String bookCode) {
        return ResponseEntity.ok(bookService.getBookById(bookCode));
    }

    @Operation(
        summary = "Post new Book",
        description = "Digunakan untuk menambahkan data Buku baru"
    )
    @PostMapping()
    public ResponseEntity<String> createBook(@RequestParam String catName, @RequestBody BookModel bookModel) {
        bookService.createBook(catName, bookModel);
        return new ResponseEntity<>("Book created successfully", HttpStatus.CREATED);
    }

    @Operation(
        summary = "Update Book",
        description = "Digunakan untuk memperbarui data Buku berdasarkan Id"
    )
    @PutMapping("/{bookCode}")
    public ResponseEntity<String> updateBook(@PathVariable String bookCode, @RequestBody BookModel bookModel) {
        bookService.updateBook(bookCode, bookModel);
        return ResponseEntity.ok("Book updated successfully");
    }

    @Operation(
        summary = "Delete Book",
        description = "Digunakan untuk menghapus data Buku berdasarkan Id"
    )
    @DeleteMapping("/{bookCode}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookCode) {
        bookService.deleteBook(bookCode);
        return ResponseEntity.ok("Book deleted successfully");
    }

}
