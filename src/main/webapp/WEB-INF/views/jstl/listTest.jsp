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
	<h1>LIST TEST</h1>

	<c:choose>
		<c:when test="${type=='str'}">
			<c:forEach var="i" begin="1" end="10" step="1">
				<p>스트링 리스트입니다</p>
			</c:forEach>
		</c:when>
		<c:when test="${type=='member'}">
			<c:forEach var="member" items="${memberList}">
				<div class="itemBox">
					<p>${member.id} ${member.pw} ${member.name}</p>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>정체불명입니다</p>
		</c:otherwise>
	</c:choose>


</body>
</html>