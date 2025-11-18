package com.personalgainz.finance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.personalgainz.finance.bills.Bill;
import com.personalgainz.finance.bills.BillRepository;
import java.time.LocalDate;

@SpringBootApplication
public class FinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceApplication.class, args);
	}

	@Bean 
	public CommandLineRunner dataLoader(BillRepository billRepository) {
		return args -> {

			// clear existing data each restart
			billRepository.deleteAll();

			
			// Sample bills to add to the database at startup
			Bill electric = new Bill(
				null,
				1L,
				"Electric Bill",
				120.50,
				LocalDate.of(2025, 11, 15),
				"Utilities",
				false,
				false,
				""
			);

			Bill rent = new Bill(
				null,
				1L,
				"Rent",
				950.00,
				LocalDate.of(2025, 12, 1),
				"Housing",
				false,
				false,
				""
			);


			// Save sample bills to the database
			billRepository.save(electric);
			billRepository.save(rent);

		};
	}

}
