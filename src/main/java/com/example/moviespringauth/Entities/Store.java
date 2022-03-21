package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;
    private Timestamp lastUpdate;

    @ManyToOne
    private Address address1;

    @OneToMany
    private Collection<Staff> staff;
}
