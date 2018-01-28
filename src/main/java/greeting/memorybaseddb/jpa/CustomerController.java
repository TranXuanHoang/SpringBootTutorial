package greeting.memorybaseddb.jpa;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demonstrates how to use Spring Data JPA to store, retrieve and delete data in
 * a relational database.
 * 
 * @author Tran Xuan Hoang
 */
@RestController
public class CustomerController {
	private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@RequestMapping("/add-customer")
	public Customer insertCustomer(@RequestParam String firstName, @RequestParam String lastName) {
		Customer customer = new Customer(firstName, lastName);

		customerRepository.save(customer);

		return customer;
	}

	@RequestMapping("/search-customer")
	public List<Customer> searchCustomer(@RequestParam String firstName) {
		return customerRepository.findByFirstName(firstName);
	}

	@RequestMapping("/all-customers")
	public List<Customer> allCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	@RequestMapping("/delete-customer")
	public List<Customer> deleteCustomer(@RequestParam String lastName) {
		List<Customer> customers = customerRepository.findByLastName(lastName);
		customerRepository.delete(customers);

		return allCustomers();
	}
}