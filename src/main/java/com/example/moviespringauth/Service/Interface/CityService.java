package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.City;

import java.util.List;

public interface CityService {
    City saveCity(City city);
    List<City> saveCities(List<City> cities);
    List<City> getCities();
    City getCityByNameOfCity(String nameOfCity);
    String deleteCity(Long cityId);
    City updateCity(City city);
}
