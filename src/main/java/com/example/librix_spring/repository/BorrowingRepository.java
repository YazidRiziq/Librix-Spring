package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.BorrowingModel;

@Repository
public class BorrowingRepository {
    
    private JdbcTemplate jdbcTemplate;

    public BorrowingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BorrowingModel> getAllBorrowings() {
        return jdbcTemplate.query(
            "SELECT * FROM borrowing", 
            (rs, rowNum) -> new BorrowingModel(
                rs.getString("LoanCode"),
                rs.getString("OffID"),
                rs.getString("MemID"),
                rs.getString("LoanDate"),
                rs.getString("ReturnDate")
            ));
    }

    public void addBorrowing(String offName, String memName, String bookTitle, String quantity) {
        jdbcTemplate.update(
            "Call AddBorrowing (?, ?, ?, ?)",
            offName,
            memName,
            bookTitle,
            quantity
        );
    }

    public int deleteBorrowing(String loanCode) {
        return jdbcTemplate.update(
            "DELETE FROM borrowing WHERE LoanCode = ?",
            loanCode
        );
    }

}
