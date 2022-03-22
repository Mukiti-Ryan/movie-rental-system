package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.City;
import com.example.moviespringauth.Repositories.CityRepository;
import com.example.moviespringauth.Service.Interface.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City saveCity(City city) {
        log.info("Saving new city {} to the database", city.getNameOfCity());
        return cityRepository.save(city);
    }

    @Override
    public List<City> saveCities(List<City> cities) {
        log.info("Saving new countries to the database");
        return cityRepository.saveAll(cities);
    }

    @Override
    public List<City> getCities() {
        log.info("Fetching all cities");
        return cityRepository.findAll();
    }

    @Override
    public City getCityByNameOfCity(String nameOfCity) {
        return cityRepository.findByNameOfCity(nameOfCity);
    }

    @Override
    public String deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
        return "City has been removed!!" +cityId;
    }

    @Override
    public City updateCity(City city) {
        City existingCity = cityRepository.findById(city.getCityId()).orElse(null);
        existingCity.setNameOfCity(city.getNameOfCity());
        existingCity.setAddresses(city.getAddresses());
        existingCity.setCountry1(city.getCountry1());
        return cityRepository.save(existingCity);
    }
}
