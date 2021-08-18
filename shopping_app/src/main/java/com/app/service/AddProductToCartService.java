package com.app.service;

import com.app.exception.BusinessException;

public interface AddProductToCartService {
	
	public int addProductToCart(int id) throws BusinessException;

}
