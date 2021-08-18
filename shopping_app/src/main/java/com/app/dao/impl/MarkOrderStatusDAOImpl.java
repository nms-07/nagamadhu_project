package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.MarkOrderStatusDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Order;

public class MarkOrderStatusDAOImpl implements MarkOrderStatusDAO {

	@Override
	public int markOrderStatus(Order order) throws BusinessException {
		int c = 0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="update orders set orderStatus = 'received' where customerId = ? and productId = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, order.getCustomerId());
			preparedStatement.setInt(2, order.getProductId());
			c = preparedStatement.executeUpdate();
		
		} catch (ClassNotFoundException | SQLException e) {
			//log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return c;
	}

	

}