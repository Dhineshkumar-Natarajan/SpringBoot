package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.DepositRequest;
import com.banking.service.IAccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	IAccountService accountService;

	@PostMapping("/deposit")
	public void deposit(@RequestBody DepositRequest depositRequest) {

		accountService.deposit(depositRequest);

	}

}
