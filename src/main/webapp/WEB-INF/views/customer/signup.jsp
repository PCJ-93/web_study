<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error-msg {
		color:red;
	}
</style>
</head>
<body>
	<h1>회원가입 페이지</h1>

	<form action="" method="post">
	
		아이디 : <input type="text" name="id" id="inputId" value="${user.id}"> <br>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pw')}">
				<p class = "error-msg">아이디 필수 입력!</p>
			</c:if>
		</spring:hasBindErrors>
		
		<button type="button" id="btn_checkDupId">중복체크</button>
		<span id="checkDupMsg"></span> <br> 
		
		비밀번호: <input type="password" name="pw"> <br>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pw')}">
				<p class = "error-msg">비밀번호는 8~12자리 입력!</p>
			</c:if>
		</spring:hasBindErrors>
		
		이름 : <input type="text" name="name" value="${user.name}">
		<br>
		<button type="submit">가입하기</button>
	</form>


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
		integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		let btn_checkDupId = document.getElementById('btn_checkDupId');
		let span_checkDupMsg = document.getElementById('checkDupMsg')
		
		btn_checkDupId.addEventListener('click', ()=>{
			//location.href = "/customer/checkDupId";
			
			let inputId = document.getElementById('inputId').value;
			console.log(inputId);
			
			let objData = {   // javascript Object 타입
					'id':inputId,
					'type':'CUS'
			};
			
			//javascript object -> json format text
			let jsonData = JSON.stringify(objData);
			
			//Obj -> JSON  JSON.stringify
			//JSON -> Obj  JSON.parse
			
			// 서버로 ajax 요청 아이디 중복 여부 확인
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupIdJson",
				headers:{
					"Content-Type":"application/json;"
				},
				data: jsonData,
				dataType: 'json',
				success: function(result){
					console.log("ajax success");
					console.log(result);
					
					if(result.header.resultCode=='10'){
						if(result.body == 'Y'){
							span_checkDupMsg.textContent =  '중복된 아이디입니다.';
						}else{
							span_checkDupMsg.textContent =  '사용 가능한 아이디입니다.';
						}
					} else {
						console.log('정상 응답을 받지 못함');
					}
					
					
				},
				error: function(error){
					console.log(error);
				}
			});
			
			/*  //단일 id 전송, 단일 text 수신
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupId",
				headers:{
					"Content-Type":"application/json;"
				},
				data: inputId,
				success: function(result){
					console.log("ajax success");
					console.log(result);
					
					if(result == 'Y'){
						span_checkDupMsg.textContent =  '중복된 아이디입니다.';
					}else{
						span_checkDupMsg.textContent =  '사용 가능한 아이디입니다.';
					}
				},
				error: function(error){
					console.log(error);
				}
			});
			*/
			
		});
	</script>
</body>
</html>