package com.app.addProduct.service.impl;

import org.apache.log4j.Logger;

import com.app.addProduct.service.ProductAddService;
import com.app.dao.ProductAddDAO;
import com.app.dao.impl.ProductAddDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductAddServiceImpl implements ProductAddService {
	
	private ProductAddDAO productaddDAO=new ProductAddDAOImpl();
	
	private static Logger log = Logger.getLogger(ProductAddServiceImpl.class);

	@Override
	public int addProduct(Product product) throws BusinessException {
		try {
			if (productaddDAO.addProduct(product) == 1) {
				log.info(product);			
			}
		} catch (BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
		return 1;
	}


//	public int updateCost(int id, double cost) throws BusinessException {
//		try {
//			Product product = new Product();
//			if (productaddDAO.updateCost(id,cost) == 1) {
//				log.info(product);			
//			}
//		} catch (BusinessException e) {
//			throw new BusinessException(e.getMessage());
//		}
//		return 1;
//	}
	
	
	
	

}
