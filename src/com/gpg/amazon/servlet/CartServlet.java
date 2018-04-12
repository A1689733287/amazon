package com.gpg.amazon.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gpg.amazon.entity.Cart;
import com.gpg.amazon.entity.User;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.impl.CartServiceImpl;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartServiceImpl cartService = Factory.getInstance("cartService", CartServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/car".equals(path)) {
			// 购物车
			cartAction(req, resp);
		}
		if ("/addToCart".equals(path)) {
			// 添加到购物车
			addCart(req, resp);
		}
		if ("/goingToBuy".equals(path)) {
			// 去计算商品页面
			goingToBuy(req, resp);
		}
		if ("/carDelete".equals(path)) {
			// 删除购物车
			carDelete(req, resp);
		}
		if ("/alterCart".equals(path)) {
			// 修改购物车记录
			alterCart(req, resp);
		}
	}

	private void alterCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		String count = req.getParameter("count");
		int alterCartCount = cartService.alterCartCount(Long.parseLong(count), Long.parseLong(cid));
		resp.getWriter().write("" + alterCartCount);
	}

	private void carDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		cartService.deleteCart(Integer.parseInt(cid));
		resp.sendRedirect("car");
	}

	private void goingToBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		String pid = req.getParameter("pid");
		String count = req.getParameter("count");
		Cart cart = new Cart(Long.parseLong(pid), Long.parseLong(count), user.getUid());
		cartService.insertCart(cart);
		resp.sendRedirect("car");
	}

	private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		String pid = req.getParameter("pid");
		String count = req.getParameter("count");
		Cart cart = new Cart(Long.parseLong(pid), Long.parseLong(count), user.getUid());
		int insertCart = cartService.insertCart(cart);
		if (insertCart > 0) {
			resp.getWriter().write("1");
		} else {
			resp.getWriter().write("0");
		}
	}

	private void cartAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		List<Cart> carts = cartService.queryCartByUid(user.getUid());
		req.setAttribute("carts", carts);
		req.getRequestDispatcher("shopping.jsp").forward(req, resp);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}