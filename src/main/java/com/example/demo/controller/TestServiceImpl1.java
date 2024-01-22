package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service("Test1")
public class TestServiceImpl1 implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	private Logger Logger = LoggerFactory.getLogger(TestServiceImpl1.class);
	
	@Override
	public void test(String s, String s1) {
		
	}

	@Override
	public List<User> save(UserDto request) throws Exception{
	Logger.debug("Started save()......");
		List<User> list = null;//new ArrayList<>();
//		list.add(new User(10,"Shatr","Kumar","shatru@gmail.com",100000));
//		list.add(new User(11,"Karan","Kumar","karan1@gmail.com",40000));
//		list.add(new User(12,"Ravi","Kumar","ravi2@gmail.com",25000));
//		list.add(new User(13,"Suraj","Kumar","suraj3@gmail.com",50000));
//		list.add(new User(14,"Manoj","Kumar","manoj4@gmail.com",8000));
		list.stream().forEach(l->{
			
		});
		List<User> user = list.stream().filter(u->u.getFirstName().startsWith("S") && u.getSalary()>20000).sorted((o1,o2)->(int)(o2.getId()-o1.getId())).skip(1).limit(1).collect(Collectors.toList());
		System.out.println(user);
		List<User> saveAll = userRepository.saveAll(list);
		System.out.println(saveAll);
		return saveAll;
		
		
	}
	public static void main(String[] args) {
		
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
		
	}

	@Override
	public User getUserById(Long id)  {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new UserNotFoundException();
		}
		 
	}
	
}
