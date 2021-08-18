package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.AddProductToCartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;



public class AddProductToCartDAOImpl implements AddProductToCartDAO {
	
	private static Logger log = Logger.getLogger(AddProductToCartDAOImpl.class);

	@Override
	public int addProductToCart(Cart cart) throws BusinessException {
		int c = 0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into cart(customerId,productId) values(?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, cart.getCustomerId());
			preparedStatement.setInt(2, cart.getProductId());
			c = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return c;
	}

	

}
