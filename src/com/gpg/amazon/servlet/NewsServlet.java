package com.gpg.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gpg.amazon.entity.News;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.impl.NewsServiceImpl;

public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsServiceImpl newsService = Factory.getInstance("newsService", NewsServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/newsAll".equals(path)) {
			newsAll(req, resp);
		}
		if ("/newsDetail".equals(path)) {
			newsDetail(req, resp);
		}
	}

	private void newsDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nid = req.getParameter("nid");
		News news = newsService.queryNewsById(Integer.parseInt(nid));
		req.setAttribute("news", news);
		req.getRequestDispatcher("newsAll").forward(req, resp);
	}

	private void newsAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<News> newsList = newsService.queryAllNews();
		req.setAttribute("newsList", newsList);
		req.getRequestDispatcher("news_view.jsp").forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}