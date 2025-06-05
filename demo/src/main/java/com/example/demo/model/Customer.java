package com.example.demo.model;

public class Customer {
    private int cust_id;
    private String cust_name;
    private String cust_mobile;
    private String cust_email;
    private String cust_address;
 
    
    public Customer() {
     super();
    }
  
     public Customer(int cust_id, String cust_name, String cust_mobile, String cust_email, String cust_address) {
     super();
      this.cust_id = cust_id;
      this.cust_name = cust_name;
      this.cust_mobile = cust_mobile;
      this.cust_email = cust_email;
      this.cust_address = cust_address;

    }

    //getters
     public int getCustId() {
     return cust_id;
    }

     public String getCustName() {
     return cust_name;
     }

      public String getCustMobile() {
      return cust_mobile;
     }

      public String getCustEmail() {
      return cust_email;
     }

      public String getCustAddress() {
      return cust_address;
     }


     //setters
      public void setCustName(String cust_name) {
      this.cust_name = cust_name;
     }

       public void setCustMobile(String cust_mobile) {
      this.cust_mobile = cust_mobile;
     }

       public void setCustId(int cust_id) {
      this.cust_id = cust_id;
     }

       public void setCustEmail(String cust_email) {
      this.cust_email = cust_email;
     }

       public void setCustAddress(String cust_address) {
      this.cust_address = cust_name;
     }
    
   
  
}
