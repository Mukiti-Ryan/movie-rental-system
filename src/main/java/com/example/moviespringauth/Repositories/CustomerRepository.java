package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
}
