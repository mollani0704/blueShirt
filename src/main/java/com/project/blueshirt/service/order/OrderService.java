package com.project.blueshirt.service.order;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.blueshirt.model.order.Order;

@Service
public interface OrderService {
	
	public Map<String, Object> orderSave(Order order);
	
}
