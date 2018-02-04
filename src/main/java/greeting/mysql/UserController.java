package greeting.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This controller handles requests of adding or showing users' information. All
 * of the classes in the same package demonstrates how can we access data with
 * MySQL.
 * 
 * @author Tran Xuan Hoang
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {
	// Get the bean called userRepository that is automatically generated
	// by Spring. This repository will be used to do CRUD on data
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		userRepository.save(user);

		return user.toString() + " was added successfully.";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// Return information of users in JSON or XML format
		return userRepository.findAll();
	}
}