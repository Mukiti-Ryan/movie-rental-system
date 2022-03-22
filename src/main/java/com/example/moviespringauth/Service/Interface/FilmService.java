package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Film;

import java.util.List;

public interface FilmService {
    Film saveFilm(Film film);
    List<Film> saveFilms(List<Film> films);
    List<Film> getFilms();
    Film getFilmByTitle(String title);
    Film getFilmByYearOfRelease(int yearOfRelease);
    Film getFilmByRating(int rating);
    Film getFilmByLength(int length);
    String deleteFilm(Long filmId);
    Film updateFilm(Film film);
}
