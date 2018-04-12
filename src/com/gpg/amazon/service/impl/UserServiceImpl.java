package com.gpg.amazon.service.impl;

import java.sql.SQLException;

import com.gpg.amazon.dao.impl.UserDaoImpl;
import com.gpg.amazon.entity.User;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.IUserService;

public class UserServiceImpl implements IUserService {
	private UserDaoImpl userDao = Factory.getInstance("userDao", UserDaoImpl.class);

	@Override
	public boolean getUserByUserName(String userName) {
		try {
			User user = userDao.getUserByUserName(userName);
			if (user != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getUserByEmail(String email) {
		try {
			User user = userDao.getUserByEmail(email);
			if (user != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerUser(User user) {
		try {
			int row = userDao.registerUser(user);
			return row > 0? true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User Login(User user) {
		try {
			return userDao.Login(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		try {
			return userDao.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
