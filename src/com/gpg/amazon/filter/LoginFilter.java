package com.gpg.amazon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gpg.amazon.entity.User;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) paramServletRequest;
		HttpServletResponse response = (HttpServletResponse) paramServletResponse;
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			User user = (User) session.getAttribute("user");
			if (user != null) {
				paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
			} else {
				request.setAttribute("path", request.getServletPath());
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void destroy() {
	}

}
