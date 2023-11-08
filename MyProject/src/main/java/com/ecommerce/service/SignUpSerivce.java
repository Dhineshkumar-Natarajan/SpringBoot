package com.ecommerce.service;

import java.util.Optional;

import com.ecommerce.dto.UserRequest;
import com.ecommerce.model.User;

public interface SignUpSerivce {
	
public Optional<User> getUser(String userId);
	
public String saveUser(UserRequest userRequest);
	
public String removeUser(String userId);

}
