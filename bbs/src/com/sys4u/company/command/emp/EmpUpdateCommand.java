package com.sys4u.company.command.emp;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys4u.company.command.AbstractCommand;
import com.sys4u.company.command.Constants;
import com.sys4u.company.dao.EmpDAO;
import com.sys4u.company.dto.Employee;
import com.sys4u.company.exception.CommandExecutionException;

public class EmpUpdateCommand extends AbstractCommand{

	private static final String REDIRECT_URL ="/bbs/emplist.do";	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp ) {
		EmpDAO empDao = new EmpDAO(conn);

		Employee employee = new Employee();
		employee.setEmpno(Integer.parseInt(req.getParameter("emp_no")));
		employee.setEname(req.getParameter("emp_name"));
		employee.setJob(req.getParameter("emp_job"));
		employee.setMgr(Integer.parseInt(req.getParameter("emp_mgr")));
		employee.setHiredate(java.sql.Date.valueOf(req.getParameter("emp_hiredate")));
		employee.setSal(Integer.parseInt(req.getParameter("emp_sal")));
		employee.setComm(Integer.parseInt(req.getParameter("emp_comm")));
		employee.setDeptno(Integer.parseInt(req.getParameter("emp_deptno")));
		
		int result = empDao.update(employee);
		System.out.println(result);
		if (result != 1) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				LOGGER.error("rollback failed.", e);
			}
			throw new CommandExecutionException("Updating Employee["+employee.getEmpno()+"] failed.");
		}

		req.setAttribute("redirectUrl", REDIRECT_URL);
		req.setAttribute("message", "성공적으로 저장되었습니다.");
		//return Constants.REDIRECT_VIEW;
		return "/emplist.do";
	}

}
