package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Rental;
import com.example.moviespringauth.Repositories.RentalRepository;
import com.example.moviespringauth.Service.Interface.RentalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
@Slf4j
@Transactional
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental saveRental(Rental rental) {
        log.info("Saving new rental {} to the database", rental.getRentalDate());
        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> saveRentals(List<Rental> rentals) {
        log.info("Saving new rentals to the database");
        return rentalRepository.saveAll(rentals);
    }

    @Override
    public List<Rental> getRentals() {
        log.info("Fetching all rentals");
        return rentalRepository.findAll();
    }

    @Override
    public String deleteRental(Long rentalId) {
        rentalRepository.deleteById(rentalId);
        return "Rental has been removed!!" +rentalId;
    }

    @Override
    public Rental updateRental(Rental rental) {
        Rental existingRental = rentalRepository.findById(rental.getRentalId()).orElse(null);
        existingRental.setRentalDate(rental.getRentalDate());
        existingRental.setReturnDate(rental.getReturnDate());
        existingRental.setCustomer1(rental.getCustomer1());
        existingRental.setStaff1(rental.getStaff1());
        return rentalRepository.save(existingRental);
    }

    @Override
    public Rental getRentalByRentalDate(Timestamp rentalDate) {
        return rentalRepository.findByRentalDate(rentalDate);
    }

    @Override
    public Rental getRentalByReturnDate(Timestamp returnDate) {
        return rentalRepository.findByReturnDate(returnDate);
    }
}
