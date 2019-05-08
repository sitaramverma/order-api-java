package com.vedantu.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vedantu.task.entity.Inventory;
import com.vedantu.task.repository.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryRepository inventoryRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}
}
