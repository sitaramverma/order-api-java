package com.vedantu.task.service;

import com.vedantu.task.entity.Order;

public interface OrderService {

	Order createOrder(Long userId, Long productId);
}
