package com.gpg.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.entity.ProductCategory;

public interface IProductCategoryDao {
	/**
	 * 查询商品类别
	 * 
	 * @return
	 * @throws SQLException
	 */
	public abstract List<ProductCategory> queryProductCategory() throws SQLException;

	/**
	 * 通过商品parent_id获取商品类别
	 * 
	 * @param pcid
	 * @return
	 * @throws SQLException
	 */
	public abstract List<ProductCategory> queryProductCategoryByPcid(long pcid) throws SQLException;

	public abstract ProductCategory getPCateByCid(long cid) throws SQLException;

	public abstract ProductCategory getPCateByCChildId(long c_childId) throws SQLException;
}
