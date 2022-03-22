package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Address;
import com.example.moviespringauth.Repositories.AddressRepository;
import com.example.moviespringauth.Service.Interface.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        log.info("Saving new country {} to the database", address.getAddress());
        return addressRepository.save(address);
    }

    @Override
    public List<Address> saveAddresses(List<Address> addresses) {
        log.info("Saving new addresses to the database");
        return addressRepository.saveAll(addresses);
    }

    @Override
    public List<Address> getAddresses() {
        log.info("Fetching all addresses");
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(String address) {
        return addressRepository.findByAddress(address);
    }

    @Override
    public Address getAddressByPhone(String phoneNumber) {
        return addressRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Address getAddressByAddress(String address2) {
        return addressRepository.findByAddress2(address2);
    }

    @Override
    public Address getAddressByPostal(String postalCode) {
        return addressRepository.findByPostalCode(postalCode);
    }

    @Override
    public Address getAddressByDistrict(Long district) {
        return addressRepository.findByDistrict(district);
    }

    @Override
    public String deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
        return "Address has been removed" +addressId;
    }

    @Override
    public Address updateAddress(Address address) {
        Address existingAddress = addressRepository.findById(address.getAddressId()).orElse(null);
        existingAddress.setAddress(address.getAddress());
        existingAddress.setAddress2(address.getAddress2());
        existingAddress.setPhoneNumber(address.getPhoneNumber());
        existingAddress.setPostalCode(address.getPostalCode());
        existingAddress.setDistrict(address.getDistrict());
        existingAddress.setCity1(address.getCity1());
        existingAddress.setCustomers(address.getCustomers());
        existingAddress.setStaffs(address.getStaffs());
        existingAddress.setStores(address.getStores());
        return addressRepository.save(existingAddress);
    }
}
