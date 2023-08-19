package com.chatapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chatapp.entity.User;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userService.findUserByUserName(username);
		if (userEntity != null) {
			return new org.springframework.security.core.userdetails.User(userEntity.getUserName(),
					userEntity.getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException("UserName not found");
	}
}
