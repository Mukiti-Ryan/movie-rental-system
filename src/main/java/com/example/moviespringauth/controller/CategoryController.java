package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Category;
import com.example.moviespringauth.Service.Interface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>>getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @GetMapping("/{nameOfCategory}")
    public Category findCategoryByNameOfCategory(@PathVariable String nameOfCategory) {
        return categoryService.getCategoryByNameOfCategory(nameOfCategory);
    }

    @PostMapping("/save")
    public ResponseEntity<Category>saveCategory(@RequestBody Category category) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/category/save").toUriString());
        return ResponseEntity.created(uri).body(categoryService.saveCategory(category));
    }

    @PostMapping("/saveCategories")
    public List<Category> addCategories(@RequestBody List<Category> categories) {
        return categoryService.saveCategories(categories);
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
