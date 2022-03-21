package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long filmId;
    private String title;
    private int rentalDuration;
    private int rentalRate;
    private String description;
    private int yearOfRelease;
    private int length;
    private int replacementCost;
    private int rating;
    private Timestamp lastUpdate;
    private String specialFeatures;
    private String fullText;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "film_actor_tbl",
            joinColumns = {@JoinColumn( name = "actorId")},
            inverseJoinColumns = {@JoinColumn(name = "filmId")})
    private Collection<Actor> actors;

    @ManyToMany(fetch = EAGER)
    @JoinTable(name = "film_category_tbl",
            joinColumns = {@JoinColumn(name = "categoryId")},
            inverseJoinColumns = {@JoinColumn(name = "filmId")})
    private Collection<Category> categories;

    @ManyToOne
    private Language language1;
}
