package com.app.service.impl;

import com.app.dao.AddProductToCartDAO;
import com.app.dao.impl.AddProductToCartDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.AddProductToCartService;

public class AddProductToCartServiceImpl implements AddProductToCartService {
	
	private AddProductToCartDAO addProductServiceDAO=new AddProductToCartDAOImpl();

	@Override
	public int addProductToCart(int id) throws BusinessException {
		int c = 0;
		try {
			if (addProductServiceDAO.addProductToCart(id)==1) {
				System.out.println("Product added to cart successfully");
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
