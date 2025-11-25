package com.personalgainz.finance.bills;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * Service layer for Bills-related business logic.
 * 
 */
@Service
public class BillsService {
    
    private final BillRepository billRepository;

    // constructor injection
    public BillsService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    // Get all bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    // Get a single bill by ID
    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    // Create a new bill
    public Bill createBill(Bill newBill) {
        newBill.setId(null); // Ensure ID is null for new entity
        return billRepository.save(newBill);
    }

    // Update an existing bill
    public Optional<Bill> updateBill(Long id, Bill updatedBillDetails) {

        // Look up the existing bill
        Optional<Bill> optionalBill = billRepository.findById(id);

        if (optionalBill.isEmpty()) {
            return Optional.empty(); // Bill not found
        }

        Bill existingBill = optionalBill.get();

        // Copy over fields from the updated details to the existing bill
        existingBill.setUserId(updatedBillDetails.getUserId());
        existingBill.setName(updatedBillDetails.getName());
        existingBill.setAmount(updatedBillDetails.getAmount());
        existingBill.setDueDate(updatedBillDetails.getDueDate());
        existingBill.setCategory(updatedBillDetails.getCategory());
        existingBill.setAutoPay(updatedBillDetails.isAutoPay());
        existingBill.setPaid(updatedBillDetails.isPaid());
        existingBill.setNotes(updatedBillDetails.getNotes());

        Bill saved = billRepository.save(existingBill);
        return Optional.of(saved);
    }

    // Delete a bill by ID
    public boolean deleteBill(Long id) {
        Optional<Bill> existingBill = billRepository.findById(id);

        if (existingBill.isEmpty()) {
            return false; // Bill not found
        }

        billRepository.deleteById(id);
        return true; // Deletion successful
    }
}
