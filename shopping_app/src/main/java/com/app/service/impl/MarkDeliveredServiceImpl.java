package com.app.service.impl;

import com.app.dao.MarkDeliveredDAO;
import com.app.dao.impl.MarkDeliveredDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;

public class MarkDeliveredServiceImpl implements MarkDeliveredService {
	
	private MarkDeliveredDAO markDeliveredDAO=new MarkDeliveredDAOImpl();

	@Override
	public int markDelivered(Order order) throws BusinessException {
		try {
			if (markDeliveredDAO.markDelivered(order)==1) {
				System.out.println("Updated the Order Status to delivered");
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
