package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface MarkDeliveredService {
	
	public int markDelivered(Order order) throws BusinessException;

}	
