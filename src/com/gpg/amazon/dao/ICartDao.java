package com.gpg.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.entity.Cart;

public interface ICartDao {
	/**
	 * 通过用户查询购物车记录
	 * 
	 * @param uid
	 *            用户id
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Cart> queryCartByUid(long uid) throws SQLException;

	/**
	 * 查询所有的购物车记录
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Cart> queryCartByUid() throws SQLException;

	/**
	 * 插入购物车记录
	 * 
	 * @param cart
	 * @return
	 * @throws SQLException
	 */
	public abstract int insertCart(Cart cart) throws SQLException;

	/**
	 * 通过id删除购物车记录
	 * 
	 * @param cid
	 * @return
	 * @throws SQLException
	 */
	public abstract int deleteCart(int cid) throws SQLException;

	/**
	 * 通过pid修改商品记录
	 * 
	 * @param quantity
	 *            数量
	 * @param pid
	 *            商品id
	 * @return
	 * @throws SQLException
	 */
	public abstract int updateCart(long quantity, long pid) throws SQLException;

	/**
	 * 通过cid修改商品记录
	 * 
	 * @param quantity
	 *            商品数量
	 * @param cid
	 *            cid
	 * @return
	 * @throws SQLException
	 */
	public abstract int alterCartCount(long quantity, long cid) throws SQLException;
	
	public abstract Cart queryCartByPid(long pid)  throws SQLException;
}
