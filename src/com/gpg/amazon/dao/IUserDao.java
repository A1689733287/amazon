package com.gpg.amazon.dao;

import java.sql.SQLException;

import com.gpg.amazon.entity.User;

public interface IUserDao {
	/**
	 * 通过用户查询用户
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public abstract User getUserByUserName(String userName) throws SQLException;

	/**
	 * 通过邮箱查询用户
	 * 
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public abstract User getUserByEmail(String email) throws SQLException;

	/**
	 * 注册用户
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public abstract int registerUser(User user) throws SQLException;

	/**
	 * 登录
	 * 
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public abstract User Login(User user) throws SQLException;

	/**
	 * 通过用户id查找用户
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public abstract User getUserById(int id) throws SQLException;
}
