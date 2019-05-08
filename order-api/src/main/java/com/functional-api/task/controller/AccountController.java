package com.vedantu.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedantu.task.entity.Account;
import com.vedantu.task.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/allAccounts")
	public List<Account> getAllOrder() {
		return accountRepository.findAll();
	}
}
