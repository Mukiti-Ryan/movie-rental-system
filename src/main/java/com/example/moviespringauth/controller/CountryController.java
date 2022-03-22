package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Country;
import com.example.moviespringauth.Service.Interface.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok().body(countryService.getCountries());
    }

    @GetMapping("/{nameOfCountry}")
    public Country findCountryByNameOfCountry(@PathVariable String nameOfCountry) {
        return countryService.getCountryByNameOfCountry(nameOfCountry);
    }

    @PostMapping("/save")
    public ResponseEntity<Country>saveCountry(@RequestBody Country country) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/country/save").toUriString());
        return ResponseEntity.created(uri).body(countryService.saveCountry(country));
    }

    @PostMapping("/saveCountries")
    public List<Country> addCountries(@RequestBody List<Country> countries) {
        return countryService.saveCountries(countries);
    }

    @PutMapping("/update")
    public Country updateCountry(@RequestBody Country country) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/delete/{countryId}")
    public String deleteCountry(@PathVariable Long countryId) {
        return countryService.deleteCountry(countryId);
    }
}
