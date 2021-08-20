package com.app.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewCartDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.Product;


public class ViewCartDAOImpl implements ViewCartDAO{
	
	private static Logger log = Logger.getLogger(ViewCartDAOImpl.class);

	@Override
	public List<Cart> viewCart(Cart cart) throws BusinessException {
		List<Cart> cartList = new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql = "select cart.productId ,cart.customerId,products.productName,products.manufacturer,products.cost from cart join products on products.productId = cart.productId where cart.customerId =?;";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerLoginDAOImpl.cd);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Cart carrt= new Cart();
				carrt.setProductId(resultSet.getInt(1));
				carrt.setCustomerId(resultSet.getInt(2));
				Product product=new Product();
				product.setName(resultSet.getString(3));
				product.setManufacturer(resultSet.getString(4));
				product.setCost(resultSet.getDouble(5));
				carrt.setProduct(product);
				cartList.add(carrt);
			}
			
			if(cartList.size()==0) {
				throw new BusinessException("No Products in the Cart ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return cartList;
		
		
	}

	
}
