<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!-- 반복문 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="a" begin="1" end="10" step="1">
	Hello ${a}<br>
	</c:forEach>
	---------<br>
	<c:forEach var="dto" items="${list }">
		이름 : ${dto }<br>
	</c:forEach>	
	<c:forEach var="dto" items="${list }" varStatus="var">
		이름 : ${var.index} / ${dto } / ${var.count }<br>
	</c:forEach>	


 </body>
</html>