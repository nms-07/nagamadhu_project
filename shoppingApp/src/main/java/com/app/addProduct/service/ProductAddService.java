package com.app.addProduct.service;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductAddService {
	
	public int addProduct(Product product) throws BusinessException;
	//public int updateCost(int id, double cost) throws BusinessException;

}
