package com.project.blueshirt.repository.order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.blueshirt.dto.ResponseOrderDto;
import com.project.blueshirt.model.order.Order;

@Repository
@Mapper
public interface OrderRepository {

	public ResponseOrderDto save(Order order);
	
}
