package com.gpg.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gpg.amazon.dao.ICartDao;
import com.gpg.amazon.entity.Cart;
import com.gpg.amazon.util.C3P0Util;

public class CartDaoImpl implements ICartDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public List<Cart> queryCartByUid(long uid) throws SQLException {
		String sql = "select cid, pid, quantity, userId from t_cart where userId = ?";
		return qr.query(sql, new BeanListHandler<>(Cart.class), uid);
	}

	@Override
	public List<Cart> queryCartByUid() throws SQLException {
		String sql = "select cid, pid, quantity, userId from t_cart";
		return qr.query(sql, new BeanListHandler<>(Cart.class));
	}

	@Override
	public int insertCart(Cart cart) throws SQLException {
		String sql = "insert into t_cart(pid, quantity, userId) values(?,?,?)";
		return qr.update(sql, cart.getPid(), cart.getQuantity(), cart.getUserId());
	}

	@Override
	public int deleteCart(int cid) throws SQLException {
		String sql = "delete from t_cart where cid = ? ";
		return qr.update(sql, cid);
	}

	@Override
	public int updateCart(long quantity, long pid) throws SQLException {
		String sql = "update t_cart set quantity = quantity + ? where pid = ?";
		return qr.update(sql, quantity, pid);
	}

	@Override
	public int alterCartCount(long quantity, long cid) throws SQLException {
		String sql = "update t_cart set quantity = ? where cid = ?";
		return qr.update(sql, quantity, cid);
	}

	@Override
	public Cart queryCartByPid(long pid) throws SQLException {
		String sql = "select cid, pid, quantity, userId from t_cart where pid = ?";
		return qr.query(sql, new BeanHandler<>(Cart.class), pid);
	}

}
