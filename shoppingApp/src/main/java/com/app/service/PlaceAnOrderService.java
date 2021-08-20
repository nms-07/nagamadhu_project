package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface PlaceAnOrderService {
	
	public int placeAnOrder(Cart cart) throws BusinessException;
	

}
