package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Customer;

@Repository
public class CustomerImplRepo implements CustomerRepository {
 
 @Autowired
 JdbcTemplate jdbcTemplate;
 
 @Override
 public int addCustomer(Customer customer) {
  String insertQuery = "insert into tbl_customer_details(cust_name, cust_email) values (?,?)";
  return jdbcTemplate.update(insertQuery,customer.getCustName(),customer.getCustEmail());
 }

 @Override
 public List<Customer> getAllCustomers(){
   String selectallQuery = "select * from tbl_customer_details";
   List<Customer> allCust = jdbcTemplate.query(selectallQuery, new BeanPropertyRowMapper<Customer>(Customer.class));
   return allCust;
}

@Override
public Customer getCustomerById(int cust_id){
  String qry = "Select * from tbl_customer_details where cust_id = ?";
  Customer customer = jdbcTemplate.queryForObject(qry, BeanPropertyRowMapper.newInstance(Customer.class), cust_id);
  return customer;
}


}