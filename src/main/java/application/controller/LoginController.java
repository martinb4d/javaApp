package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.User;
import application.repository.UserRepository;
import application.repository.UserRoleRepository;

@RestController
public class LoginController {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	
	@Autowired
	LoginController(UserRepository userRepository, UserRoleRepository userRoleRepository){
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "tod";
	}
	
	@RequestMapping("/allUser")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
}