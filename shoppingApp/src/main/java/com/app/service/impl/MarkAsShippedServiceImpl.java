package com.app.service.impl;

import com.app.dao.MarkAsShippedDAO;
import com.app.dao.impl.MarkAsShippedDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.service.MarkAsShippedService;

public class MarkAsShippedServiceImpl implements MarkAsShippedService {
	
	private MarkAsShippedDAO markDeliveredDAO=new MarkAsShippedDAOImpl();

	@Override
	public int markDelivered(Order order) throws BusinessException {
		try {
			if (markDeliveredDAO.markDelivered(order)==1) {
				
		}
		} catch (BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
		return 1;
	}

	

}
