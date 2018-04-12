package com.gpg.amazon.dao;

import java.sql.SQLException;
import java.util.List;

import com.gpg.amazon.entity.News;

public interface INewsDao {
	/**
	 * 列出所有的新闻列表
	 * @return
	 */
	public abstract List<News> queryAllNews() throws SQLException;

	/**
	 * 通过列表查询所有新闻
	 * @param id
	 * @return
	 */
	public abstract News queryNewsById(int id) throws SQLException;

}
