package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Category;
import com.example.moviespringauth.Repositories.CategoryRepository;
import com.example.moviespringauth.Service.Interface.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category saveCategory(Category category) {
        log.info("Saving new category {} to the database", category.getNameOfCategory());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> saveCategories(List<Category> categories) {
        log.info("Saving new categories to the database");
        return categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getCategories() {
        log.info("Fetching all categories");
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByNameOfCategory(String nameOfCategory) {
        return categoryRepository.findByNameOfCategory(nameOfCategory);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        return "Category has been removed!!" +categoryId;
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getCategoryId()).orElse(null);
        existingCategory.setNameOfCategory(category.getNameOfCategory());
        existingCategory.setFilms(category.getFilms());
        return categoryRepository.save(existingCategory);
    }
}
