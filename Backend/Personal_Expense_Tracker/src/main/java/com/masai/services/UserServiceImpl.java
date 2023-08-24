package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BadCredentialsException;
import com.masai.model.User;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User addUser(User user) {
		if(user == null) {
			throw new BadCredentialsException("Null Value Not Allowed");
		}
		Optional<User> opt = ur.findByUsername(user.getUsername());
		if(opt.isPresent()) {
			throw new BadCredentialsException("User already exists");
		}
		user.setRole("ROLE_USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return ur.save(user);
	}

	@Override
	public User addAdmin(User admin) {
		if(admin == null) {
			throw new BadCredentialsException("Null Value Not Allowed");
		}
		Optional<User> opt = ur.findByUsername(admin.getUsername());
		if(opt.isPresent()) {
			throw new BadCredentialsException("User already exists");
		}
		admin.setRole("ROLE_ADMIN");
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return ur.save(admin);
	}

	@Override
	public User getUserByUsername(String username) {
		return ur.findByUsername(username).orElseThrow(() -> new BadCredentialsException("User not found."));
	}

}
