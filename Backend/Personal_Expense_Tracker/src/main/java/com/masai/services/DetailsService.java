package com.masai.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BadCredentialsException;
import com.masai.model.User;
import com.masai.repository.UserRepository;

@Service
public class DetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> opt = userRepo.findByUsername(username);
		
		if(opt.isPresent()) {
			User user = opt.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole());
			authorities.add(sga);
			return (UserDetails) new User(user.getUsername(), user.getPassword());
		}else {
			throw new BadCredentialsException("Username Not Found");
		}
	}

}
