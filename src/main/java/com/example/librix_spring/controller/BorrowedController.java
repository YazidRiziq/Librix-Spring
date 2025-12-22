package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.BorrowedModel;
import com.example.librix_spring.service.BorrowedService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Borrowed", description = "API Borrowed Management")
@RestController
@RequestMapping("api/borrowed")
public class BorrowedController {
    
    private final BorrowedService borrowedService;

    public BorrowedController(BorrowedService borrowedService) {
        this.borrowedService = borrowedService;
    }

    @Operation(
        summary = "Get all Borrowed Books",
        description = "Menampilkan semua data Buku yang Dipinjam"
    )
    @GetMapping()
    public ResponseEntity<List<BorrowedModel>> getAllBorrowedRecords() {
        List<BorrowedModel> borrowedRecords = borrowedService.getAllBorrowedRecords();
        return ResponseEntity.ok(borrowedRecords);
    }

    @Operation(
        summary = "Delete a Borrowed Book Record",
        description = "Menghapus data Buku yang Dipinjam berdasarkan CopyCode dan LoanCode"
    )
    @DeleteMapping("/{copyCode}/{loanCode}")
    public ResponseEntity<String> deleteBorrowed(
        @PathVariable String copyCode,
        @PathVariable String loanCode
    ) {
        borrowedService.deleteBorrowed(copyCode, loanCode);
        return ResponseEntity.ok("Borrowed record with CopyCode: " + copyCode + " and LoanCode: " + loanCode + " has been deleted.");
    }

}
