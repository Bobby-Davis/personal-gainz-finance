package com.personalgainz.finance.bills;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BillController {

    private final BillRepository billRepository;

    // constructor injection:
    // Spring will automatically provide an instance of BillRepository
    // when it creates an instance of BillController
    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @GetMapping("/api/bills")
    public List<Bill> getBills() {
        
        // Fetch all bills from the database
        return billRepository.findAll();
    }

    @GetMapping("/api/bills/{id}")
    public ResponseEntity<Bill> getBillbyId(@PathVariable Long id) {
        
        // Ask the repository to find a Bill with the given ID
        Optional<Bill> optionalBill = billRepository.findById(id);

        // If found, return 200 OK + the Bill
        if (optionalBill.isPresent()) {
            return ResponseEntity.ok(optionalBill.get());
        }

        // If not found, return 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/bills")
    public Bill createBill(@RequestBody Bill newBill) {

        // Make sure the ID is null so JPA knows this is a new row
        newBill.setId(null); 

        // Save the new bill to the database
        Bill saved = billRepository.save(newBill);

        // Return the saved bill
        return saved;
    }

    @PutMapping("/api/bills/{id}")
    public ResponseEntity<Bill> updateBill(
                @PathVariable Long id,
                @RequestBody Bill updatedBillDetails) {

        // Look up the existing bill by ID
        Optional<Bill> optionalBill = billRepository.findById(id);

        if(optionalBill.isEmpty()) {
            // If not found, return 404 Not Found
            return ResponseEntity.notFound().build();
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

        // Save the updated bill back to the database
        Bill savedBill = billRepository.save(existingBill);

        // Return 200 OK + the saved bill
        return ResponseEntity.ok(savedBill);

    }

    @DeleteMapping("/api/bills/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {

        // Check if the bill exists
        Optional<Bill> optionalBill = billRepository.findById(id);
        if (optionalBill.isEmpty()) {
            // If not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Delete the bill
        billRepository.deleteById(id);

        // Return 204 No Content to indicate successful deletion
        return ResponseEntity.noContent().build();
    }


    
    
}
    

