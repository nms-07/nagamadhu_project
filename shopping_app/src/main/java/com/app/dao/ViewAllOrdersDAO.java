package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface ViewAllOrdersDAO {
	public List<Order> viewAllOrders(Order order) throws BusinessException;
}
