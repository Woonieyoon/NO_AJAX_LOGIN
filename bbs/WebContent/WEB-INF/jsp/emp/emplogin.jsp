<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <form action="<%=request.getContextPath()%>/login.do" method="post">
            <label>ID: </label>
            <input name="id" type="text"><br>
            <label>PW: </label>
            <input name="pw" type="password"><br>
            <input type="submit" value="로그인">
            <input type="button" value="취소" onclick="javascript:history.back();">
        </form>
		
</body>
</html>