package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> saveCategories(List<Category> categories);
    List<Category> getCategories();
    Category getCategoryByNameOfCategory(String nameOfCategory);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category);
}
