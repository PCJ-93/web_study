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
	<h1>관리자 페이지</h1>
	<h3>사용자 정보 수정</h3>

	<form action="" method="post">
		<h3>유저 아이디 : ${user.id}</h3>
		<label>비밀번호 변경 : <input type="password" name="pw" value="${user.pw}"></label><br> <label>이름 변경 : <input
			type="text" name="name" value="${user.name}"></label><br>
		
		<p>사용자 타입 선택<p>
		<select name="userType">
			<option value="ADM" <c:if test="${user.userType =='ADM'}">selected</c:if>>관리자</option>
			<option value="CUS" <c:if test="${user.userType =='CUS'}">selected</c:if>>고객</option>
		</select>
		<br>
		<button type="submit">수정하기</button>
		
	</form>
</body>
</html>