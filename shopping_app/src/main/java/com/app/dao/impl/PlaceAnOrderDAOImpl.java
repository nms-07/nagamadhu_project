package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.PlaceAnOrderDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class PlaceAnOrderDAOImpl implements PlaceAnOrderDAO  {

	@Override
	public int placeAnOrder(Cart cart) throws BusinessException {
		int d = 0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into orders(customerId,productId) select customerId,productId from cart where customerId = ? ;";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, cart.getCustomerId());
			preparedStatement.executeUpdate();
			
			String sqL = "delete from cart where customerId = ?";
			PreparedStatement preparedStatemenT =connection.prepareStatement(sqL);
			preparedStatemenT.setInt(1, cart.getCustomerId());
			d = preparedStatemenT.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			//log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return d;
	}
	
	

	
}
