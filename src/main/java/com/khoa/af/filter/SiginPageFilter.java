package com.khoa.af.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khoa.af.api.admin.User;

@WebFilter(filterName = "LoginPageFilter", urlPatterns = "/admin/*")
public class SiginPageFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// prevent back-button login
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidation");
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Expires", "0");
		
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			res.sendRedirect(req.getContextPath() + "/signin");
		} else {			
			chain.doFilter(request, response);
		}
		
		
	}

}
