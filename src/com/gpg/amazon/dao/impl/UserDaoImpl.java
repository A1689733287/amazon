package com.gpg.amazon.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.gpg.amazon.dao.IUserDao;
import com.gpg.amazon.entity.User;
import com.gpg.amazon.util.C3P0Util;

public class UserDaoImpl implements IUserDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public User getUserByUserName(String userName) throws SQLException {
		String sql = "select uid, uname, upwd, sex, birthday, identity_code, email, mobile, address, status from t_user where uname = ?";
		return qr.query(sql, new BeanHandler<>(User.class), userName);
	}

	@Override
	public User getUserByEmail(String email) throws SQLException {
		String sql = "select uid, uname, upwd, sex, birthday, identity_code, email, mobile, address, status from t_user where email = ?";
		return qr.query(sql, new BeanHandler<>(User.class), email);
	}

	@Override
	public int registerUser(User user) throws SQLException {
		String sql = "INSERT INTO t_user(uname, upwd, sex, birthday, identity_code, email, mobile, address, status)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Object[] objects = new Object[] { user.getUname(), user.getUpwd(), user.getSex(), user.getBirthday(),
				user.getIdentity_code(), user.getEmail(), user.getMobile(), user.getAddress(), user.getStatus() };
		return qr.update(sql, objects);
	}

	@Override
	public User Login(User user) throws SQLException {
		String sql = "select uid, uname, upwd, sex, birthday, identity_code, email, mobile, address, status from t_user where uname = ? and upwd = ?";
		return qr.query(sql, new BeanHandler<>(User.class), user.getUname(), user.getUpwd());
	}

	@Override
	public User getUserById(int id) throws SQLException {
		String sql = "select uid, uname, upwd, sex, birthday, identity_code, email, mobile, address, status from t_user where uid = ?";
		return qr.query(sql, new BeanHandler<>(User.class), id);
	}

}
