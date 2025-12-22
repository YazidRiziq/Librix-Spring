package com.example.librix_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librix_spring.model.BorrowedModel;
import com.example.librix_spring.repository.BorrowedRepository;

@Service
public class BorrowedService {
    
    private final BorrowedRepository borrowedRepository;

    public BorrowedService(BorrowedRepository borrowedRepository) {
        this.borrowedRepository = borrowedRepository;
    }

    public List<BorrowedModel> getAllBorrowedRecords() {
        return borrowedRepository.getAllBorrowedRecords();
    }

    public int deleteBorrowed(String copyCode, String loanCode) {
        int delete = borrowedRepository.deleteBorrowed(copyCode, loanCode);
        if (delete == 0) {
            throw new IllegalArgumentException("No borrowed record found with CopyCode: " + copyCode + " and LoanCode: " + loanCode);
        }
        return delete;
    }

}