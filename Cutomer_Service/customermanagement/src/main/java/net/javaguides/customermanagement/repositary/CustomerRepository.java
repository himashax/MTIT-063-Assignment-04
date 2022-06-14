package net.javaguides.customermanagement.repositary;

import net.javaguides.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
