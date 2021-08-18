package com.app.service.impl;

import com.app.dao.PlaceAnOrderDAO;
import com.app.dao.impl.PlaceAnOrderDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.service.PlaceAnOrderService;

public class PlaceAnOrderServiceImpl implements PlaceAnOrderService{
	
	private PlaceAnOrderDAO placeAnOrderDAO=new PlaceAnOrderDAOImpl();

	@Override
	public int placeAnOrder(Cart cart) throws BusinessException {
		try {
			if (placeAnOrderDAO.placeAnOrder(cart)==1) {
				System.out.println("Ordered your product successfully");
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
