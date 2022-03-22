package com.example.moviespringauth.controller;

import com.example.moviespringauth.Entities.Address;
import com.example.moviespringauth.Entities.Country;
import com.example.moviespringauth.Service.Interface.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>>getAddresses() {
        return ResponseEntity.ok().body(addressService.getAddresses());
    }

    @GetMapping("/{address}")
    public Address getAddress(@PathVariable String address) {
        return addressService.getAddress(address);
    }

    @GetMapping("/{address2}")
    public Address getByAddress(@PathVariable String address2) {
        return addressService.getAddressByAddress(address2);
    }

    @GetMapping("/{phoneNumber}")
    public Address getByPhone(@PathVariable String phoneNumber) {
        return addressService.getAddressByPhone(phoneNumber);
    }

    @GetMapping("/{postalCode}")
    public Address getByPostal(@PathVariable String postalCode) {
        return addressService.getAddressByPostal(postalCode);
    }

    @GetMapping("/{district}")
    public Address getByDistrict(@PathVariable Long district) {
        return addressService.getAddressByDistrict(district);
    }

    @PostMapping("/save")
    public ResponseEntity<Address>saveAddress(@RequestBody Address address) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/address/save").toUriString());
        return ResponseEntity.created(uri).body(addressService.saveAddress(address));
    }

    @PostMapping("/saveAddresses")
    public List<Address> addAddresses(@RequestBody List<Address> addresses) {
        return addressService.saveAddresses(addresses);
    }

    @PutMapping("/update")
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/delete/{addressId}")
    public String deleteAddress(@PathVariable Long addressId) {
        return addressService.deleteAddress(addressId);
    }
}
