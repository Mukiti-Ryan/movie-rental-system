package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;

import static javax.persistence.FetchType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;

    @ManyToMany(fetch = LAZY)
    private Collection<Film> films = new HashSet<>();
}
