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
				System.out.println("Customer registered with below details successfully");
				System.out.println(customer);
				
		}
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	

}
