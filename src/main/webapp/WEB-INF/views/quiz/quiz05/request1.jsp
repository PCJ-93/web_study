<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request1</h1>
	${response001}
	${response099}
	<h1>request2</h1>
	${responseItem.response001}
	${responseItem.response099}
</body>
</html>