package com.example.demo.model;

public class Product {
    private int pr_id;
    private String pr_name;
    private long pr_price;
    private String pr_status;
   
    public Product() {
     super();
    }
  
    public Product(int pr_id, String pr_name, long pr_price, String pr_status) {
     super();
     this.pr_id = pr_id;
     this.pr_name = pr_name;
     this.pr_price = pr_price;
     this.pr_status = pr_status;
    }
  
    public int getPrId() {
     return pr_id;
    }
    public void setPrId(int pr_id) {
     this.pr_id = pr_id;
    }
    public String getPrName() {
     return pr_name;
    }
    public void setPrName(String pr_name) {
     this.pr_name = pr_name;
    }
    public long getPrPrice() {
     return pr_price;
    }
    public void setPrPrice(long pr_price) {
     this.pr_price = pr_price;
    }
    public String getPrStatus() {
     return pr_status;
    }
    public void setPrStatus(String pr_status) {
     this.pr_status = pr_status;
    }
    @Override
    public String toString() {
     return "Student ID : " + pr_id + ", Student name : " + pr_name + ", Product Price  : " + pr_price + ", status : " + pr_status;
    }
  }