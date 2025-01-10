<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>viewData1 페이지</h1>
	
<%-- <%=request.getAttribute("state") %> <!-- 이거잘안쓰고 아래의 ${}를 자주 쓴다 --> --%>
	<%= request.getAttribute("time") %>
	
	<p>${state}</p>
	<div>
	<p>${time}</p>
	<span>${state}</span>
	</div>
</body>
</html>