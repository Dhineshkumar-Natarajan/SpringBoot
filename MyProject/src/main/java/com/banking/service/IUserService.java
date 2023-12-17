package com.banking.service;

import com.banking.dto.UserRequest;
import com.banking.dto.UserResponse;

public interface IUserService {

	public void addUser(UserRequest userRequest);
	
	public UserResponse getUserDetailsById(long id);
	
	

}