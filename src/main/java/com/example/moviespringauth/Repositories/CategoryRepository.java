package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameOfCategory(String nameOfCategory);
}
