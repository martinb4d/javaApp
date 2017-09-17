package application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.exceptions.BusinessException;
import application.model.User;
import application.repository.UserRepository;
import application.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username.toLowerCase(), password);
		if(user==null){
			throw new BusinessException("invalid user");
		}
		return user;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

}
