package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Film;
import com.example.moviespringauth.Service.Interface.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getFilms() {
        return ResponseEntity.ok().body(filmService.getFilms());
    }

    @GetMapping("/{title}")
    public Film findFilmByTitle(@PathVariable String title) {
        return filmService.getFilmByTitle(title);
    }

    @GetMapping("/{yearOfRelease}")
    public Film findFilmByYearOfRelease(@PathVariable int yearOfRelease) {
        return filmService.getFilmByYearOfRelease(yearOfRelease);
    }

    @GetMapping("/{rating}")
    public Film findFilmByRating(@PathVariable int rating) {
        return filmService.getFilmByRating(rating);
    }

    @GetMapping("/{length}")
    public Film findFilmByLength(@PathVariable int length) {
        return filmService.getFilmByLength(length);
    }

    @PostMapping("/save")
    public ResponseEntity<Film>saveFilm(@RequestBody Film film) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/film/save").toUriString());
        return ResponseEntity.created(uri).body(filmService.saveFilm(film));
    }

    @PostMapping("/saveFilms")
    public List<Film> addFilms(@RequestBody List<Film> films) {
        return filmService.saveFilms(films);
    }

    @PutMapping("/update")
    public Film updateFilm(@RequestBody Film film) {
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/delete/{filmId}")
    public String deleteFilm(@PathVariable Long filmId) {
        return filmService.deleteFilm(filmId);
    }

}
