package com.kps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kps.model.User;
import com.kps.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		//TODO: retrieve user and roles from database
		User user = userRepository.loadUserByUsername(username);
		if(user == null) 
			throw new UsernameNotFoundException("-> User not found!");
		System.out.println(user);
		return user;
	}

	
	
	
	
	
	
	
	
	
	
	
}
