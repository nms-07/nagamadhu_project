package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface MarkAsShippedDAO {
	public int markDelivered(Order order) throws BusinessException;
}
