package com.banking.service;

import java.util.Optional;

import com.banking.dto.DepositRequest;
import com.banking.dto.UserRequest;
import com.banking.model.Account;

public interface IAccountService {

	public void addAccount(String accountNumber, UserRequest userRequest);

	public void deposit(DepositRequest depositRequest);

	public Optional<Account> getAccountDetails(String accountNumber);

}
