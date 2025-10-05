package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "tbl_txn_details")
public class Txn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private Long txnId;   // primary key

    @Column(name = "user_id")
    private int custId;   // foreign key to Customer

    @Column(name = "amount")
    private Double amount;

    @Column(name = "txn_type")
    private String txnType;

    @Column(name = "txn_note")
    private String txnNote;

    @Column(name = "txn_date")
    private String txnDate;

    // Default constructor
    public Txn() {}

    // All-args constructor
    public Txn(Long txnId, int custId, Double amount, String txnDate, String txnType, String txnNote) {
        this.txnId = txnId;
        this.custId = custId;
        this.amount = amount;
        this.txnDate = txnDate;
        this.txnType = txnType;
        this.txnNote = txnNote;
    }

    // Getters and setters
    public Long getTxnId() {
        return txnId;
    }
    public void setTxnId(Long txnId) {
        this.txnId = txnId;
    }

    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTxnType() {
        return txnType;
    }
    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTxnNote() {
        return txnNote;
    }

    public void setTxnNote(String txnNote) {
        this.txnNote = txnNote;
    }

    public String getTxnDate() {
        return txnDate;
    }
    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }
}
