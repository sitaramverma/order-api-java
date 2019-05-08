package com.vedantu.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedantu.task.entity.Account;
import com.vedantu.task.entity.Inventory;
import com.vedantu.task.entity.Order;
import com.vedantu.task.repository.AccountRepository;
import com.vedantu.task.repository.InventoryRepository;
import com.vedantu.task.repository.OrderRepository;

@RestController
@RequestMapping("/prefill")
public class PrefillController {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private AccountRepository accountRepository;

	@RequestMapping(method = RequestMethod.POST, value = "/inventory")
	public List<Inventory> prefillInvenory(@RequestBody List<Inventory> inventoryList) {
		return inventoryRepository.saveAll(inventoryList);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	public List<Order> prefillOrder(@RequestBody List<Order> orderList) {
		return orderRepository.saveAll(orderList);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/account")
	public List<Account> prefillAccount(@RequestBody List<Account> accountList) {
		return accountRepository.saveAll(accountList);
	}

}
