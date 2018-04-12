package com.gpg.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.entity.Product;

public interface IProductDao {

	/**
	 * 通过商品名称查询商品
	 * 
	 * @param pname
	 *            商品名称
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> queryProductByName(String pname) throws SQLException;

	/**
	 * 获取所有的商品数量
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract long getCount() throws SQLException;

	/**
	 * 分页查询
	 * 
	 * @param currentPage
	 *            当前页面
	 * @param pageSize
	 *            每页显示的记录数量
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> getAllProduct(int currentPage, int pageSize) throws SQLException;

	/**
	 * 获取销售量最高的商品
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> getHotProduct() throws SQLException;

	/**
	 * 通过商品id获取商品
	 * 
	 * @param pid
	 *            商品id
	 * @return
	 * @throws SQLException
	 */
	public abstract Product queryProductByPid(long pid) throws SQLException;

	/**
	 * 通过商品子类别查询商品
	 * 
	 * @param pccid
	 *            商品字id
	 * @param currentPage
	 *            当前页面
	 * @param pageSize
	 *            每页显示的记录数
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> queryProductByPcCid(long pccid, int currentPage, int pageSize) throws SQLException;

	/**
	 * 通过商品大类别查询商品
	 * 
	 * @param pcid
	 *            商品大类别
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            当前页显示的记录数
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Product> queryProductByPcid(long pcid, int currentPage, int pageSize) throws SQLException;

	/**
	 * 获取商品类别为pcid的商品的记录数
	 * 
	 * @param pcid
	 *            大类别商品
	 * @return
	 * @throws SQLException
	 */
	public abstract long getPcIdCount(long pcid) throws SQLException;

	/**
	 * 获取商品类别为pccid的商品的记录数
	 * 
	 * @param pccid
	 *            小类别商品
	 * @return
	 * @throws SQLException
	 */
	public abstract long getPccIdCount(long pccid) throws SQLException;
}
