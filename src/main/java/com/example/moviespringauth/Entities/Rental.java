package com.example.moviespringauth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long rentalId;
    private Timestamp rentalDate;
    private Timestamp returnDate;
    private Timestamp lastUpdate;

    @ManyToOne
    private Staff staff1;

    @ManyToOne
    private Customer customer1;
}
