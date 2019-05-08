package com.vedantu.task.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.task.entity.Account;
import com.vedantu.task.entity.Inventory;
import com.vedantu.task.entity.Order;
import com.vedantu.task.repository.AccountRepository;
import com.vedantu.task.repository.InventoryRepository;
import com.vedantu.task.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public synchronized Order createOrder(Long userId, Long productId) {

		Optional<Account> user = accountRepository.findById(userId);
		if (!user.isPresent()) {
			return null;
		}
		Optional<Inventory> inv = inventoryRepository.findById(productId);
		if (!inv.isPresent()) {
			return null;
		}
		Order order = new Order();
		Inventory inventory = inv.get();
		if (inventory.getQuantity() > 0) {
			Date date = new Date();
			order.setActiveFlag(1);
			order.setOrderDate(date);
			order.setProductId(productId);
			order.setUserid(userId);
			order.setUpdatedOn(date);
			orderRepository.saveAndFlush(order);
			inventory.setQuantity(inventory.getQuantity() - 1);
			inventoryRepository.saveAndFlush(inventory);
		}

		return order;
	}

}
