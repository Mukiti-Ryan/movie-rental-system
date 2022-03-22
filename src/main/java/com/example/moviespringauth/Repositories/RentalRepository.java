package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Customer;
import com.example.moviespringauth.Entities.Rental;
import com.example.moviespringauth.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Rental findByRentalDate(Timestamp rentalDate);
    Rental findByReturnDate(Timestamp returnDate);
    Rental findByCustomer1(Customer customer1);
    Rental findByStaff1(Staff staff1);
}
