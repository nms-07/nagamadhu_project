package com.app.service.impl;

import java.util.List;


import com.app.dao.ViewMyOrdersDAO;
import com.app.dao.impl.ViewCartDAOImpl;
import com.app.dao.impl.ViewMyOrdersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.service.ViewMyOrdersService;

public class ViewMyOrdersServiceImpl implements ViewMyOrdersService{
	
	private ViewMyOrdersDAO viewMyOrdersDAO=new ViewMyOrdersDAOImpl();

	@Override
	public List<Order> viewMyOrders(Order order) throws BusinessException {
		List<Order> orderList = null;
		try {
			    orderList = viewMyOrdersDAO.viewMyOrders(order);
				System.out.println("Orders you have placed! ");
				
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

	

}
