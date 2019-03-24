<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
     
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/bbs/static-root/css/style.css" rel="stylesheet">
<title>Insert title here</title>

</head>
<body>

	<%
		if(session.getAttribute("ID") ==null){
    %>	
    
    <div class="header">
    	<div id = "header_beforelogin" >
			<button id="btn_Login">로그인</button>
		</div>
		
		<div id = "header_afterlogin" style="display:none;">
			<label id="label_user"><%=session.getAttribute("ID")%>님 로그인 되었습니다.</label>
			<button id="btn_Logout">로그아웃</button>
		</div>
	</div>
    <%
    	}else{
	%>
	<div class="header">
		<div id = "header_beforelogin" style="display:none;">
			<button id="btn_Login">로그인</button>
		</div>
		
		<div id = "header_afterlogin">
			<label id="label_user"><%=session.getAttribute("ID")%>님 환영합니다</label>
			<button id="btn_Logout">로그아웃</button>
		</div>
	</div>
	<%
    	}
	%>
	<script>
		document.getElementById('btn_Login').onclick = function(){
			location.href = "<%=request.getContextPath()%>/loginpage.do";
		}
		
		document.getElementById('btn_Logout').onclick = function(){
			location.href = "<%=request.getContextPath()%>/logout.do";
		}
	</script>

</body>
</html>