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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    private String address;
    private String address2;
    private Long district;
    private String postalCode;
    private String phoneNumber;
    private Timestamp lastUpdate;

    @OneToMany
    private Collection<Staff> staffs = new ArrayList<>();

    @OneToMany
    private Collection<Customer> customers = new ArrayList<>();

    @OneToMany
    private Collection<Store> stores = new ArrayList<>();

    @ManyToOne
    private City city1;
}
