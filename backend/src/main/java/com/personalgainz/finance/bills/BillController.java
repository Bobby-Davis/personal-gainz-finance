package com.personalgainz.finance.bills;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


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
}
    

