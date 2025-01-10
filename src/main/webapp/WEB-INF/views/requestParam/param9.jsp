<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>param9</h1>
	<div>
<!-- 		<form method = "post"> 해도 댐 -->
		<form action="" method = "post"> <!-- action에 공백으로두면 현재경로로자동적용 여기선(/param9) -->
			
			id : <input type="text" name="id"><br/>
			name : <input type="text" name="name"><br/>
			price : <input type="text" name="price"><br/>
			<button type="submit">전송</button>
			
		</form>
	</div>
</body>
</html>