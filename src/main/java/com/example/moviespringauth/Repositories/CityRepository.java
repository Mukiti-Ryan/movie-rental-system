package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByNameOfCity(String nameOfCity);
}
