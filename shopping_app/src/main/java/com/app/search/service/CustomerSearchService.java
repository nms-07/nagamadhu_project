package com.app.search.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
public interface CustomerSearchService {
	
	public Customer getCustomerById(int id) throws BusinessException;
	public List<Customer> getCustomerByName(String customerName) throws BusinessException;
	public Customer getCustomerByEmail (String customerEmail) throws BusinessException;
	public Customer getCustomerByOrderId(int orderId) throws BusinessException; 

}
