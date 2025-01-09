<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>homhomehome</h1>
	
	<p><a href="/board/faq">FAQ로이동</a></p> <!-- http://Localhost:8080/board/faq 써도 되긴하는데 앞에 안붙여야 현재경로에서 이동이된다 포트번호 바뀌어도 상관없게 -->
	<p><a href="/board/notice">공지사항으로이동</a></p>
	<p><a href="/member/signup">회원가입으로이동</a></p>
	<div>
		<button onclick = "location.href = '/member/signup'">회원가입</button>
		<button id = "btn_faq">FAQ확인</button>
	</div>
	
	<div>
		<form action ="/board/notice" method="get">
			<input type = "text">
			<input type = "submit" value="공지사항확인">
		</form>
	</div>
	
	<script>
	document.getElementById("btn_faq").addEventListener('click', ()=>{
		location.href = "/board/faq";
	})
	</script>
</body>
</html>