package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface AddProductToCartService {
	
	public int addProductToCart(Cart cart) throws BusinessException;

}
