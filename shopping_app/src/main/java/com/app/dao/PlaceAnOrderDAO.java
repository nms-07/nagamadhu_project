package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface PlaceAnOrderDAO {
	
	public int placeAnOrder(Cart cart) throws BusinessException;

}
