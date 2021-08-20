package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface AddProductToCartDAO {
	
	public int addProductToCart(Cart cart) throws BusinessException;

}
