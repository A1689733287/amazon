package com.gpg.amazon.entity;

/**
 * 购物车
 * 
 * @author G
 *
 */
public class Cart {
	private long cid;
	private long pid;
	private long quantity;
	private long userId;
	private Product product;

	public Cart() {
		super();
	}

	public Cart(long pid, long quantity, long userId) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.userId = userId;
	}

	public Cart(long cid, long pid, long quantity, long userId) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.quantity = quantity;
		this.userId = userId;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", pid=" + pid + ", quantity=" + quantity + ", userId=" + userId + "]";
	}

}
