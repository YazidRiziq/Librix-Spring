package com.example.librix_spring.model;

public class CategoryModel {
    
    private String catCode;
    private String catName;

    public CategoryModel() {}

    public CategoryModel(String catCode, String catName) {
        this.catCode = catCode;
        this.catName = catName;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

}
