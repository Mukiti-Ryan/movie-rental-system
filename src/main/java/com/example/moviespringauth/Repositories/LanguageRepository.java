package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByNameOfLanguage(String nameOfLanguage);
}
