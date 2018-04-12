package com.gpg.amazon.service;

import java.util.List;

import com.gpg.amazon.entity.PageModel;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.entity.ProductCategory;

public interface IProductCategoryService {
	public abstract List<ProductCategory> queryProductCategory();

	public abstract PageModel<Product> queryProductByc_id(int c_id, int currentPage, int pageSize);

	public abstract PageModel<Product> queryProductBycParentId(int c_child_id, int currentPage, int pageSize);
	
	public abstract ProductCategory getPCateByCid(long cid);

	public abstract ProductCategory getPCateByCChildId(long c_childId);
}
