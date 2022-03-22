package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Rental;

import java.sql.Timestamp;
import java.util.List;

public interface RentalService {
    Rental saveRental(Rental rental);
    List<Rental> saveRentals(List<Rental> rentals);
    List<Rental> getRentals();
    String deleteRental(Long rentalId);
    Rental updateRental(Rental rental);
    Rental getRentalByRentalDate(Timestamp rentalDate);
    Rental getRentalByReturnDate(Timestamp returnDate);
}
