package com.personalgainz.finance.bills;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BillController {

    @GetMapping("/api/bills")
    public List<Bill> getBills() {
        Bill sample = new Bill(
            1L,
            1L,
            "Electric Bill",
            120.50,
            LocalDate.of(2025,11,15),
            "Utilities",
            false,
            false,
            ""
        );

        return List.of(sample);
    }
}
    

