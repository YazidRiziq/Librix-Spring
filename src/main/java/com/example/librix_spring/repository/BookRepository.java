package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.BookModel;

@Repository
public class BookRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BookModel> findAllBooks() {
        return jdbcTemplate.query(
            "SELECT * FROM book",
            (rs, rowNum) -> {
                BookModel b = new BookModel();
                b.setBookCode(rs.getString("BookCode"));
                b.setCatCode(rs.getString("CatCode"));
                b.setISBN(rs.getString("ISBN"));
                b.setBookTitle(rs.getString("BookTitle"));
                b.setAutName(rs.getString("AutName"));
                b.setPublisher(rs.getString("Publisher"));
                b.setPubYear(rs.getInt("PubYear"));
                b.setNumPages(rs.getInt("NumPages"));
                b.setTotalCopies(rs.getInt("TotalCopies"));
                return b;
            }
        );
    }

    public BookModel findById(String bookCode) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM book WHERE BookCode = ?",
            (rs, rowNum) -> {
                BookModel b = new BookModel();
                b.setBookCode(rs.getString("BookCode"));
                b.setCatCode(rs.getString("CatCode"));
                b.setISBN(rs.getString("ISBN"));
                b.setBookTitle(rs.getString("BookTitle"));
                b.setAutName(rs.getString("AutName"));
                b.setPublisher(rs.getString("Publisher"));
                b.setPubYear(rs.getInt("PubYear"));
                b.setNumPages(rs.getInt("NumPages"));
                b.setTotalCopies(rs.getInt("TotalCopies"));
                return b;
            },
            bookCode
        );
    }

    public void insertBook(String catName, BookModel b){
        jdbcTemplate.update(
            "CALL AddBook(?, ?, ?, ?, ?, ?, ?, ?)",
            catName,
            b.getISBN(),
            b.getBookTitle(),
            b.getAutName(),
            b.getPublisher(),
            b.getPubYear(),
            b.getNumPages(),
            b.getTotalCopies()
        );
    }

    public int updateBook(String bookCode, BookModel b){
        return jdbcTemplate.update(
            "UPDATE book SET ISBN = ?, BookTitle = ?, AutName = ?, Publisher = ?, PubYear = ?, NumPages = ? WHERE BookCode = ?",
            b.getISBN(),
            b.getBookTitle(),
            b.getAutName(),
            b.getPublisher(),
            b.getPubYear(),
            b.getNumPages(),
            bookCode
        );
    }

    public int deleteBook(String bookCode){
        return jdbcTemplate.update(
            "DELETE FROM book WHERE BookCode = ?",
            bookCode
        );
    }

}
