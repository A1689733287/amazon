package com.gpg.amazon.service;

import java.util.List;

import com.gpg.amazon.entity.News;

public interface INewsService {
	/**
	 * 列出所有的新闻列表
	 * @return
	 */
	public abstract List<News> queryAllNews();

	/**
	 * 通过列表查询所有新闻
	 * @param id
	 * @return
	 */
	public abstract News queryNewsById(int id);

}
