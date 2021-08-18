package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.CustomerLoginDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Customer;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CustomerLoginDAOImpl implements CustomerLoginDAO {
	
	public static int cd;

	@Override
	public boolean customerLogin(String email, String password) throws BusinessException {
		//StringBuilder sb = new StringBuilder();
		boolean result = false;
		try(Connection connection=MySqlDbConnection.getConnection()){
			//String sql="select exists(select * from customers where customerEmail = ? and customerPassword = ?);";
			String sql = "select customerId,customerEmail,customerPassword from customers where customerEmail = ? and customerPassword = ?";	
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				cd = resultSet.getInt(1);
				result = true;
			}
			else {
				throw new BusinessException("Customer not registered");
				
			}
//			if(resultSet.next()) {
//				sb.append(resultSet.getString("customerEmail"));
//				sb.append(resultSet.getString("customerPassword"));
//			}
//			if(sb.toString().contains(email) && sb.toString().contains(password)) {
//				result = true;
//			}
		
            
           
		} catch (ClassNotFoundException | SQLException e) {
			//System.out.println(e);
			throw new BusinessException(e+"Internal error occured");
		}
		return result;
	}
	
	



	
	
	


	

}
