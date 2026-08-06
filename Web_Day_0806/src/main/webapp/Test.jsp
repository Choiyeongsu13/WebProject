<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 1~10까지 합계 출력 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 width= 100>
		<tr>
			<td>	번호</td><td>	합계</td>
		</tr>
		<% 
		int tot=0;
		for(int i =1; i<=10; i++){
			tot+=i;
		%>
		<tr>
			<td>	<%=i%></td><td><%= tot %></td>
		</tr>
		<%} %>
	</table>
	

</body>
</html>