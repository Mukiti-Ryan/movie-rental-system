package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    List<Country> saveCountries(List<Country> countries);
    List<Country> getCountries();
    Country getCountryByNameOfCountry(String nameOfCountry);
    String deleteCountry(Long countryId);
    Country updateCountry(Country country);
}
