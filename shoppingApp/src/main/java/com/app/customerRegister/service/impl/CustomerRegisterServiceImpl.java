package com.app.customerRegister.service.impl;

import com.app.customerRegister.service.CustomerRegisterService;
import com.app.dao.CustomerRegisterDAO;
import com.app.dao.impl.CustomerRegisterDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;

public class CustomerRegisterServiceImpl implements CustomerRegisterService {
	
	private CustomerRegisterDAO customerRegisterDAO=new CustomerRegisterDAOImpl();

	@Override
	public int registerCustomer(Customer customer) throws BusinessException {
		try {
			if (customerRegisterDAO.customerRegister(customer) == 1) {
				
		}
		} catch (BusinessException e) {
			throw new BusinessException(e.getMessage());
		}
		return 1;
	}

	

}
