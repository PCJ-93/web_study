<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>COUNT 페이지</h1>
	
	<c:if test="${userId == null }">
		<h1>접속한 사용자가 없습니다</h1>
		<h2>접속 횟수 : 0</h2>
	</c:if>

	<c:if test="${userId != null}">
		<p>${userId} 님 접속함</p>
		<p>접속횟수 : ${count}</p>
	</c:if>


</body>
</html>