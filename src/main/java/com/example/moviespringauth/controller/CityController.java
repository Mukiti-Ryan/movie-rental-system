package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.City;
import com.example.moviespringauth.Service.Interface.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities() {
        return ResponseEntity.ok().body(cityService.getCities());
    }

    @GetMapping("/{nameOfCity}")
    public City findCityByNameOfCity(@PathVariable String nameOfCity) {
        return cityService.getCityByNameOfCity(nameOfCity);
    }

    @PostMapping("/save")
    public ResponseEntity<City>saveCity(@RequestBody City city) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/city/save").toUriString());
        return ResponseEntity.created(uri).body(cityService.saveCity(city));
    }

    @PostMapping("/saveCities")
    public List<City> addCities(@RequestBody List<City> cities) {
        return cityService.saveCities(cities);
    }

    @PutMapping("/update")
    public City updateCity(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("/delete/{cityId}")
    public String deleteCity(@PathVariable Long cityId) {
        return cityService.deleteCity(cityId);
    }
}
