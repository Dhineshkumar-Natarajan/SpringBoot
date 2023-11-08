package com.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.UserRequest;
import com.ecommerce.model.User;
import com.ecommerce.service.SignUpSerivceImpl;

@RestController
@RequestMapping("/signUp")
public class SignUpController {
	
	@Autowired
	SignUpSerivceImpl signUpSerivceImpl;
	
	@GetMapping("getUser/{userId}")
	public Optional<User> getUser(@PathVariable String userId) {
		
		return signUpSerivceImpl.getUser(userId);
	}
	
	
	@PostMapping("saveUser")
	public String saveUser(@RequestBody UserRequest userRequest) {
		
		signUpSerivceImpl.saveUser(userRequest);
		
		return "Saved Successfully";
	}
	
	@PutMapping
	public String updateUser(@RequestBody User user) {
		
		return "User Details Updated";
	}
	
	
	@DeleteMapping("removeUser/{userId}")
	public String removeUser(@PathVariable String userId) {
		
		signUpSerivceImpl.removeUser(userId);
		
		return "User Details Deleted";
	}
}
