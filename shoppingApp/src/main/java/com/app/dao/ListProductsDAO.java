package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Product;

public interface ListProductsDAO {
	
	public List<Product> listproducts(Product product) throws BusinessException;

}
