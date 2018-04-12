package com.gpg.amazon.entity;

/**
 * 产品表
 * 
 * @author G
 *
 */
public class Product {

	private long p_id;
	private String p_name;
	private String p_desc;
	private float p_price;
	private long p_stock;
	private long p_cate_id;
	private long p_cate_child_id;
	private String p_file_name;

	public Product() {
		super();
	}

	public Product(String p_name, String p_desc, float p_price, long p_stock, long p_cate_id, long p_cate_child_id,
			String p_file_name) {
		super();
		this.p_name = p_name;
		this.p_desc = p_desc;
		this.p_price = p_price;
		this.p_stock = p_stock;
		this.p_cate_id = p_cate_id;
		this.p_cate_child_id = p_cate_child_id;
		this.p_file_name = p_file_name;
	}

	public Product(long p_id, String p_name, String p_desc, float p_price, long p_stock, long p_cate_id,
			long p_cate_child_id, String p_file_name) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_desc = p_desc;
		this.p_price = p_price;
		this.p_stock = p_stock;
		this.p_cate_id = p_cate_id;
		this.p_cate_child_id = p_cate_child_id;
		this.p_file_name = p_file_name;
	}

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public float getP_price() {
		return p_price;
	}

	public void setP_price(float p_price) {
		this.p_price = p_price;
	}

	public long getP_stock() {
		return p_stock;
	}

	public void setP_stock(long p_stock) {
		this.p_stock = p_stock;
	}

	public long getP_cate_id() {
		return p_cate_id;
	}

	public void setP_cate_id(long p_cate_id) {
		this.p_cate_id = p_cate_id;
	}

	public long getP_cate_child_id() {
		return p_cate_child_id;
	}

	public void setP_cate_child_id(long p_cate_child_id) {
		this.p_cate_child_id = p_cate_child_id;
	}

	public String getP_file_name() {
		return p_file_name;
	}

	public void setP_file_name(String p_file_name) {
		this.p_file_name = p_file_name;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_desc=" + p_desc + ", p_price=" + p_price
				+ ", p_stock=" + p_stock + ", p_cate_id=" + p_cate_id + ", p_cate_child_id=" + p_cate_child_id
				+ ", p_file_name=" + p_file_name + "]";
	}

}
