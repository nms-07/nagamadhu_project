package com.app.dao;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface ViewCartDAO {
	public List<Cart> viewCart(Cart cart) throws BusinessException;
}
