package com.gpg.amazon.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.dao.impl.CartDaoImpl;
import com.gpg.amazon.dao.impl.ProductDaoImpl;
import com.gpg.amazon.entity.Cart;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.ICartService;

public class CartServiceImpl implements ICartService {
	CartDaoImpl cartDao = Factory.getInstance("cartDao", CartDaoImpl.class);
	ProductDaoImpl productDao = Factory.getInstance("productDao", ProductDaoImpl.class);

	@Override
	public List<Cart> queryCartByUid(long uid) {
		try {
			List<Cart> list = cartDao.queryCartByUid(uid);
			for (Cart cart : list) {
				Product product = productDao.queryProductByPid(cart.getPid());
				cart.setProduct(product);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cart> queryCartByUid() {
		try {
			return cartDao.queryCartByUid();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertCart(Cart cart) {
		try {
			System.out.println(cart);
			Cart cartByPid = cartDao.queryCartByPid(cart.getPid());
			if (cartByPid != null) {
				System.out.println("------------------------");
				return cartDao.updateCart(cart.getQuantity(), cart.getPid());
			} else {
				System.out.println("=========================");
				return cartDao.insertCart(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCart(int cid) {
		try {
			return cartDao.deleteCart(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int alterCartCount(long quantity, long cid) {
		try {
			return cartDao.alterCartCount(quantity, cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
