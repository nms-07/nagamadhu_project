package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ListProductsDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Product;

public class ListProductsDAOImpl implements ListProductsDAO {
	
	private static Logger log = Logger.getLogger(ListProductsDAOImpl.class);

	@Override
	public List<Product> listproducts(Product product) throws BusinessException {
		List<Product> products=new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql="select * from products;";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				product=new Product();
				product.setId(resultSet.getInt(1));
				product.setName(resultSet.getString(2));
				product.setManufacturer(resultSet.getString(3));
				product.setCost(resultSet.getDouble(4));
				products.add(product);
		
		}
		}catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return products;
	}

	

}
