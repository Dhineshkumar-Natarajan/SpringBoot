package com.payroll.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payroll.model.User;
import com.payroll.pojo.UserRequest;
import com.payroll.repository.SignUpRepository;

@Service
public class SignUpSerivceImpl {
	
	@Autowired
	SignUpRepository signUpRepository;
	
	public Optional<User> getUser(String userId) {
		
		return signUpRepository.findById(userId);
		
	}
	
	public String saveUser(UserRequest userRequest) {
		
		
		User user = new User();
		
		user.setUserId(userRequest.getUserId());
		user.setUserName(userRequest.getUserName());
		user.setAge(userRequest.getAge());
		user.setEmail(userRequest.getEmail());
		user.setUserAddress(userRequest.getUserAddress());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		
		signUpRepository.save(user);
		
		return "Saved Successully";
	}
	
	public String removeUser(String userId) {
		
		signUpRepository.deleteById(userId);
		
		return "Deleted Successfully";
	}

}
