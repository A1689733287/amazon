package com.gpg.amazon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain paramFilterChain) throws IOException, ServletException {
		paramServletRequest.setCharacterEncoding("utf-8");
		paramServletResponse.setContentType("text/html;charset=utf-8");
		paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
	}

	@Override
	public void destroy() {
	}

}
