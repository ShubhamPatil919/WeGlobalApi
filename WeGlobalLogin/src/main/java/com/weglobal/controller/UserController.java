package com.weglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weglobal.entity.AuthRequest;
import com.weglobal.utils.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private AuthenticationManager authenticateManager;

	@GetMapping("/")
	public String welcome() {
		return "Hello";
	}
	
	
	@GetMapping("/userTest")
	public String welcome1() {
		return "Hii From Welcome1";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticateManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception exception) {
			throw new Exception("invalid username/password");
		}
		return jwtutil.generateToken(authRequest.getUserName());

	}
}
