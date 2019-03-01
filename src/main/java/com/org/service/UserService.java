package com.org.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.org.model.User;
import com.org.repository.UserRepo;

@Service
public class UserService {

	@Autowired(required = true)
	UserRepo userRepo;

//	@Autowired
//	private SessionFactory sessionFactory;

	public List<User> getAlldetails() {
		return (List<User>) userRepo.findAll();
	}

	public User authenticate(User user) {

		return userRepo.authenticate(user.getUsername(), user.getPassword());
	}

	public User register(User user) {
		return userRepo.save(user);
	}

	public User findByusername(User user) {
		return userRepo.findbyusername(user.getUsername());
	}

}
