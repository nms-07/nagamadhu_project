package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface ViewMyOrdersDAO {
	
	public List<Order> viewMyOrders(Order order) throws BusinessException;
	
}
