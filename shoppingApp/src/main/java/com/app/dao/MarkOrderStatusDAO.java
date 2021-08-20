package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Order;

public interface MarkOrderStatusDAO {
	
	public int markOrderStatus(Order order) throws BusinessException;

}
