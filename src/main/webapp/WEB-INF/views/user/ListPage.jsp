<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DB.DBTable" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
<link rel="icon" href="../../img/logo.png" type="image/x-icon">
<!-- <link href="../../lib/bootstrap@5.2.3/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
	.cursor-pointer {cursor: pointer;}
</style>
</head>
<body>
<%
	List<DBTable> list = (List<DBTable>)request.getAttribute("data_list");	
%>
	<div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 목록</h1>
	  <div class="btn-group">
	    <a href="Create" class="btn btn-primary">사용자 추가</a>
	  </div>
	  <table class="table table-hover mt-3">
	    <thead class="table-dark">
	      <tr>
	      	<th>이름</th>
	        <th>이메일</th>
	        <th>가입날짜</th>
	      </tr>
	    </thead>
	    <tbody>
	    <%
	    	for(DBTable data : list){
	    %>
	      <tr class="cursor-pointer" onclick="location.href = 'Select';">
	        <td><%=data.getName()%></td>
	        <td><%=data.getEmail() %></td>
	        <td><%=data.getDate() %></td>
	      </tr>
       <%
	    	}
       %>
	    </tbody>
	  </table>
	</div>
</body>
</html>