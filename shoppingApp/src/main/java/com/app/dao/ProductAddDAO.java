package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ProductAddDAO {
	
	public int addProduct(Product product) throws BusinessException;
	//public int updateCost(int id, double cost) throws BusinessException;
}
