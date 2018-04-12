package com.gpg.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.gpg.amazon.dao.IProductDao;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.util.C3P0Util;

public class ProductDaoImpl implements IProductDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public List<Product> queryProductByName(String pname) throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product where p_name = ?";
		return qr.query(sql, new BeanListHandler<>(Product.class), pname);
	}

	@Override
	public long getCount() throws SQLException {
		String sql = "SELECT count(*) FROM t_product";
		return (long) qr.query(sql, new ScalarHandler<>());
	}

	@Override
	public List<Product> getAllProduct(int currentPage, int pageSize) throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product limit ?, ?";
		int start = (currentPage - 1) * pageSize;
		return qr.query(sql, new BeanListHandler<>(Product.class), start, pageSize);
	}

	@Override
	public List<Product> getHotProduct() throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product limit ?";
		return qr.query(sql, new BeanListHandler<>(Product.class), 5);
	}

	@Override
	public Product queryProductByPid(long pid) throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product where p_id=?";
		return qr.query(sql, new BeanHandler<>(Product.class), pid);
	}

	@Override
	public List<Product> queryProductByPcCid(long pccid, int currentPage, int pageSize) throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product where p_cate_child_id=? limit ?, ?";
		int start = (currentPage - 1) * pageSize;
		return qr.query(sql, new BeanListHandler<>(Product.class), pccid, start, pageSize);
	}

	@Override
	public List<Product> queryProductByPcid(long pcid, int currentPage, int pageSize) throws SQLException {
		String sql = "SELECT p_id, p_name, p_desc, p_price, p_stock, p_cate_id, p_cate_child_id, p_file_name FROM t_product where p_cate_id=? limit ?, ?";
		int start = (currentPage - 1) * pageSize;
		return qr.query(sql, new BeanListHandler<>(Product.class), pcid, start, pageSize);
	}

	@Override
	public long getPcIdCount(long pcid) throws SQLException {
		String sql = "SELECT count(*) FROM t_product where p_cate_id=?";
		return (long) qr.query(sql, new ScalarHandler<>(), pcid);
	}

	@Override
	public long getPccIdCount(long pccid) throws SQLException {
		String sql = "SELECT count(*) FROM t_product where p_cate_child_id=?";
		return (long) qr.query(sql, new ScalarHandler<>(), pccid);
	}


}
