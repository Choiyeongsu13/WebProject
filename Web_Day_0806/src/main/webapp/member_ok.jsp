<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String tel = tel1 + "-" + tel2 + "-" + tel3;
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String email = email1 + "@" + email2;
	 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width =300>
		<tr>
			<td>이름</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%= id %></td>
		</tr>
		<tr>
			<td>비번</td>
			<td><%= pwd %></td>
		</tr>
		<tr>
			<td>전화</td>
			<td><%= tel %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= email %></td>
		</tr>
	</table>
	
	

</body>
</html>