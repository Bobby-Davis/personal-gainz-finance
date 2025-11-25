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
    
    private final BillsService billService;
    
    // constructor injection
    // Spring will automatically provide an instance of BillsService
    // when it creates an instance of BillController
    public BillController(BillsService billService) {
        // Assign the injected BillsService to the local field
        this.billService = billService;
    }

    
    @GetMapping("/api/bills")
    public List<Bill> getBills() {
        
        // Fetch all bills from the database
        return billService.getAllBills();
    }

    @GetMapping("/api/bills/{id}")
    public ResponseEntity<Bill> getBillbyId(@PathVariable Long id) {
        
        // Ask the repository to find a Bill with the given ID
        Optional<Bill> optionalBill = billService.getBillById(id);

        // If found, return 200 OK + the Bill
        if (optionalBill.isPresent()) {
            return ResponseEntity.ok(optionalBill.get());
        }

        // If not found, return 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/bills")
    public ResponseEntity<Bill> createBill(@RequestBody Bill newBill) {

        // delegate to the service to create the new bill
        Bill saved = billService.createBill(newBill);

        // Return the saved bill
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/api/bills/{id}")
    public ResponseEntity<Bill> updateBill(
                // this annotation tells Spring to extract the "id" from the URL path
                @PathVariable Long id,
                // this annotation tells Spring to read the request body and convert it to a Bill object
                @RequestBody Bill updatedBillDetails) {

        // ask the service to update the bill
        Optional<Bill> optionalBill = billService.updateBill(id, updatedBillDetails);

        if(optionalBill.isEmpty()) {
            // If not found, return 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Return 200 OK + the saved bill
        return ResponseEntity.ok(optionalBill.get());

    }

    @DeleteMapping("/api/bills/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {

        // Ask the service to delete the bill
        boolean deleted = billService.deleteBill(id);

        if (!deleted) {
            // Service couldn't delete because the bill was not found
            return ResponseEntity.notFound().build();
        }

        // Return 204 No Content to indicate successful deletion
        return ResponseEntity.noContent().build();
    }
    
}
    

