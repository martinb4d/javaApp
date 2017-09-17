package application.service;

import java.util.List;

import application.model.User;

public interface UserService {
	public User getUserByUsername(String username);
	public User getUserByUsernameAndPassword(String username, String password);
	public List<User> getAllUser();
}
