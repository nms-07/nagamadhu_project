package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewMyOrdersDAO;
import com.app.dao.dbutil.MySqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.Product;

public class ViewMyOrdersDAOImpl implements ViewMyOrdersDAO {
	
	private static Logger log = Logger.getLogger(ViewMyOrdersDAOImpl.class);

	@Override
	public List<Order> viewMyOrders(Order order) throws BusinessException {
		List<Order> ordersList = new ArrayList<>();
		try(Connection connection=MySqlDbConnection.getConnection()){
			String sql = "select orders.productId ,orders.customerId,orders.orderStatus,products.productName,products.manufacturer,products.cost from orders join products on products.productId = orders.productId where orders.customerId =?;";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerLoginDAOImpl.cd);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Order ordEr= new Order();
				ordEr.setProductId(resultSet.getInt(1));
				ordEr.setCustomerId(resultSet.getInt(2));
				ordEr.setOrderStatus(resultSet.getString(3));
				Product product=new Product();
				product.setName(resultSet.getString(4));
				product.setManufacturer(resultSet.getString(5));
				product.setCost(resultSet.getDouble(6));
				ordEr.setProduct(product);
				ordersList.add(ordEr);
			}
			
			if(ordersList.size()==0) {
				throw new BusinessException("No Orders Placed ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
			throw new BusinessException("Internal error occured contact sysadmin");
		}
		return ordersList;
	}



}
