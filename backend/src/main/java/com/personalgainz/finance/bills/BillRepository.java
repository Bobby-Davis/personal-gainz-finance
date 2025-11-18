package com.personalgainz.finance.bills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositry interface for Bill entiies
 * 
 * This give us built-in methods to interact with the database like
 * saving, deleting, and finding bills
 * 
 * Spring Data JPA will provide the implementation automatically at runtime
 */

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    
}
