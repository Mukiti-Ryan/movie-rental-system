package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long languageId;
    private String nameOfLanguage;
    private Timestamp lastUpdate;

    @OneToMany
    private Collection<Film> films = new ArrayList<>();
}
