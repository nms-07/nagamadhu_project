package com.app.service.impl;

import com.app.dao.AddProductToCartDAO;
import com.app.dao.impl.AddProductToCartDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.service.AddProductToCartService;

public class AddProductToCartServiceImpl implements AddProductToCartService {
	
	private AddProductToCartDAO addProductToCartDAO=new AddProductToCartDAOImpl();

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		try {
			if (addProductToCartDAO.addProductToCart(cart)==1) {
				System.out.println("Product added to cart successfully");
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
