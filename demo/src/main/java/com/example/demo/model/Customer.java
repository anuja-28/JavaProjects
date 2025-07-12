package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class Customer {
  private int cust_id;

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  @Column(name = "cust_name") // maps to DB column
  private String custName;

  @Size(min = 10, max = 10, message = "Mobile Number must be 10 digits.")
  @Pattern(regexp = "^[789]\\d{9}$") 
  @Column(name = "cust_mobile")
  private String custMobile;

  @NotBlank(message = "Email is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email address")
  @Column(name = "cust_email")
  private String custEmail;

   @NotBlank(message = "Address is required")
  @Column(name = "cust_address")
  private String custAddress;

  public Customer() {
    super();
  }

  public Customer(int cust_id, String cust_name, String cust_mobile, String cust_email, String cust_address) {
    super();
    this.cust_id = cust_id;
    this.custName = cust_name;
    this.custMobile = cust_mobile;
    this.custEmail = cust_email;
    this.custAddress = cust_address;

  }

  // getters
  public int getCustId() {
    return cust_id;
  }

  public String getCustName() {
    return custName;
  }

  public String getCustMobile() {
    return custMobile;
  }

  public String getCustEmail() {
    return custEmail;
  }

  public String getCustAddress() {
    return custAddress;
  }

  // setters
  public void setCustName(String cust_name) {
    this.custName = cust_name;
  }

  public void setCustMobile(String cust_mobile) {
    this.custMobile = cust_mobile;
  }

  public void setCustId(int cust_id) {
    this.cust_id = cust_id;
  }

  public void setCustEmail(String cust_email) {
    this.custEmail = cust_email;
  }

  public void setCustAddress(String cust_address) {
    this.custAddress = cust_address;
  }

}
