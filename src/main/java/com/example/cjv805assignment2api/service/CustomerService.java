package com.example.cjv805assignment2api.service;

import ch.qos.logback.core.boolex.Matcher;
import com.example.cjv805assignment2api.model.Customer;
import com.example.cjv805assignment2api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public CustomerService(CustomerRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    public Customer registerCustomer(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        return repository.save(customer);
    }

    public Customer getCustomerById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Customer getCustomerByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Customer authenticateCustomer(String email, String password) {
        Customer customer = repository.findByEmail(email);
        if (customer != null && encoder.matches(password, customer.getPassword())) {
            return customer;
        }
        return null;
    }
}
