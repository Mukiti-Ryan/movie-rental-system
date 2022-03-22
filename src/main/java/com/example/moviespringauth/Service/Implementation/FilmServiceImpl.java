package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Film;
import com.example.moviespringauth.Repositories.FilmRepository;
import com.example.moviespringauth.Service.Interface.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public Film saveFilm(Film film) {
        log.info("Saving new film {} to the database", film.getTitle());
        return filmRepository.save(film);
    }

    @Override
    public List<Film> saveFilms(List<Film> films) {
        log.info("Saving new films to the database");
        return filmRepository.saveAll(films);
    }

    @Override
    public List<Film> getFilms() {
        log.info("Fetching all films");
        return filmRepository.findAll();
    }

    @Override
    public Film getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    @Override
    public Film getFilmByYearOfRelease(int yearOfRelease) {
        return filmRepository.findByYearOfRelease(yearOfRelease);
    }

    @Override
    public Film getFilmByRating(int rating) {
        return filmRepository.findByRating(rating);
    }

    @Override
    public Film getFilmByLength(int length) {
        return filmRepository.findByLength(length);
    }

    @Override
    public String deleteFilm(Long filmId) {
        filmRepository.deleteById(filmId);
        return "Film has been removed!!" +filmId;
    }

    @Override
    public Film updateFilm(Film film) {
        Film existingFilm = filmRepository.findById(film.getFilmId()).orElse(null);
        existingFilm.setTitle(film.getTitle());
        existingFilm.setRentalDuration(film.getRentalDuration());
        existingFilm.setRentalRate(film.getRentalRate());
        existingFilm.setDescription(film.getDescription());
        existingFilm.setYearOfRelease(film.getYearOfRelease());
        existingFilm.setLength(film.getLength());
        existingFilm.setReplacementCost(film.getReplacementCost());
        existingFilm.setRating(film.getRating());
        existingFilm.setSpecialFeatures(film.getSpecialFeatures());
        existingFilm.setFullText(film.getFullText());
        existingFilm.setActors(film.getActors());
        existingFilm.setCategories(film.getCategories());
        existingFilm.setLanguage1(film.getLanguage1());
        return filmRepository.save(existingFilm);
    }
}
