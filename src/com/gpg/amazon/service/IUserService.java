package com.gpg.amazon.service;

import com.gpg.amazon.entity.User;

public interface IUserService {

	/**
	 * 判断用户名是否存在
	 * 
	 * @param userName
	 * @return 存在返回 true 不存在返回false
	 */
	public abstract boolean getUserByUserName(String userName);

	/**
	 * 通过emali判断用户名是否存在
	 * 
	 * @param email
	 * @return 存在返回true 不存在返回false
	 */
	public abstract boolean getUserByEmail(String email);

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return 注册成功返回true否则返回false
	 */
	public abstract boolean registerUser(User user);

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public abstract User Login(User user);
	
	public abstract User getUserById(int id);
}
