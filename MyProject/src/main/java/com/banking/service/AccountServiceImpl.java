package com.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.DepositRequest;
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

		System.out.println(accountModel.toString());

		accountRepository.save(accountModel);
	}

	@Override
	public Optional<Account> getAccountDetails(String accountNumber) {

		return accountRepository.findById(Integer.parseInt(accountNumber));
	}

	@Override
	public void deposit(DepositRequest depositRequest) {

		System.out.println(depositRequest.getAccountNumber() +"-" + depositRequest.getDepositAmount());
		
		Account account = accountRepository.findAll().stream().filter(e->e.getAccountNumber()==depositRequest.getAccountNumber()).findFirst().get();
		
		double currentBalance = account.getAccountBalance();

		currentBalance = currentBalance + depositRequest.getDepositAmount();
		
		account.setAccountBalance(currentBalance);

		accountRepository.save(account);
	}

}
