package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    List<Address> saveAddresses(List<Address> addresses);
    List<Address> getAddresses();
    Address getAddress(String address);
    Address getAddressByPhone(String phoneNumber);
    Address getAddressByAddress(String address2);
    Address getAddressByPostal(String postalCode);
    Address getAddressByDistrict(Long district);
    String deleteAddress(Long addressId);
    Address updateAddress(Address address);

}
