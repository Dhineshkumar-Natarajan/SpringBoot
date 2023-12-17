package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.UserRequest;
import com.banking.model.Account;
import com.banking.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	IAccountRepository accountRepository;

	@Override
	public void addAccount(String accountNumber, UserRequest userRequest) {
		
		Account accountModel = new Account();
		accountModel.setAccountNumber(accountNumber);
		accountModel.setAccountType(userRequest.getAccountType());
		accountModel.setAccountBalance(0);
		
		accountRepository.save(accountModel);
	}

	@Override
	public Optional<Account> getAccountDetails(String accountNumber) {

		return accountRepository.findById(Integer.parseInt(accountNumber));
	}

}
