package greeting.memorybaseddb.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * By extending <code>CrudRepository</code>, <code>CustomerRepository</code>
 * inherits several methods for working with <code>Customer</code> persistence,
 * including methods for saving, deleting, and finding <code>Customer</code>
 * entities.
 * 
 * @author Tran Xuan Hoang
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findById(Long id);

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

	long countByFirstName(String firstName);

	long countByLastName(String lastName);
}