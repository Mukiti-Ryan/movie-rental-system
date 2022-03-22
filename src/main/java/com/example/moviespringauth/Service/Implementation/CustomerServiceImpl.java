package com.example.moviespringauth.Service.Implementation;

import com.example.moviespringauth.Entities.Customer;
import com.example.moviespringauth.Repositories.CustomerRepository;
import com.example.moviespringauth.Service.Interface.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new customer {} to the database", customer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> saveCustomers(List<Customer> customers) {
        log.info("Saving new customers to the database");
        return customerRepository.saveAll(customers);
    }

    @Override
    public List<Customer> getCustomers() {
        log.info("Fetching all customers");
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public Customer getCustomerByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public String deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return "Customer has been removed!!" +customerId;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        return customerRepository.save(existingCustomer);
    }
}
