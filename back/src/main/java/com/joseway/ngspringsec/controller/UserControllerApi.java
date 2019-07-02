package com.joseway.ngspringsec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserControllerApi {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{id}")
	public User findById(@PathVariable("id")Long id) {
		return userService.findById(id);
	}

	@GetMapping(value="")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@PostMapping(value="")
	public User save(@RequestBody User user) {	
		return userService.save(user);	
	}
	
	@GetMapping(value="/username/{username}")
	public Optional<User> findByUsername(@PathVariable("username")String username) {
		return userService.findByUsername(username);
	}
	

}
