package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Language;

import java.util.List;

public interface LanguageService {
    Language saveLanguage(Language language);
    List<Language> saveLanguages(List<Language> languages);
    List<Language> getLanguages();
    String deleteLanguage(Long languageId);
    Language updateLanguage(Language language);
    Language getLanguageByNameOfLanguage(String nameOfLanguage);
}