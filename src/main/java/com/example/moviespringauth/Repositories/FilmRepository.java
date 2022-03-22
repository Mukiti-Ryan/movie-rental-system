package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByTitle(String title);
    Film findByYearOfRelease(int yearOfRelease);
    Film findByRating(int rating);
    Film findByLength(int length);
//    TODO: SEARCH FOR FILM BY A CERTAIN TYPE OF LETTERS
//    TODO: Add Search parameters for the following: CategoryRepository, ActorRepository/Actress
}
