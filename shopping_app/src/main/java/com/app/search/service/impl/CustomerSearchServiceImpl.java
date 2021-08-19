package com.app.search.service.impl;

import java.util.List;


import com.app.dao.CustomerSearchDAO;
import com.app.dao.impl.CustomerSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.app.search.service.*;
public class CustomerSearchServiceImpl implements CustomerSearchService {
	
	private CustomerSearchDAO customerSearchDAO=new CustomerSearchDAOImpl();

	@Override
	public Customer getCustomerById(int id) throws BusinessException {
		Customer customer = null;
		if(id>1000) {
			throw new BusinessException("Invalid Customer Id "+id);
		}else {
			customer = customerSearchDAO.getCustomerById(id);
			
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomerByName(String customerName) throws BusinessException {
		List<Customer> customers=null;
		if(customerName.matches("[a-zA-Z]{2,10}")) {
			customers=customerSearchDAO.getCustomerByName(customerName);
		}else {
			throw new BusinessException("Invalid Name! : "+customerName);
		}
		return customers;
	}

	@Override
	public Customer getCustomerByEmail(String customerEmail) throws BusinessException {
		Customer email = null;
		if(!customerEmail.contains("@")) {
			throw new BusinessException("Invalid Email "+customerEmail);
		}else {
			//code here to DAO
			email = customerSearchDAO.getCustomerByEmail(customerEmail);
			
		}
		return email;
	}

	@Override
	public Customer getCustomerByOrderId(int orderId) throws BusinessException {
		Customer customer = null;
		if(orderId>1000) {
			throw new BusinessException("Invalid Order Id "+orderId);
		}else {
			customer = customerSearchDAO.getCustomerById(orderId);
			
		}
		return customer;
	
		
	}

	

}
