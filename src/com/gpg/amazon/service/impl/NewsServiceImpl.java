package com.gpg.amazon.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.dao.impl.NewsDaoImpl;
import com.gpg.amazon.entity.News;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.INewsService;

public class NewsServiceImpl implements INewsService {
	NewsDaoImpl newsDao = Factory.getInstance("newsDao", NewsDaoImpl.class);

	@Override
	public List<News> queryAllNews() {
		try {
			return newsDao.queryAllNews();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public News queryNewsById(int id) {
		try {
			return newsDao.queryNewsById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
