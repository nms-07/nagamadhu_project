package com.app.service.impl;

import com.app.dao.MarkOrderStatusDAO;
import com.app.dao.impl.MarkOrderStatusDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.service.MarkOrderStatusService;

public class MarkOrderStatusServiceImpl implements MarkOrderStatusService {
	
	private MarkOrderStatusDAO markOrderDAO=new MarkOrderStatusDAOImpl();

	@Override
	public int markOrderStatus(Order order) throws BusinessException {
		try {
			if (markOrderDAO.markOrderStatus(order)==1) {
				System.out.println("Updated your Order status successfully");
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
