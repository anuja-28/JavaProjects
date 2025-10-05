package com.example.demo.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "tbl_customer_details")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment in DB
    @Column(name = "cust_id")
    private int custId;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "cust_name")
    private String custName;

    @Size(min = 10, max = 10, message = "Mobile Number must be 10 digits.")
    @Pattern(regexp = "^[789]\\d{9}$", message = "Mobile must start with 7, 8, or 9 and be 10 digits long")
    @Column(name = "cust_mobile")
    private String custMobile;

    @NotBlank(message = "Email is required")
    @Size(min = 2, max = 50, message = "Email must be between 2 and 50 characters")
    @Pattern(
        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
        message = "Please enter a valid email address"
    )
    @Column(name = "cust_email")
    private String custEmail;

    @NotBlank(message = "Address is required")
    @Column(name = "cust_address")
    private String custAddress;

    // Default constructor (required by JPA)
    public Customer() {}

    // All-args constructor
    public Customer(int custId, String custName, String custMobile, String custEmail, String custAddress) {
        this.custId = custId;
        this.custName = custName;
        this.custMobile = custMobile;
        this.custEmail = custEmail;
        this.custAddress = custAddress;
    }

    // Getters and setters
    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMobile() {
        return custMobile;
    }
    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public String getCustEmail() {
        return custEmail;
    }
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustAddress() {
        return custAddress;
    }
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
}
