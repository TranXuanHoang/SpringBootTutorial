package greeting.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles request related to employees. All source code in the same package of
 * this class demonstrates how to access relational data using JDBC with Spring.
 * 
 * @author Tran Xuan Hoang
 */
@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping(path = "/search")
	public @ResponseBody List<Employee> searchByFirstName(@RequestParam String firstName) {
		return employeeDao.findByFirstName(firstName);
	}
}