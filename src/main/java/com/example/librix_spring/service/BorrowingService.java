package com.example.librix_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librix_spring.model.BorrowingModel;
import com.example.librix_spring.repository.BorrowingRepository;

@Service
public class BorrowingService {
    
    private final BorrowingRepository borrowingRepository;

    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    public List<BorrowingModel> getAllBorrowings() {
        return borrowingRepository.getAllBorrowings();
    }

    public void addBorrowing(String offName, String memName, String bookTitle, String quantity) {
        borrowingRepository.addBorrowing(offName, memName, bookTitle, quantity);
    }

    public int deleteBorrowing(String loanCode) {
        int delete = borrowingRepository.deleteBorrowing(loanCode);
        if (delete == 0) {
            throw new RuntimeException("Borrowing not found with loanCode: " + loanCode);
        }
        return delete;
    }

}
