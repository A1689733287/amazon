package com.gpg.amazon.entity;

/**
 * 订单类
 * 
 * @author G
 *
 */
public class Order {
	private long oid;
	private long uid;
	private String uname;
	private String uaddress;
	private String o_create_time;
	private long o_cost;
	private long o_status;
	private long o_type;

	public Order() {
		super();
	}

	public Order(long oid, long uid, String uname, String uaddress, String o_create_time, long o_cost, long o_status,
			long o_type) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.o_create_time = o_create_time;
		this.o_cost = o_cost;
		this.o_status = o_status;
		this.o_type = o_type;
	}

	public Order(long uid, String uname, String uaddress, String o_create_time, long o_cost, long o_status,
			long o_type) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uaddress = uaddress;
		this.o_create_time = o_create_time;
		this.o_cost = o_cost;
		this.o_status = o_status;
		this.o_type = o_type;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getO_create_time() {
		return o_create_time;
	}

	public void setO_create_time(String o_create_time) {
		this.o_create_time = o_create_time;
	}

	public long getO_cost() {
		return o_cost;
	}

	public void setO_cost(long o_cost) {
		this.o_cost = o_cost;
	}

	public long getO_status() {
		return o_status;
	}

	public void setO_status(long o_status) {
		this.o_status = o_status;
	}

	public long getO_type() {
		return o_type;
	}

	public void setO_type(long o_type) {
		this.o_type = o_type;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", o_create_time="
				+ o_create_time + ", o_cost=" + o_cost + ", o_status=" + o_status + ", o_type=" + o_type + "]";
	}

}
