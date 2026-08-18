<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	 int a=10;
    String name="김학생";
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 점수 : ${a} <br>
 점수 : ${a>=5} <br>
 점수 : ${!(a>=5)} <br>
 점수 : ${a+5} <br>
 점수 : ${a>5 ? "ㄷ":"ㅈ"} <br>
 이름 : ${name+a} <br>
</body>
</html>