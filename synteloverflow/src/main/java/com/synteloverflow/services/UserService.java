package com.synteloverflow.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.synteloverflow.models.User;
import com.synteloverflow.repositories.RoleRepository;
import com.synteloverflow.repositories.UserRepository;



@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
		
	}
	
	public void saveWithUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Boolean UserExists(String user) {
		User check = userRepository.findByUsername(user);
		if(check.getUsername() != null) {
			return true;
		}
		else {
			return false;
		}
	}

}
