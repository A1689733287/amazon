package com.gpg.amazon.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.dao.impl.ProductCategoryDaoImpl;
import com.gpg.amazon.dao.impl.ProductDaoImpl;
import com.gpg.amazon.entity.PageModel;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.entity.ProductCategory;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.IProductCategoryService;

public class ProductCategoryServiceImpl implements IProductCategoryService {
	ProductCategoryDaoImpl productCategoryDao = Factory.getInstance("productCategoryDao", ProductCategoryDaoImpl.class);
	ProductDaoImpl productDao = Factory.getInstance("productDao", ProductDaoImpl.class);

	@Override
	public List<ProductCategory> queryProductCategory() {
		try {
			List<ProductCategory> category = productCategoryDao.queryProductCategory();
			for (ProductCategory productCategory : category) {
				List<ProductCategory> categoryByPcid = productCategoryDao
						.queryProductCategoryByPcid(productCategory.getP_cate_id());
				productCategory.setProductCategories(categoryByPcid);
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageModel<Product> queryProductByc_id(int c_id, int currentPage, int pageSize) {
		try {
			List<Product> productByPcid = productDao.queryProductByPcid(c_id, currentPage, pageSize);
			long pcIdCount = productDao.getPcIdCount(c_id);
			PageModel<Product> pageModel = new PageModel<>(pageSize, pcIdCount, currentPage, productByPcid);
			return pageModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageModel<Product> queryProductBycParentId(int c_child_id, int currentPage, int pageSize) {
		try {
			List<Product> productByPccid = productDao.queryProductByPcCid(c_child_id, currentPage, pageSize);
			long pcIdCount = productDao.getPccIdCount(c_child_id);
			PageModel<Product> pageModel = new PageModel<>(pageSize, pcIdCount, currentPage, productByPccid);
			return pageModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductCategory getPCateByCid(long cid) {
		try {
			return productCategoryDao.getPCateByCid(cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductCategory getPCateByCChildId(long c_childId) {
		try {
			return productCategoryDao.getPCateByCChildId(c_childId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
