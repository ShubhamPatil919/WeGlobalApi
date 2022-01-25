package com.weglobal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.weglobal.entity.User;
import com.weglobal.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userrepository.findByUserName(username);
		System.out.println("User Deatils:" + user);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());

		// return new User("root", "root", new ArrayList<>());
	}

}
