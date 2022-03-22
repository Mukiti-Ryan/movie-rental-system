package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByAddress(String address);
    Address findByAddress2(String address2);
    Address findByPostalCode(String postalCode);
    Address findByPhoneNumber(String phoneNumber);
    Address findByDistrict(Long district);
}
