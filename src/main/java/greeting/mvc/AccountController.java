package greeting.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import greeting.mysql.User;
import greeting.mysql.UserRepository;

/**
 * This controller handles requests relating to account. This package
 * demonstrates how Spring Boot's MVC model uses Thymeleaf to render views on
 * the server side.
 * 
 * @author Tran Xuan Hoang
 */
@Controller
@RequestMapping(path = "account")
public class AccountController {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(path = "/login", method = RequestMethod.PUT)
	public String login(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("authenticated", false);

		return "login";
	}

	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute User user, Model model) {
		// Authenticate user
		User authenticatedUser = userRepository.findOne(user.getId());

		if (authenticatedUser == null || !authenticatedUser.getName().equals(user.getName())
				|| !authenticatedUser.getEmail().equals(user.getEmail())) {
			user.setId(null);
			model.addAttribute("authenticated", false);
		} else {
			model.addAttribute("user", authenticatedUser);
			model.addAttribute("authenticated", true);
		}

		return "login";
	}

	@GetMapping("/all")
	public String allAccounts(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
}