package com.example.moviespringauth.Service.Interface;

import com.example.moviespringauth.Entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> saveCustomers(List<Customer> customers);
    List<Customer> getCustomers();
    String deleteCustomer(Long customerId);
    Customer updateCustomer(Customer customer);
    Customer getCustomerByFirstName(String firstName);
    Customer getCustomerByLastName(String lastName);
    Customer getCustomerByEmail(String email);
}
