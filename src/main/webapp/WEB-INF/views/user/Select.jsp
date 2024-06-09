<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DB.DBTable" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사용자 정보</title>
<link rel="icon" href="../../img/logo.png" type="image/x-icon">
<!-- <link href="../../lib/bootstrap@5.2.3/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
	DBTable user = (DBTable)request.getAttribute("user_data");
%>
	<div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 정보</h1>
		<form name="frm" method="post">
		<input type="hidden" name="number" value=<%=user.getNo()%>>
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">이름:</label>
		    <input type="text" class="form-control" id="name" placeholder="<%=user.getName()%>" name="name" readonly="readonly">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="email" class="form-label">이메일:</label>
		    <input type="email" class="form-control" id="email" placeholder="<%=user.getEmail()%>" name="email" readonly="readonly">
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">비밀번호:</label>
		    <input type="password" class="form-control" id="pwd" placeholder="*******" name="pwd" readonly="readonly">
		  </div>
			<div class="d-flex">
			<%
				if(user.getGen()==1){
			%>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio1" name="gender" value="1" checked>남성
					<label class="form-check-label" for="radio1"></label>
				</div>
			  </div>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio2" name="gender" value="2">여성
					<label class="form-check-label" for="radio2"></label>
				</div>
			  </div>
			<%
				}else{
			%>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio1" name="gender" value="1">남성
					<label class="form-check-label" for="radio1"></label>
				</div>
			  </div>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio2" name="gender" value="2" checked>여성
					<label class="form-check-label" for="radio2"></label>
				</div>
			  </div>
			<%
				}
			%>
			</div>
		<div class="d-flex">
		  <div class="p-2 flex-fill d-grid">
		  	<button type="submit" class="btn btn-primary" onclick="javascript: frm.action = 'Update'">수정</button>
		  </div>
		  <div class="p-2 flex-fill d-grid">
			<button type="submit" class="btn btn-primary" onclick="javascript: frm.action = 'DeleteData'">삭제</button>
		  </div>
		  <div class="p-2 flex-fill d-grid">
			<a href="ListPage" class="btn btn-primary">취소</a>
		  </div>
		</div>
		</form>
	</div>
</body>
</html>