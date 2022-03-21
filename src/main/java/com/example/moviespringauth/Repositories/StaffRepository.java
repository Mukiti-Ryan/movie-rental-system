package com.example.moviespringauth.Repositories;

import com.example.moviespringauth.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsername(String username);
}
