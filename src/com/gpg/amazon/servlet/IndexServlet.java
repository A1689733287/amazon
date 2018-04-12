package com.gpg.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gpg.amazon.entity.News;
import com.gpg.amazon.entity.PageModel;
import com.gpg.amazon.entity.Product;
import com.gpg.amazon.entity.ProductCategory;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.impl.NewsServiceImpl;
import com.gpg.amazon.service.impl.ProductCategoryServiceImpl;
import com.gpg.amazon.service.impl.ProductServiceImpl;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsServiceImpl newsService = Factory.getInstance("newsService", NewsServiceImpl.class);
	ProductServiceImpl productService = Factory.getInstance("productService", ProductServiceImpl.class);
	ProductCategoryServiceImpl productCategoryService = Factory.getInstance("ProductCategoryService",
			ProductCategoryServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize = 12;
		String page = req.getParameter("page");
		if (page == null) {
			page = "0";
		}
		int currentPage = Integer.parseInt(page);
		if (currentPage == 0) {
			currentPage = 1;
		}
		List<Product> hotProduct = productService.getHotProduct();
		List<News> newsList = newsService.queryAllNews();
		PageModel<Product> pageModel = productService.getAllProduct(currentPage, pageSize);
		List<ProductCategory> category = productCategoryService.queryProductCategory();
		req.setAttribute("category", category);
		req.setAttribute("pageModel", pageModel);
		req.setAttribute("newsList", newsList);
		req.setAttribute("hotProduct", hotProduct);
		req.setAttribute("servletPath", req.getServletPath());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}