package com.app.service;

import com.app.exception.BusinessException;
import com.app.model.Customer;

public interface CustomerLoginService {
	public boolean customerLogin(String email, String password) throws BusinessException;
}
