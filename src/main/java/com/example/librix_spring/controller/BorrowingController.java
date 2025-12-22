package com.example.librix_spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librix_spring.model.BorrowingModel;
import com.example.librix_spring.service.BorrowingService;

@RestController
@RequestMapping("api/borrowings")
public class BorrowingController {
    
    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping()
    public ResponseEntity<List<BorrowingModel>> getAllBorrowings() {
        return ResponseEntity.ok(borrowingService.getAllBorrowings());
    }

    @PostMapping()
    public ResponseEntity<String> addBorrowing(String offName, String memName, String bookTitle, String quantity) {
        borrowingService.addBorrowing(offName, memName, bookTitle, quantity);
        return ResponseEntity.ok("Borrowing Book added successfully");
    }

    @DeleteMapping("/{loanCode}")
    public ResponseEntity<String> deleteBorrowing(@PathVariable String loanCode) {
        borrowingService.deleteBorrowing(loanCode);
        return ResponseEntity.ok("Borrowing Book deleted successfully");
    }

}
