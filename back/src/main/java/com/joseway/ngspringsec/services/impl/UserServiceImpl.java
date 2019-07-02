package com.joseway.ngspringsec.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.repository.UserRepository;
import com.joseway.ngspringsec.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User delete(long id) {
		User user = findById(id);
		userRepository.deleteById(id);
		return user;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}





}
