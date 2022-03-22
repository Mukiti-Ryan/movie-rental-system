package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Rental;
import com.example.moviespringauth.Service.Interface.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(path = "/api/rental")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/rentals")
    public ResponseEntity<List<Rental>> getRentals() {
        return ResponseEntity.ok().body(rentalService.getRentals());
    }

    @GetMapping("/{rentalDate}")
    public Rental findRentalByRentalDate(@PathVariable Timestamp rentalDate) {
        return rentalService.getRentalByRentalDate(rentalDate);
    }

    @GetMapping("/{returnDate}")
    public Rental findRentalByReturnDate(@PathVariable Timestamp returnDate) {
        return rentalService.getRentalByReturnDate(returnDate);
    }

    @PostMapping("/save")
    public ResponseEntity<Rental>saveRental(@RequestBody Rental rental) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rental/save").toUriString());
        return ResponseEntity.created(uri).body(rentalService.saveRental(rental));
    }

    @PostMapping("/saveRentals")
    public List<Rental> addRentals(@RequestBody List<Rental> rentals) {
        return rentalService.saveRentals(rentals);
    }

    @PutMapping("/update")
    public Rental updateRental(@RequestBody Rental rental) {
        return rentalService.updateRental(rental);
    }

    @DeleteMapping("/delete/{rentalId}")
    public String deleteRental(@PathVariable Long rentalId) {
        return rentalService.deleteRental(rentalId);
    }
}
