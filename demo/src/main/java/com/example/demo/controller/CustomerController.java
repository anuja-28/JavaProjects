package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/saveCust")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer cust, BindingResult result) {
        if (result.hasErrors()) {
            // Build custom validation error response
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }

        // Save to DB (replace with your actual method)
        customerRepository.addCustomer(cust);

        return ResponseEntity.ok("Customer saved successfully");
    }  

    @GetMapping("/getcustomers")
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerRepository.getAllCustomers();
    }




 
}
