package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByNameOfCountry(String nameOfCountry);
}
