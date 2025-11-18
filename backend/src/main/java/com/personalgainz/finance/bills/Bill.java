package com.personalgainz.finance.bills;

// LocalDate is used to stores dates ("2025-11-15")
import java.time.LocalDate;

// Importing necessary Spring and JPA annotations
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * This class represents ONE bill
 * Each object of this class is a single bill entry
 */


@Entity
public class Bill {
    
    // Fields representing the attributes of a bill

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // Primary Key (auto-generated)

    private Long userId;            // ID of the user who owns this bill
    private String name;            // Name of the bill (e.g., "Electric Bill")
    private double amount;          // Amount due for the bill
    private LocalDate dueDate;      // Due date for the bill payment
    private String category;        // Category of the bill (e.g., "Utilities")
    private boolean autoPay;        // Whether the bill is set for auto payment
    private boolean paid;           // Whether the bill has been paid
    private String notes;           // Additional notes about the bill (optional)

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
