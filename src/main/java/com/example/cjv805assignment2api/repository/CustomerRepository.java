package com.example.cjv805assignment2api.repository;

import com.example.cjv805assignment2api.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByEmail(String email);
}
