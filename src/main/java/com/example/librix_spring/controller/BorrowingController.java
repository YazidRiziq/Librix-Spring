package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.BorrowingModel;
import com.example.librix_spring.service.BorrowingService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Borrowing", description = "API Borrowing Management")
@RestController
@RequestMapping("api/borrowings")
public class BorrowingController {
    
    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @Operation(
        summary = "Get all Borrowing Books",
        description = "Menampilkan semua data Peminjaman Buku"
    )
    @GetMapping()
    public ResponseEntity<List<BorrowingModel>> getAllBorrowings() {
        return ResponseEntity.ok(borrowingService.getAllBorrowings());
    }

    @Operation(
        summary = "Add a new Borrowing Book",
        description = "Menambahkan data Peminjaman Buku baru"
    )
    @PostMapping()
    public ResponseEntity<String> addBorrowing(String offName, String memName, String bookTitle, String quantity) {
        borrowingService.addBorrowing(offName, memName, bookTitle, quantity);
        return ResponseEntity.ok("Borrowing Book added successfully");
    }

    @Operation(
        summary = "Delete a Borrowing Book",
        description = "Menghapus data Peminjaman Buku berdasarkan LoanCode"
    )
    @DeleteMapping("/{loanCode}")
    public ResponseEntity<String> deleteBorrowing(@PathVariable String loanCode) {
        borrowingService.deleteBorrowing(loanCode);
        return ResponseEntity.ok("Borrowing Book deleted successfully");
    }

}
