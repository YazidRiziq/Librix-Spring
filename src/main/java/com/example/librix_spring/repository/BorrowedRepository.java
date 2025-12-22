package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.BorrowedModel;

@Repository
public class BorrowedRepository {
    
    private JdbcTemplate jdbcTemplate;

    public BorrowedRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BorrowedModel> getAllBorrowedRecords() {
        return jdbcTemplate.query(
            "SELECT * FROM borrowedbook",
            (rs, rowNum) -> {
                BorrowedModel b = new BorrowedModel();
                b.setCopyCode(rs.getString("CopyCode"));
                b.setLoanCode(rs.getString("LoanCode"));
                b.setReturnCond(rs.getString("ReturnCond"));
                b.setActualReturnDate(rs.getString("ActualReturnDate"));
                b.setOverdueFine(rs.getString("OverdueFine"));
                return b;
            }
        );
    }

    public int deleteBorrowed(String copyCode, String loanCode) {
        return jdbcTemplate.update(
            "DELETE FROM borrowedbook WHERE CopyCode = ? AND LoanCode = ?",
            copyCode,
            loanCode
        );
    }

}
