package greeting.memorybaseddb.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Defines <code>Customer</code> as a JPA entity that will be used as entity of
 * back-end database.
 * 
 * The <code>Customer</code> class is annotated with <code>@Entity</code>,
 * indicating that it is a JPA entity.
 * 
 * @author Tran Xuan Hoang
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	/**
	 * The default constructor only exists for the sake of JPA. You won’t use it
	 * directly, so it is designated as <code>protected</code>.
	 */
	protected Customer() {
	}

	/**
	 * Used to create instances of <code>Customer</code> to be saved to the
	 * database.
	 * 
	 * @param firstName
	 *            customer's first name.
	 * @param lastName
	 *            customer's last name.
	 */
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}