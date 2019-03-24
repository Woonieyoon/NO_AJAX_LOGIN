package com.sys4u.company.command.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sys4u.company.command.AbstractCommand;
import com.sys4u.company.command.Constants;

public class EmpLogoutCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String redirectUrl = "/bbs/emplist.do";
		HttpSession session = req.getSession();
		session.removeAttribute("ID");
		session.removeAttribute("beforeUrl");
		session.invalidate();
		req.setAttribute("message", "로그아웃 되셨습니다.");
		req.setAttribute("redirectUrl", redirectUrl);
		return Constants.REDIRECT_VIEW;
	}

}
