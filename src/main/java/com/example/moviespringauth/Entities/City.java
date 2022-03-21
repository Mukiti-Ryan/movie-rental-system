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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    private String nameOfCity;
    private Timestamp lastUpdate;

    @OneToMany
    private Collection<Address> addresses = new ArrayList<>();

    @ManyToOne
    private Country country1;
}
