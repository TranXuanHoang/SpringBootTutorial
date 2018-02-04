package greeting.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Directly executes queries against the database to do CRUD operations.
 * 
 * @author Tran Xuan Hoang
 */
@Component
public class EmployeeDAO implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Searches employee based on first name.
	 * 
	 * @param firstName
	 *            the first name of the employee to be searched.
	 * @return a list of employees whose first name matches the given input.
	 */
	public List<Employee> findByFirstName(String firstName) {
		log.info("Creating tables");

		// Query the employees table to find information of the employee whose
		// first_name = firstName
		log.info("Querying for customer records where first_name = 'Bob'...");
		List<Employee> queryResult = jdbcTemplate.query("SELECT * FROM employees WHERE first_name = ?",
				new Object[] { firstName },
				(rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")));

		queryResult.forEach(employee -> log.info(employee.toString()));

		return queryResult;
	}

	/**
	 * Creates table employees and inserts example records.
	 */
	@Override
	public void run(String... args) throws Exception {
		log.info("Creating tables");

		// Create table employees
		jdbcTemplate.execute("DROP TABLE IF EXISTS employees");
		jdbcTemplate.execute(
				"CREATE TABLE employees(" + "id SERIAL," + "first_name VARCHAR(255)," + "last_name VARCHAR(255)" + ")");

		// Split up the array of full names into an array of first/last names
		List<Object[]> splitUpNames = Arrays.asList("Hoang Tran", "Alice Nathan", "Bob Sally", "Colby Tobias").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		// Print our each tuple of the list of first/last names
		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

		// Insert all employees' data into the database using JdbcTemplate's batch
		// update operation
		jdbcTemplate.batchUpdate("INSERT INTO employees(first_name, last_name) VALUES (?,?)", splitUpNames);

		log.info("Finished creating and populating the 'employees' table.");
	}
}