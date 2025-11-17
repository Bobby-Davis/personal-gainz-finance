package com.personalgainz.finance.bills;

// LocalDate is used to stores dates ("2025-11-15")
import java.time.LocalDate;


/**
 * This class represents ONE bill
 * Each object of this class is a single bill entry
 */
public class Bill {
    
    // Fields representing the attributes of a bill
    private Long id;
    private Long userId;
    private String name;
    private double amount;
    private LocalDate dueDate;
    private String category;
    private boolean autoPay;
    private boolean paid;
    private String notes;

    // Constructors

    //Empty (no-arg) constructor
    public Bill() {

    }

    // Full constructor with every field
    public Bill(Long id, Long userId, String name, double amount, LocalDate dueDate, String category, boolean autoPay, boolean paid, String notes) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.amount = amount;
        this.dueDate = dueDate;
        this.category = category;
        this.autoPay = autoPay;
        this.paid = paid;
        this.notes = notes;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }  

    public void setId(Long id) {
        this.id = id;
    }   

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAutoPay() {
        return autoPay;
    }

    public void setAutoPay(boolean autoPay) {
        this.autoPay = autoPay;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
}
