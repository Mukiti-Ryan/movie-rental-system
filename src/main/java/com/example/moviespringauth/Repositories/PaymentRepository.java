package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Customer;
import com.example.moviespringauth.Entities.Payment;
import com.example.moviespringauth.Entities.Rental;
import com.example.moviespringauth.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByAmount(int amount);
//    TODO: ADD METHODS USING THE FOLLOWING
    Payment findByCustomer1(Customer customer1);
    Payment findByRental1(Rental rental1);
    Payment findByStaff1(Staff staff1);
    List<Payment> findAllByCustomer1(Customer customer1);
    List<Payment> findAllByRental1(Rental rental1);
    List<Payment> findAllByStaff1(Staff staff1);
}
