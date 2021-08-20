package com.app.search.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.model.OrderId;
public interface CustomerSearchService {
	
	public Customer getCustomerById(int id) throws BusinessException;
	public List<Customer> getCustomerByName(String customerName) throws BusinessException;
	public Customer getCustomerByEmail (String customerEmail) throws BusinessException;
	public OrderId getCustomerByOrderId(int orderId) throws BusinessException; 

}
