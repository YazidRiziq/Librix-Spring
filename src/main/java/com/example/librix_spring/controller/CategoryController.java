package com.example.librix_spring.controller;

import com.example.librix_spring.model.CategoryModel;
import com.example.librix_spring.service.CategoryService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category", description = "API Category Management")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(
        summary = "Get all Book Categories",
        description = "Menampilkan semua data Category Buku"
    )
    @GetMapping()
    public ResponseEntity<List<CategoryModel>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Operation(
        summary = "Get Book Category by Id",
        description = "Mengambil data Book Category berdasarkan Id"
    )
    @GetMapping("/{catCode}")
    public ResponseEntity<CategoryModel> getCategoryByCode(@PathVariable String catCode) {
        return ResponseEntity.ok(categoryService.getCategoryByCode(catCode));
    }

    @Operation(
        summary = "Post new Book Category",
        description = "Digunakan untuk menambahkan data Category Buku baru"
    )
    @PostMapping()
    public ResponseEntity<String> createCategory(@RequestBody CategoryModel category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }

    @Operation(
        summary = "Update Book Category",
        description = "Digunakan untuk memperbarui data Category Buku berdasarkan Id"
    )
    @PutMapping("/{catCode}")
    public ResponseEntity<String> updateCategory(@PathVariable String catCode, @RequestBody CategoryModel category) {
        categoryService.updateCategory(catCode, category);
        return ResponseEntity.ok("Category updated successfully");
    }

    @Operation(
        summary = "Delete Book Category",
        description = "Digunakan untuk menghapus data Category Buku berdasarkan Id"
    )
    @DeleteMapping("/{catCode}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("catCode") String catCode) {
        categoryService.deleteCategory(catCode);
        return ResponseEntity.noContent().build();
    }

}
