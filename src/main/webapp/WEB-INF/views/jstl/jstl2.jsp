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
	<h1>JSTL2페이지</h1>
	
	<c:set var="var1" value="값들어가는곳"/> <!-- 변수선언이라고 생각하면 됨 ( 잘안씀 ) -->
	
	${var1}
	
	<a href="/jstl1">jstl1 페이지</a>
	
	<c:url var="jstl1Url" value="/jstl1"/>
	<a href="${jstl1Url}">jstl1 curl</a>
	
<%-- 	${msgXml} xml 이렇게 쓰면 인젝션공격당함 --%>
	<c:out value = "${msgXml}" escapeXml = "true"/> <!-- escapeXml : &lt; 같은거 <로 변환안시키고 문자그대로 사용할때 true -->
	&lt;&lt;&lt;&lt; &gt;&gt;&gt;&gt;
	${msg1 }
	${msg2 }
	<c:out value="${msg1 }" escapeXml="true"></c:out>
	<c:out value="${msg2 }" escapeXml="true"></c:out>
	
	
	
<%-- 	<c:redirect url = "/jstl1"/> 이거 잘 안씀 --%>
	<script>
// 		location.href = "/jstl1";
	</script>
</body>
</html>