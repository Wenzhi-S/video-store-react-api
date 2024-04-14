package com.example.cjv805assignment2api.controller;

import com.example.cjv805assignment2api.model.Customer;
import com.example.cjv805assignment2api.service.CustomerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        if (customer.getEmail() == null || customer.getPassword() == null) {
            return ResponseEntity.badRequest().body("Email and password are required");
        }
        Customer existingCustomer = service.getCustomerByEmail(customer.getEmail());
        if (existingCustomer != null) {
            return ResponseEntity.badRequest().body("Email already in use");
        }
        Customer registeredCustomer = service.registerCustomer(customer);
        return ResponseEntity.ok(registeredCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest) {
        Customer authenticatedCustomer = service.authenticateCustomer(loginRequest.getEmail(), loginRequest.getPassword());
        if (authenticatedCustomer == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        authenticatedCustomer.setPassword(null);
        return ResponseEntity.ok(authenticatedCustomer);
    }

    @Setter
    @Getter
    private static class LoginRequest {
        private String email;
        private String password;

    }
}
