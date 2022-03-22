package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Language;
import com.example.moviespringauth.Service.Interface.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/language")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/languages")
    public ResponseEntity<List<Language>> getLanguages() {
        return ResponseEntity.ok().body(languageService.getLanguages());
    }

    @GetMapping("/{nameOfLanguage}")
    public Language findLanguageByNameOfLangauge(@PathVariable String nameOfLanguage) {
        return languageService.getLanguageByNameOfLanguage(nameOfLanguage);
    }

    @PostMapping("/save")
    public ResponseEntity<Language>saveLanguage(@RequestBody Language language) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/language/save").toUriString());
        return ResponseEntity.created(uri).body(languageService.saveLanguage(language));
    }

    @PostMapping("/saveLanguages")
    public List<Language> addLanguages(@RequestBody List<Language> languages) {
        return languageService.saveLanguages(languages);
    }

    @PutMapping("/update")
    public Language updateLanguage(@RequestBody Language language) {
        return languageService.updateLanguage(language);
    }

    @DeleteMapping("/delete/{languageId}")
    public String deleteLanguage(@PathVariable Long languageId) {
        return languageService.deleteLanguage(languageId);
    }
}
