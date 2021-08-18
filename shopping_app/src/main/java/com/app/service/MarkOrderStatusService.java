package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Order;

public interface MarkOrderStatusService {
	
	
	public int markOrderStatus(Order order) throws BusinessException;

}
