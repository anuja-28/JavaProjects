package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
    
 
 @Autowired
 CustomerRepository CustomerRepository;
 
 @PostMapping("/saveCust")
 public int addCustomer(@RequestBody Customer cust) {
  return CustomerRepository.addCustomer(cust);
 }
}
