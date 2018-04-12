package com.gpg.amazon.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.dao.impl.ProductDaoImpl;
import com.gpg.amazon.entity.PageModel;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.IProductService;

public class ProductServiceImpl implements IProductService {
	ProductDaoImpl productDao = Factory.getInstance("productDao", ProductDaoImpl.class);

	@Override
	public List<Product> queryProductByName(String pname) {
		try {
			return productDao.queryProductByName(pname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageModel<Product> getAllProduct(int currentPage, int pageSize) {
		try {
			long count = productDao.getCount();
			List<Product> list = productDao.getAllProduct(currentPage, pageSize);

			PageModel<Product> pageModel = new PageModel<Product>(pageSize, count, currentPage, list);
			return pageModel;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<Product> getHotProduct() {
		try {
			return productDao.getHotProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product queryProductByPid(int pid) {
		try {
			return productDao.queryProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
