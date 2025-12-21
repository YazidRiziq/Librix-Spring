package com.example.librix_spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librix_spring.model.CategoryModel;
import com.example.librix_spring.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository bookCategoryRepository;

    public CategoryService(CategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    public List<CategoryModel> getAllCategories() {
        return bookCategoryRepository.findAllCategories();
    }

    public CategoryModel getCategoryByCode(String catCode) {
        return bookCategoryRepository.findByCode(catCode);
    }

    public void createCategory(CategoryModel bookCategoryModel) {
        bookCategoryRepository.insertCategory(bookCategoryModel);
    }
    
    public void updateCategory(String catCode, CategoryModel bookCategoryModel) {
        int update = bookCategoryRepository.updateCategory(catCode, bookCategoryModel);
        if (update == 0) {
            throw new RuntimeException("Category not found with catCode: " + catCode);
        }
    }

    public void deleteCategory(String catCode) {
        int delete = bookCategoryRepository.deleteCategory(catCode);
        if (delete == 0) {
            throw new RuntimeException("Category not found with catCode: " + catCode);
        }
    }

}