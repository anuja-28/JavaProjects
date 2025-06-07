package com.example.demo.repository;

// import java.util.List;

import com.example.demo.model.Customer;

//its an interface the implementation will be in the implemeting repository
public interface CustomerRepository {

 int addCustomer(Customer customer);
//  List<Customer> getAllCustomers();
//  Customer getCustomerById(int cust_id);
//  int updateCustomer(Customer customer);
//  int deleteCustomerById(int cust_id);
    
}
