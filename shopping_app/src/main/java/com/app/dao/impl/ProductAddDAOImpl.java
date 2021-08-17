package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.ProductAddDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ProductAddDAOImpl implements ProductAddDAO {
	
	private static Logger log = Logger.getLogger(ProductAddDAOImpl.class);

	@Override
	public int addProduct(Product product) throws BusinessException {
		int c=0;
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="insert into products(productId,productName,manufacturer,cost) values(?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(3, product.getManufacturer());
			preparedStatement.setDouble(4, product.getCost());
		
			
			c=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured");
		}
		return c;
	}

	@Override
	public int updateCost(int id, double cost) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	

}
