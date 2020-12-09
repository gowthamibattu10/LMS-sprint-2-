package com.cg.librarymanagement.lms.controller;


/** 
 AUTHOR : Prathyusha Narsupalli
 */

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.librarymanagement.lms.dtos.User;
import com.cg.librarymanagement.lms.service.UserService;



@RestController
@CrossOrigin(origins= "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/register")
	public String registerUser(@Valid @RequestBody User user){

		System.out.println(user.getMobileno());
		return userService.registerUser(user);
	}
	
	@GetMapping("/getbyname/{name}")
	public @ResponseBody User getbyname(@PathVariable String name) 
	{ 
		User user = userService.getbyname(name);
		return user;
	}

	@DeleteMapping("/Delete/{name}")
	public @ResponseBody String DeleteUser(@PathVariable String name) 
	{

		return userService.removeUser(name);

	}

	@PutMapping("/updateDetails")
	public @ResponseBody String updateUser(@RequestBody User user) 
	{
		System.out.println(user);
		return userService.updateUser(user);

	}

	@GetMapping("/")
	public @ResponseBody List<User> viewAllUsers() 
	{ 
		List<User> users = userService.viewAllusers();
		return users;
	}
	
	/*
	@PutMapping("/CancelSubscription/{id}")
	public @ResponseBody String cancelSubscription(@PathVariable int id)
	{ 

		return userService.cancelSubscription(id);

	}
	*/
	
	@GetMapping("/LoginValidation/{username}/{password}")
	public @ResponseBody int loginValidate(@PathVariable String username,@PathVariable String password) {
		
		return userService.loginValidate(username, password);
	}
}