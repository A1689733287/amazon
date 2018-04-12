package com.gpg.amazon.entity;

/**
 * 订单详细表
 * 
 * @author G
 *
 */
public class OrderDetail {

	private long od_id;
	private long o_id;
	private long p_id;
	private long od_quantity;
	private long od_cost;

	public OrderDetail() {
		super();
	}

	public OrderDetail(long o_id, long p_id, long od_quantity, long od_cost) {
		super();
		this.o_id = o_id;
		this.p_id = p_id;
		this.od_quantity = od_quantity;
		this.od_cost = od_cost;
	}

	public OrderDetail(long od_id, long o_id, long p_id, long od_quantity, long od_cost) {
		super();
		this.od_id = od_id;
		this.o_id = o_id;
		this.p_id = p_id;
		this.od_quantity = od_quantity;
		this.od_cost = od_cost;
	}

	public long getOd_id() {
		return od_id;
	}

	public void setOd_id(long od_id) {
		this.od_id = od_id;
	}

	public long getO_id() {
		return o_id;
	}

	public void setO_id(long o_id) {
		this.o_id = o_id;
	}

	public long getP_id() {
		return p_id;
	}

	public void setP_id(long p_id) {
		this.p_id = p_id;
	}

	public long getOd_quantity() {
		return od_quantity;
	}

	public void setOd_quantity(long od_quantity) {
		this.od_quantity = od_quantity;
	}

	public long getOd_cost() {
		return od_cost;
	}

	public void setOd_cost(long od_cost) {
		this.od_cost = od_cost;
	}

	@Override
	public String toString() {
		return "OrderDetail [od_id=" + od_id + ", o_id=" + o_id + ", p_id=" + p_id + ", od_quantity=" + od_quantity
				+ ", od_cost=" + od_cost + "]";
	}

}
