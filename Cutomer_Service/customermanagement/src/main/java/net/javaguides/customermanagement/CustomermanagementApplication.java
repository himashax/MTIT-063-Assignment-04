package net.javaguides.customermanagement;

import net.javaguides.customermanagement.model.Customer;
import net.javaguides.customermanagement.repositary.CustomerRepository;
import net.javaguides.customermanagement.repositary.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomermanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomermanagementApplication.class, args);
	}

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void run(String... args) throws Exception {

		Customer customer = new Customer();
		customer.setFirstName("ramesh");
		customer.setLastName("rama");
		customer.setAge(25);
		customerRepository.save(customer);

		Customer customer1 = new Customer();
		customer1.setFirstName("ramesh1");
		customer1.setLastName("rama1");
		customer1.setAge(255);
		customerRepository.save(customer1);
	}
}
