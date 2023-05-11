package LTJava.S5.Ngay4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import LTJava.S5.Ngay4.models.User;
import LTJava.S5.Ngay4.models.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/")
	public String viewHomePage() {
		return "users/index";
	}

	@RequestMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "users/register_form";
	}

	@RequestMapping(value = "/process_register", method = RequestMethod.POST)
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);

		return "users/register_success";
	}
	@RequestMapping("/users")
	public String listUsers(Model model) {
	    List<User> Users = userRepo.findAll();
	    model.addAttribute("Users", Users);
	     
	    return "users/allusers";
	}
}
