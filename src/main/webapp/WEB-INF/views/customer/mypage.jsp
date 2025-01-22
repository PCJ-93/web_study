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
	<h1>마이페이지</h1>

	<p>아이디 : ${user.id}</p>
	<p>이름 : ${user.name}</p>
	<p>
		<a href = "/main">메인화면으로</a>
	</p>

</body>
</html>