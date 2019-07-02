package com.joseway.ngspringsec.services;

import java.util.List;
import java.util.Optional;

import com.joseway.ngspringsec.model.User;


public interface UserService {

	public List<User> findAll();
	public User findById(long id);
	public Optional<User> findByUsername(String username);
	public User delete(long id);
	public User save(User user);
}
