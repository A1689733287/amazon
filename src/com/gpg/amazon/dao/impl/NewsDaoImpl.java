package com.gpg.amazon.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gpg.amazon.dao.INewsDao;
import com.gpg.amazon.entity.News;
import com.gpg.amazon.util.C3P0Util;

public class NewsDaoImpl implements INewsDao {
	QueryRunner qr = C3P0Util.getQueryRunner();

	@Override
	public List<News> queryAllNews() throws SQLException {
		String sql = "SELECT nid, news_title, news_content, news_create_time FROM t_news order by nid desc limit 5 ";
		return qr.query(sql, new BeanListHandler<>(News.class));
	}

	@Override
	public News queryNewsById(int id) throws SQLException {
		String sql = "SELECT nid, news_title, news_content, news_create_time FROM t_news where nid = ?";
		return qr.query(sql, new BeanHandler<>(News.class), id);
	}

}
