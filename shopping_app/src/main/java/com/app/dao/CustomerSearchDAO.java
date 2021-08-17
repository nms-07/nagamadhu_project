package com.app.dao;

import java.util.List;
import com.app.model.*;
import com.app.exception.*;

public interface CustomerSearchDAO {
	
	public Customer getCustomerById(int id) throws BusinessException;
	public List<Customer> getCustomerByName(String customerName) throws BusinessException;
	public Customer getCustomerByEmail (String customerEmail) throws BusinessException;
	public Customer getCustomerByOrderId(int orderId) throws BusinessException; 
}
