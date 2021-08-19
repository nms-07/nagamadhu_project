package com.app.service.impl;

import java.util.List;

import com.app.dao.ViewAllOrdersDAO;
import com.app.dao.impl.ViewAllOrdersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.service.ViewAllOrdersService;

public class ViewAllOrderServiceImpl implements ViewAllOrdersService {
	
	private ViewAllOrdersDAO viewAllOrdersDAO=new ViewAllOrdersDAOImpl();

	@Override
	public List<Order> viewAllOrders(Order order) throws BusinessException {
		List<Order> orderList = null;
		try {
			    orderList = viewAllOrdersDAO.viewAllOrders(order);
				//System.out.println("Orders you have placed! ");
				
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return orderList;
	}

	
	
}
