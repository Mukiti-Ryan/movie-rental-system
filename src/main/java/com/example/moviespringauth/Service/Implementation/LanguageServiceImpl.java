package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Language;
import com.example.moviespringauth.Repositories.LanguageRepository;
import com.example.moviespringauth.Service.Interface.LanguageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language saveLanguage(Language language) {
        log.info("Saving new language {} to the database", language.getNameOfLanguage());
        return languageRepository.save(language);
    }

    @Override
    public List<Language> saveLanguages(List<Language> languages) {
        log.info("Saving new languages to the database");
        return languageRepository.saveAll(languages);
    }

    @Override
    public List<Language> getLanguages() {
        log.info("Fetching all languages");
        return languageRepository.findAll();
    }

    @Override
    public String deleteLanguage(Long languageId) {
        languageRepository.deleteById(languageId);
        return "Language has been removed!!" +languageId;
    }

    @Override
    public Language updateLanguage(Language language) {
        Language existingLanguage = languageRepository.findById(language.getLanguageId()).orElse(null);
        existingLanguage.setNameOfLanguage(language.getNameOfLanguage());
        existingLanguage.setFilms(language.getFilms());
        return languageRepository.save(existingLanguage);
    }

    @Override
    public Language getLanguageByNameOfLanguage(String nameOfLanguage) {
        return languageRepository.findByNameOfLanguage(nameOfLanguage);
    }
}