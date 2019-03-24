
package com.sys4u.company.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sys4u.company.command.Constants;

public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("AuthFilter Start");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		System.out.println("이전 URI:" + req.getRequestURI());
		System.out.println("이전 Query:" + req.getQueryString());
		String beforeUrl = req.getRequestURI();

		if (req.getQueryString() != null) {
			beforeUrl = beforeUrl + "?" + req.getQueryString();
		}
		if (session.getAttribute("ID") == null) {
			req.setAttribute("redirectUrl", "/bbs/loginpage.do");
			req.setAttribute("message", "로그인해주세요");
			session.setAttribute("beforeUrl", beforeUrl);
			req.getRequestDispatcher(Constants.REDIRECT_VIEW).forward(request, response);
		} else {
			chain.doFilter(request, response);
			System.out.println("Filter 응답:" + req.getRequestURI());
		}
	}
}