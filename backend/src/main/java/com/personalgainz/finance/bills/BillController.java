package com.personalgainz.finance.bills;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/api/bills")
    public Bill createBill(@RequestBody Bill newBill) {

        // Make sure the ID is null so JPA knows this is a new row
        newBill.setId(null); 

        // Save the new bill to the database
        Bill saved = billRepository.save(newBill);

        // Return the saved bill
        return saved;
    }
    
}
    

