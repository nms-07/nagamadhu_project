package com.app.service.impl;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.impl.CustomerLoginDAOImpl;
import com.app.exception.BusinessException;
import com.app.service.*;
public class CustomerLoginServiceImpl implements CustomerLoginService {
	
	private CustomerLoginDAO customerLoginDAO=new CustomerLoginDAOImpl();

	@Override
	public boolean customerLogin(String email, String password) throws BusinessException {
		boolean w = false;
		try {
			if (customerLoginDAO.customerLogin(email,password)) {
				w = true;
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return w;
	}
	
	

}
