package com.example.librix_spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.librix_spring.model.CategoryModel;

@Repository
public class CategoryRepository {
    
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CategoryModel> findAllCategories() {
        return jdbcTemplate.query(
            "SELECT * FROM bookcategory",
            (rs, rowNum) -> {
                CategoryModel bc = new CategoryModel();
                bc.setCatCode(rs.getString("CatCode"));
                bc.setCatName(rs.getString("CatName"));
                return bc;
            }
        );
    }

    public CategoryModel findByCode(String catCode) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM bookcategory WHERE CatCode = ?",
            (rs, rowNum) -> {
                CategoryModel bc = new CategoryModel();
                bc.setCatCode(rs.getString("CatCode"));
                bc.setCatName(rs.getString("CatName"));
                return bc;
            },
            catCode
        );
    }

    public void insertCategory(CategoryModel bookCategoryModel) {
        jdbcTemplate.update(
            "Call AddCategory(?)",
            bookCategoryModel.getCatName()
        );
    }

    public int updateCategory(String catCode, CategoryModel bookCategoryModel) {
        return jdbcTemplate.update(
            "UPDATE bookcategory SET CatName = ? WHERE CatCode = ?",
            bookCategoryModel.getCatName(),
            catCode
        );
    }

    public int deleteCategory(String catCode) {
        return jdbcTemplate.update(
            "DELETE FROM bookcategory WHERE CatCode = ?",
            catCode
        );
    }

}
