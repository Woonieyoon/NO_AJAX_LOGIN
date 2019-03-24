package com.sys4u.company.pagecommand.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys4u.company.command.AbstractCommand;

public class EmpLoginPageCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String viewPageName;
		viewPageName = "/WEB-INF/jsp/emp/emplogin.jsp";
		return viewPageName;
	}

}
