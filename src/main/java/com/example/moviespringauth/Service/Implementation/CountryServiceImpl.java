package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Country;
import com.example.moviespringauth.Repositories.CountryRepository;
import com.example.moviespringauth.Service.Interface.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country saveCountry(Country country) {
        log.info("Saving new country {} to the database", country.getNameOfCountry());
        return countryRepository.save(country);
    }

    @Override
    public List<Country> saveCountries(List<Country> countries) {
        log.info("Saving new countries to the database");
        return countryRepository.saveAll(countries);
    }

    @Override
    public List<Country> getCountries() {
        log.info("Fetching all countries");
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryByNameOfCountry(String nameOfCountry) {
        return countryRepository.findByNameOfCountry(nameOfCountry);
    }

    @Override
    public String deleteCountry(Long countryId) {
        countryRepository.deleteById(countryId);
        return "Country has been removed!!" +countryId;
    }

    @Override
    public Country updateCountry(Country country) {
        Country existingCountry = countryRepository.findById(country.getCountryId()).orElse(null);
        existingCountry.setNameOfCountry(country.getNameOfCountry());
        return countryRepository.save(existingCountry);
    }
}
