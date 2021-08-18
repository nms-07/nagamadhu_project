package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Product;
import java.util.List;

public interface ListProductsService {
	public List<Product> listProducts(Product product) throws BusinessException;
}
