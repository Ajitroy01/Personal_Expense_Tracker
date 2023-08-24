package com.masai.services;

import com.masai.model.User;

public interface UserService {

	public User addUser(User user);
	public User addAdmin(User admin);
	public User getUserByUsername(String username);
}
