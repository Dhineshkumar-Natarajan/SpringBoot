package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.UserRequest;
import com.banking.dto.UserResponse;
import com.banking.model.Account;
import com.banking.model.User;
import com.banking.repository.IUserRepository;
import com.banking.utils.Utils;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IAccountService accountService;

	@Override
	public void addUser(UserRequest userRequest) {

		User user = new User();

		user.setAge(userRequest.getAge());
		user.setEmail(userRequest.getEmail());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setUserAddress(userRequest.getUserAddress());
		user.setUserName(userRequest.getUserName());

		String accountNumber = Utils.generateAccountNumber();
		user.setAccountNumber(accountNumber);

		userRepository.save(user);
		accountService.addAccount(accountNumber, userRequest);
	}

	@Override
	public UserResponse getUserDetailsById(long id) {

		Optional<User> user = userRepository.findById(id);

		Optional<Account> account = accountService.getAccountDetails(user.get().getAccountNumber());

		UserResponse userResponse = new UserResponse();

		userResponse.setUserId(String.valueOf(user.get().getUserId()));
		userResponse.setUserName(user.get().getUserName());
		userResponse.setUserAddress(user.get().getUserAddress());
		userResponse.setPhoneNumber(user.get().getPhoneNumber());
		userResponse.setEmail(user.get().getEmail());
		userResponse.setAge(user.get().getAge());

		userResponse.setAccountNumber(account.get().getAccountNumber());
		userResponse.setAccountType(account.get().getAccountType());
		userResponse.setAccountBalance(account.get().getAccountBalance());

		return userResponse;

	}
}
