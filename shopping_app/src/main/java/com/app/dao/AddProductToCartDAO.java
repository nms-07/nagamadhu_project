package com.app.dao;

import com.app.exception.BusinessException;

public interface AddProductToCartDAO {
	
	public int addProductToCart(int id) throws BusinessException;

}
