package com.sys4u.company.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

public class Employee implements Serializable {
	private static final long serialVersionUID = 4647729179983452001L;
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	

	public static Employee create(HttpServletRequest req) {
		Employee employee = new Employee();
		employee.setEname(req.getParameter("ename"));
		employee.setJob(req.getParameter("job"));
		employee.setMgr(Integer.parseInt(req.getParameter("mgr")));
		employee.setHiredate(java.sql.Date.valueOf(req.getParameter("hiredate")));
		employee.setSal(Integer.parseInt(req.getParameter("sal")));
		employee.setComm(Integer.parseInt(req.getParameter("comm")));
		employee.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		
		return employee;
	}
	

}
