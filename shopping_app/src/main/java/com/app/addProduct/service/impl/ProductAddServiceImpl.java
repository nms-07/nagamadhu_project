package com.app.addProduct.service.impl;

import com.app.addProduct.service.ProductAddService;
import com.app.dao.ProductAddDAO;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductAddServiceImpl implements ProductAddService {
	
	private ProductAddDAO productaddDAO=new ProductAddDAOImpl();

	@Override
	public int addProduct(Product product) throws BusinessException {
		try {
			if (productaddDAO.addProduct(product) == 1) {
				System.out.println("Product created with below details successfully");
				System.out.println(product);
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int updateCost(int id, double cost) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	

}
