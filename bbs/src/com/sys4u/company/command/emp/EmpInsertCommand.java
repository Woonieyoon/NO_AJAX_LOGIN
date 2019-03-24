package com.sys4u.company.command.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sys4u.company.command.AbstractCommand;
import com.sys4u.company.command.Constants;
import com.sys4u.company.dao.EmpDAO;
import com.sys4u.company.dto.Employee;
import com.sys4u.company.exception.CommandExecutionException;

public class EmpInsertCommand extends AbstractCommand{

	
	private static final String REDIRECT_URL ="/bbs/emplist.do";
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		EmpDAO empDAO = new EmpDAO(conn);
		Employee employee = new Employee();
		employee.setEmpno(Integer.parseInt(req.getParameter("emp_no")));
		employee.setEname(req.getParameter("emp_name"));
		employee.setJob(req.getParameter("emp_job"));
		employee.setMgr(Integer.parseInt(req.getParameter("emp_mgr")));
		employee.setHiredate(java.sql.Date.valueOf(req.getParameter("emp_hiredate").toString()));
		employee.setSal(Integer.parseInt(req.getParameter("emp_sal")));
		employee.setComm(Integer.parseInt(req.getParameter("emp_comm")));
		employee.setDeptno(Integer.parseInt(req.getParameter("emp_deptno")));

		int result = empDAO.insert(employee);
		
		if (result > 0) {
			req.setAttribute("redirectUrl", REDIRECT_URL);
			req.setAttribute("message", "성공적으로 저장되었습니다.");
			return Constants.REDIRECT_VIEW;
		}

		throw new CommandExecutionException("Employee data[" + employee.getEname() + "] not inserted.");
	}

}
