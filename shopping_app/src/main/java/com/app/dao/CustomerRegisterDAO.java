package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerRegisterDAO {

	public int customerRegister(Customer customer) throws BusinessException;
	
}
