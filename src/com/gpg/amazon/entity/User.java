package com.gpg.amazon.entity;

/**
 * 用户实体类
 * 
 * @author G
 *
 */

public class User {
	private long uid;
	private String uname;
	private String upwd;
	private String sex;
	private String birthday;
	private String identity_code;
	private String email;
	private String mobile;
	private String address;
	private int status;

	public User() {
		super();
	}

	public User(String uname, String upwd, String sex, String birthday, String identity_code, String email,
			String mobile, String address, int status) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.birthday = birthday;
		this.identity_code = identity_code;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
	}

	public User(long uid, String uname, String upwd, String sex, String birthday, String identity_code, String email,
			String mobile, String address, int status) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.birthday = birthday;
		this.identity_code = identity_code;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
		this.status = status;
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

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdentity_code() {
		return identity_code;
	}

	public void setIdentity_code(String identity_code) {
		this.identity_code = identity_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", sex=" + sex + ", birthday=" + birthday
				+ ", identity_code=" + identity_code + ", email=" + email + ", mobile=" + mobile + ", address="
				+ address + ", status=" + status + "]";
	}

}
