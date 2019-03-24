<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ 
    page import= "java.util.List"
import="com.sys4u.company.dto.Employee"
import="com.sys4u.company.dto.Pagination"
%><%
	List<Employee> employees = (List<Employee>)request.getAttribute("employees");
	String beforeSearchKey = (String)request.getAttribute("beforeSearchKey");
	String searchKey = request.getParameter("searchKey") == null? "EMPNO":request.getParameter("searchKey");
	String searchValue = request.getParameter("searchValue") == null? "":request.getParameter("searchValue");
	String pageNum = request.getParameter("pageNum") == null? "1":request.getParameter("pageNum");
	int empCount = (Integer)request.getAttribute("empCount");
	

	
%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP Table List</title>
<script type="text/javascript" src="/bbs/static-root/js/common/page.js"></script>
</head>
<body>


	<jsp:include page="/WEB-INF/jsp/header/header.jsp" flush="false">
		<jsp:param value="emp" name="domain"/>
	</jsp:include>		
				

<input type="hidden" id="transportUrl" value="<%=request.getContextPath()%>/emplist.do">
	<h2>EMP Table</h2>
	<table border="1">
	
		<thread>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>입사일</td>		
			</tr>
		</thread>
		
			<%
			for(Employee employee : employees) {
		%>
		
		<tr>
			<td><%=employee.getEmpno()%></td>
			<td><a href="<%=request.getContextPath()%>/empdetail.do?empno=<%=employee.getEmpno()%>&searchKey=<%=searchKey%>&searchValue=<%=searchValue%>&pageNum=<%=pageNum%>"><%=employee.getEname()%></a>
			<td><%=employee.getDname()%></td>
			<td><%=employee.getHiredate()%></td>
		</tr>
		
		<%
			}
		%>
		
		<jsp:include page="/WEB-INF/jsp/common/dynamicpage.jsp" flush="false">
			<jsp:param value="emp" name="domain"/>
		</jsp:include>		
				
		<tr>
			<td colspan="3">
				<form action="<%=request.getContextPath()%>/emplist.do" method="get">
					<select name="searchKey">
						<option value="EMPNO" <%=searchKey.equals("EMPNO") ? "selected" : ""%>>사원번호</option>
						<option value="ENAME" <%=searchKey.equals("ENAME") ? "selected" : ""%>>사원명</option>
						<option value="DNAME" <%=searchKey.equals("DNAME") ? "selected" : ""%>>부서명</option>
					</select>
					<input type="text" name="searchValue" value=<%=searchValue%>>
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="1" align="left">
				<span>검색 Count: <%=empCount%></span>
			</td>
			<td colspan="2" align="right">
				<a href="<%=request.getContextPath()%>/auth/emppage.do?form=register">
					<Button>사원 등록</Button>
				</a>
			</td>
		</tr>	
	</table>

	<script>
		alert("<%=request.getRequestURL().toString()%>");
	</script>
	
</body>
</html>