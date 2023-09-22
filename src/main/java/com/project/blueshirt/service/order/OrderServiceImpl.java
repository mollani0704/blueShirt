package com.project.blueshirt.service.order;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.blueshirt.dto.ResponseOrderDto;
import com.project.blueshirt.model.order.Order;
import com.project.blueshirt.repository.order.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	
	@Override
	public Map<String, Object> orderSave(Order order) {
		
		ResponseOrderDto result = orderRepository.save(order);
		
		return null;
	}

}
