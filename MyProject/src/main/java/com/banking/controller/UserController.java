package com.banking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.UserRequest;
import com.banking.dto.UserResponse;
import com.banking.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<?> getUserDetailsById(long id) {

		UserResponse userResponse = userService.getUserDetailsById(id);
		
		Map<String, Object> mapResponse = new HashMap<>();
		
		mapResponse.put("reponse", userResponse);
		mapResponse.put("status", HttpStatus.OK.toString());
		
		return ResponseEntity.ok(mapResponse);
	}

	@PostMapping("/addUser")
	public void addUser(@RequestBody UserRequest userRequest) {
		
		userService.addUser(userRequest);
	}

}
