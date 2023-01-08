package com.project.Bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Bookshop.entity.User;
import com.project.Bookshop.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository repository;
	

	public void saveUser(User user) {

		repository.save(user);
	}

	public User validate(String username) {
		
		User user = repository.getReferenceById(username);
		
		return user;
	}

	/*
	 * public User findByUsername(String username) {
	 * 
	 * User user = null;
	 * 
	 * Optional<User> optional = repository.findById(username);
	 * 
	 * if (optional.isPresent()) {
	 * 
	 * user = optional.get(); } return user; }
	 */

}
