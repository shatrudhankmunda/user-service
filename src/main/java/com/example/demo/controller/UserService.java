package com.example.demo.controller;

import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;

public interface UserService {
	public void test(String s, String s1);

	public default void test2() {
	System.out.println("this is default");
	}
	public static void test3() {
		System.out.println("this is static !");
	}

	public List<User> save(UserDto request) throws Exception;

	public List<User> getAllUsers();

	public User getUserById(Long id);
}
