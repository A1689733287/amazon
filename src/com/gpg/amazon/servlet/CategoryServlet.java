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

public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductCategoryServiceImpl productCategoryService = Factory.getInstance("ProductCategoryService",
			ProductCategoryServiceImpl.class);
	NewsServiceImpl newsService = Factory.getInstance("newsService", NewsServiceImpl.class);
	ProductServiceImpl productService = Factory.getInstance("productService", ProductServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		int pageSize = 12;
		String page = req.getParameter("page");
		if (page == null) {
			page = "0";
		}
		int currentPage = Integer.parseInt(page);
		if (currentPage == 0) {
			currentPage = 1;
		}
		List<ProductCategory> category = productCategoryService.queryProductCategory();
		req.setAttribute("category", category);
		List<Product> hotProduct = productService.getHotProduct();
		List<News> newsList = newsService.queryAllNews();
		req.setAttribute("newsList", newsList);
		req.setAttribute("hotProduct", hotProduct);
		if ("parent".equals(cate)) {
			String cid = req.getParameter("c_id");
			PageModel<Product> pageModel = productCategoryService.queryProductByc_id(Integer.parseInt(cid), currentPage,
					pageSize);
			req.setAttribute("pageModel", pageModel);
			req.setAttribute("cid", cid);

		}
		if ("child".equals(cate)) {
			String c_child_id = req.getParameter("c_child_id");
			PageModel<Product> pageModel = productCategoryService.queryProductBycParentId(Integer.parseInt(c_child_id),
					currentPage, pageSize);
			req.setAttribute("pageModel", pageModel);
			req.setAttribute("c_child_id", c_child_id);
		}
		req.setAttribute("cate", cate);
		req.setAttribute("servletPath", req.getServletPath());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}