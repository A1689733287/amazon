package com.gpg.amazon.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gpg.amazon.entity.User;
import com.gpg.amazon.factory.Factory;
import com.gpg.amazon.service.impl.UserServiceImpl;
import com.gpg.amazon.util.ImageUtil;
import com.gpg.amazon.util.MD5Util;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userService = Factory.getInstance("userService", UserServiceImpl.class);

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/login".equals(path)) {
			loginAction(req, resp);
		}
		if ("/register".equals(path)) {
			register(req, resp);
		}
		if ("/imageCode".equals(path)) {
			imageCode(req, resp);
		}
		if ("/checkCode".equals(path)) {
			checkCode(req, resp);
		}
		if ("/checkEmail".equals(path)) {
			checkEmail(req, resp);
		}
		if ("/checkUserName".equals(path)) {
			checkUserName(req, resp);
		}
		if ("/userInfo".equals(path)) {
			userInfo(req, resp);
		}
		if ("/userExit".equals(path)) {
			HttpSession session = req.getSession(false);
			session.invalidate();
			resp.sendRedirect("index");
		}
	}

	/**
	 * 用户信息
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void userInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		userService.getUserById(Integer.parseInt(uid));
	}

	/**
	 * 查询用户名是否存在
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		boolean userByUserName = userService.getUserByUserName(username);
		if (userByUserName) {
			resp.getWriter().write("1");
		} else {
			resp.getWriter().write("2");
		}
	}

	/**
	 * 查询邮箱是否存在
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		if (userService.getUserByEmail(email)) {
			resp.getWriter().write("1");
		} else {
			resp.getWriter().write("2");
		}
	}

	/**
	 * 判断验证码是否正确
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void checkCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String code = req.getParameter("code");
		if (session != null && session.getAttribute("validateCode") != null) {
			String validateCode = (String) session.getAttribute("validateCode");
			if (code.equals(validateCode)) {
				resp.getWriter().write("1");
			} else {
				resp.getWriter().write("2");
			}

		}
	}

	/**
	 * 生成验证码
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void imageCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		Map<String, BufferedImage> map = ImageUtil.getCode();
		Iterator<String> iterator = map.keySet().iterator();
		String code = null;
		while (iterator.hasNext()) {
			code = iterator.next();
		}
		session.setAttribute("validateCode", code);
		resp.setContentType("image/jpeg");
		BufferedImage bufferedImage = map.get(code);
		OutputStream toClient = resp.getOutputStream(); // 图片数据要通过2进制流方式传送
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(toClient); // 具体图片格式编码转换器
		encoder.encode(bufferedImage); // 转换并输出到客户端
	}

	/**
	 * 用户注册
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userName");
		String userpwd = req.getParameter("passWord");
		String sex = req.getParameter("sex");
		String birthday = req.getParameter("birthday");
		String identity = req.getParameter("identity");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		User user = new User(username, MD5Util.encoder(userpwd), sex, birthday, identity, email, mobile, address, 1);
		System.out.println(user);
		if (userService.registerUser(user)) {
			resp.sendRedirect("reg-result.jsp");
		} else {
			resp.getWriter().write("<script type='text/javascript'>alert('注册失败')</script>");
			resp.setHeader("refresh", "1;url=register.jsp");
		}
	}

	/**
	 * 用户登录
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loginAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("passWord");
		// String page = req.getParameter("page");
		User user = new User(0, userName, userPwd, null, null, null, null, null, null, 0);
		User u = userService.Login(user);
		if (u != null) {
			session.setAttribute("user", u);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			resp.addCookie(cookie);
			resp.sendRedirect("index");
		} else {
			resp.getWriter().write("<script type='text/javascript'> alert('登录失败');</script>");
			resp.setHeader("refresh", "1;url=login.jsp");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}