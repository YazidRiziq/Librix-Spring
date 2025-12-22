package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.BookCopyModel;

@Repository
public class BookCopyRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public BookCopyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookCopyModel> findAllBookCopies() {
        return jdbcTemplate.query(
            "SELECT * FROM bookcopy",
            (rs, rowNum) -> {
                BookCopyModel bc = new BookCopyModel();
                bc.setCopyCode(rs.getString("CopyCode"));
                bc.setBookCode(rs.getString("BookCode"));
                bc.setBookStatus(rs.getString("BookStatus"));
                bc.setCopyNumber(rs.getString("CopyNumber"));
                return bc;
            }
        );
    }

    public int deleteBookCopy(String copyCode) {
        return jdbcTemplate.update(
            "DELETE FROM bookcopy WHERE CopyCode = ?",
            copyCode
        );
    }


}
