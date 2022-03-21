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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private int amount;
    private Timestamp paymentDate;

    @ManyToOne
    private Rental rental1;

    @ManyToOne
    private Customer customer1;

    @ManyToOne
    private Staff staff1;
}
