package com.gpg.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gpg.amazon.entity.Comment;
import com.gpg.amazon.entity.ProductCategory;
import com.gpg.amazon.entity.User;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.impl.CommentServiceImpl;
import com.gpg.amazon.service.impl.ProductCategoryServiceImpl;
import com.gpg.amazon.util.DateUtil;

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentServiceImpl commentService = Factory.getInstance("commentService", CommentServiceImpl.class);
	ProductCategoryServiceImpl productCategoryService = Factory.getInstance("ProductCategoryService",
			ProductCategoryServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/commentAll".equals(path)) {
			commentAll(req, resp);
		}
		if ("/addComment".equals(path)) {
			addComment(req, resp);
		}
	}

	private void addComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		String content = req.getParameter("guestContent");
		Comment comment = new Comment(null, content, DateUtil.getStringDate(), null, user.getUname(), null);
		System.out.println(comment);
		commentService.addComment(comment);
		req.getRequestDispatcher("/commentAll").forward(req, resp);
	}

	private void commentAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Comment> commentList = commentService.queryAllComment();
		List<ProductCategory> category = productCategoryService.queryProductCategory();
		req.setAttribute("category", category);
		req.setAttribute("comments", commentList);
		req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}