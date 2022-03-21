package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Film> films = new HashSet<>();
}
