package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.User;
import com.org.repository.UserRepo;
import com.org.service.UserService;

@RequestMapping("/")
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	@Autowired 
	UserRepo userRepo;
	
	@GetMapping(value= "user")
	public List<User> getAllUsers() {
		return userService.getAlldetails();
	}

	@PostMapping(value="login")
		public boolean authenticate(@RequestBody User user, HttpServletResponse response) {
		boolean a= userRepo.authenticate(user.getUsername(),user.getPassword()) != null;
			if(a== false) {
				response.setStatus(401);
			}
			return a;
			
		}
	
	@PostMapping(value="register")		
	public boolean register(@RequestBody User user, HttpServletResponse response) {
		boolean a = false;
		
		try {
			 a = userService.register(user) != null;
			if(a==true) {
				response.setStatus(200);
			}
			//return response;
		}
		
		catch (DataIntegrityViolationException e) {
			response.setStatus(409);
	        System.out.println("Data already exist");
	         a=false;
	        //return a;
	    }
		
//		catch (Exception e) {
//			System.out.println(e);
//			response.setStatus(402);
//		}
		return a;
			
		}
	
	}

