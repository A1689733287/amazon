package com.gpg.amazon.service;

import java.util.List;

import com.gpg.amazon.entity.PageModel;
import com.gpg.amazon.entity.Product;

public interface IProductService {
	public abstract List<Product> queryProductByName(String pname);

	public abstract PageModel<Product> getAllProduct(int currentPage, int pageSize);

	public abstract List<Product> getHotProduct();
	
	public abstract Product queryProductByPid(int pid);
}
