package com.app.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface ViewMyOrdersService {
	
	public List<Order> viewMyOrders(Order order) throws BusinessException;

}
