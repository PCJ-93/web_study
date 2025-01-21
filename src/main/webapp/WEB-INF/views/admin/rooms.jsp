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
	<h2>rooms 객실 목록</h2>
	<p>${roomList}</p>
	
	<c:forEach var="roomList" items="${roomList}">
		<hr>
		<p>가 : ${roomList.roomId}</p>
		<hr>
		<p>나 : ${roomList.buildingNumber}</p>
		<hr>
		<p>다 : ${roomList.roomNumber}</p>
		<hr>
		<p>라 : ${roomList.floor}</p>
		<hr>
		<p>마 : ${roomList.maxGuestCount}</p>
		<hr>
		<c:choose>
			<c:when test="${roomList.viewType == 'OCN'}">바 : 오션뷰</c:when>
			<c:when test="${roomList.viewType == 'CTY'}">바 : 시티뷰</c:when>
			<c:when test="${roomList.viewType == 'MOT'}">바 : 마운틴뷰</c:when>
		</c:choose>
	</c:forEach>



</body>
</html>