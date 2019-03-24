package com.sys4u.company.command.emp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sys4u.company.command.AbstractCommand;
import com.sys4u.company.command.Constants;
import com.sys4u.company.dao.EmpDAO;

public class EmpLoginCommand extends AbstractCommand{

	//왜 redirect만 될까?
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");
		int pwd = getIntParameter(req,"pw","1");
		LOGGER.debug("데이터:" + id +"," + pwd );
		
		boolean existUser = new EmpDAO(conn).existsUser(id, pwd);
		System.out.println("참:"+existUser);
		HttpSession session = req.getSession();
		
		if(existUser) {
			session.setAttribute("ID", id);
			String authUrl = (String)session.getAttribute("beforeUrl");
			String url = authUrl;
			if(url==null) {
				url = "/bbs/emplist.do";
			}
			req.setAttribute("redirectUrl", url);
			req.setAttribute("message", "로그인 되었습니다.");
			return Constants.REDIRECT_VIEW;
		}else {
			//forward??
			req.setAttribute("redirectUrl", "/bbs/loginpage.do");
			req.setAttribute("message", "없는 데이터 입니다.");
			//return "/WEB-INF/jsp/emp/emplogin.jsp";
			return Constants.REDIRECT_VIEW;
		}
	}
}
