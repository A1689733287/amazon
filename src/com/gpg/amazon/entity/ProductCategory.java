package com.gpg.amazon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 小类别
 * 
 * @author G
 *
 */
public class ProductCategory {

	private long p_cate_id;
	private String p_cate_name;
	private long p_cate_parent_id;
	private List<ProductCategory> productCategories = new ArrayList<>();
	private List<Product> list = new ArrayList<>();

	public ProductCategory() {
		super();
	}

	public ProductCategory(long p_cate_id, String p_cate_name, long p_cate_parent_id) {
		super();
		this.p_cate_id = p_cate_id;
		this.p_cate_name = p_cate_name;
		this.p_cate_parent_id = p_cate_parent_id;
	}

	public ProductCategory(String p_cate_name, long p_cate_parent_id) {
		super();
		this.p_cate_name = p_cate_name;
		this.p_cate_parent_id = p_cate_parent_id;
	}

	public long getP_cate_id() {
		return p_cate_id;
	}

	public void setP_cate_id(long p_cate_id) {
		this.p_cate_id = p_cate_id;
	}

	public String getP_cate_name() {
		return p_cate_name;
	}

	public void setP_cate_name(String p_cate_name) {
		this.p_cate_name = p_cate_name;
	}

	public long getP_cate_parent_id() {
		return p_cate_parent_id;
	}

	public void setP_cate_parent_id(long p_cate_parent_id) {
		this.p_cate_parent_id = p_cate_parent_id;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public List<ProductCategory> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(List<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	@Override
	public String toString() {
		return "ProductCategory [p_cate_id=" + p_cate_id + ", p_cate_name=" + p_cate_name + ", p_cate_parent_id="
				+ p_cate_parent_id + "]";
	}

}
