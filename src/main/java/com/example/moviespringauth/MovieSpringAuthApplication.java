package com.example.moviespringauth;

import com.example.moviespringauth.Entities.Role;
import com.example.moviespringauth.Entities.Staff;
import com.example.moviespringauth.Service.StaffService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MovieSpringAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSpringAuthApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(StaffService staffService) {
        return args -> {
            staffService.saveRole(new Role(null, "ROLE_USER"));
            staffService.saveRole(new Role(null, "ROLE_ADMIN"));
            staffService.saveRole(new Role(null, "ROLE_MANAGER"));
            staffService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            staffService.saveStaff(new Staff(null, "Charles", "Boyle", "Cboyle", "duck", "Cboyle@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Rosa", "Diaz", "Rdiaz", "motorcycle", "Rdiaz@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Gina", "Linetti", "Glinetti", "linizzles", "Glinetti@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Jake", "Peralta", "Jperalta", "diehard", "Jperalta@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Amy", "Santiago", "Asantiago", "binders", "Asantiago@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Raymond", "Holt", "RHolt", "1234", "RHolt@gmail.com", new ArrayList<>()));
            staffService.saveStaff(new Staff(null, "Terry", "Jeffords", "Tjeffords", "cagneylacey", "Tjeffords@gmail.com", new ArrayList<>()));

            staffService.addRoleToStaff("Cboyle", "ROLE_USER");
            staffService.addRoleToStaff("Cboyle", "ROLE_ADMIN");
            staffService.addRoleToStaff("Rdiaz", "ROLE_MANAGER");
            staffService.addRoleToStaff("Rdiaz", "ROLE_USER");
            staffService.addRoleToStaff("Glinetti", "ROLE_USER");
            staffService.addRoleToStaff("Jperalta", "ROLE_USER");
            staffService.addRoleToStaff("Asantiago", "ROLE_MANAGER");
            staffService.addRoleToStaff("RHolt", "ROLE_SUPER_ADMIN");
            staffService.addRoleToStaff("RHolt", "ROLE_ADMIN");
            staffService.addRoleToStaff("RHolt", "ROLE_USER");
            staffService.addRoleToStaff("Tjeffords", "ROLE_ADMIN");
        };
    }
}