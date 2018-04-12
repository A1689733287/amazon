package com.gpg.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gpg.amazon.dao.IProductCategoryDao;
import com.gpg.amazon.entity.ProductCategory;
import com.gpg.amazon.util.C3P0Util;

public class ProductCategoryDaoImpl implements IProductCategoryDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public List<ProductCategory> queryProductCategory() throws SQLException {
		String sql = "select p_cate_id, p_cate_name, p_cate_parent_id from t_product_category";
		return qr.query(sql, new BeanListHandler<>(ProductCategory.class));
	}

	@Override
	public List<ProductCategory> queryProductCategoryByPcid(long pcid) throws SQLException {
		String sql = "select p_cate_id, p_cate_name, p_cate_parent_id from t_product_category where p_cate_parent_id=?";
		return qr.query(sql, new BeanListHandler<>(ProductCategory.class), pcid);
	}

	@Override
	public ProductCategory getPCateByCid(long cid) throws SQLException {
		String sql = "select p_cate_id, p_cate_name, p_cate_parent_id from t_product_category where p_cate_id=?";
		return qr.query(sql, new BeanHandler<>(ProductCategory.class), cid);
	}

	@Override
	public ProductCategory getPCateByCChildId(long c_childId) throws SQLException {
		String sql = "select p_cate_id, p_cate_name, p_cate_parent_id from t_product_category where p_cate_id=?";
		return qr.query(sql, new BeanHandler<>(ProductCategory.class), c_childId);
	}

}
