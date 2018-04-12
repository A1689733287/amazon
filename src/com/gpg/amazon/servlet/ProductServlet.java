package com.gpg.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductServiceImpl productService = Factory.getInstance("productService", ProductServiceImpl.class);
	NewsServiceImpl newsService = Factory.getInstance("newsService", NewsServiceImpl.class);
	ProductCategoryServiceImpl productCategoryService = Factory.getInstance("ProductCategoryService",
			ProductCategoryServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/allProduct".equals(path)) {
			allProduct(req, resp);
		}
		if ("/productDetail".equals(path)) {
			productDetail(req, resp);
		}
	}

	private void productDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		Product product = productService.queryProductByPid(Integer.parseInt(pid));
		List<ProductCategory> category = productCategoryService.queryProductCategory();
		ProductCategory ParentCid = productCategoryService.getPCateByCid(product.getP_cate_id());
		ProductCategory childId = productCategoryService.getPCateByCChildId(product.getP_cate_child_id());
		req.setAttribute("category", category);
		req.setAttribute("product", product);
		req.setAttribute("ParentCid", ParentCid);
		req.setAttribute("childId", childId);
		Cookie cookie = new Cookie("pid", pid);
		cookie.setMaxAge(3600 * 24);
		req.getRequestDispatcher("product_view.jsp").forward(req, resp);

	}

	private void allProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize = 12;
		String page = req.getParameter("page");
		if (page == null) {
			page = "0";
		}
		int currentPage = Integer.parseInt(page);
		if (currentPage == 0) {
			currentPage = 1;
		}
		List<News> newsList = newsService.queryAllNews();
		List<Product> hotProduct = productService.getHotProduct();
		PageModel<Product> pageModel = productService.getAllProduct(currentPage, pageSize);
		List<ProductCategory> category = productCategoryService.queryProductCategory();
		req.setAttribute("category", category);
		req.setAttribute("pageModel", pageModel);
		req.setAttribute("newsList", newsList);
		req.setAttribute("hotProduct", hotProduct);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}