package com.weglobal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weglobal.entity.User;
import com.weglobal.repo.UserRepository;

@SpringBootApplication
public class WeGlobalLoginApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	void initUser() {

		List<User> users = Stream.of(new User(1, "root", "root", "abc@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(WeGlobalLoginApplication.class, args);
	}

}
