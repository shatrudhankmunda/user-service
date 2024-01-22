package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@RestController
public class ControllerClass {
	
	private final Logger LOGGER= LoggerFactory.getLogger(ControllerClass.class);
	@Autowired
	@Qualifier("Test1")
	private UserService service;
	
	@PostMapping("/user/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody UserDto request) {
		LOGGER.debug("save() method started....");
		try {
			List<User> save = service.save(request);
			return new ResponseEntity<>(save, HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.debug("Exception occured ==>",e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> get() {
		LOGGER.info("Get Method started ...");
		List<User> users = service.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/user/getUser/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		LOGGER.info("Get Method started ...");
		User user = service.getUserById(id);
		System.out.println(user);
		return user;
		
	}
}
