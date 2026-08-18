<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	변수 선언 : <c:set var="변수명" value="값" />
	변수 값 출력 : <c:out value="" />
 -->
 
 <c:set var="i" value="음"/>
 <c:set var="a" value="12"/>
 
 <c:out value= "i" /> <br>
 <c:out value= "${i}" /> <br>
 <c:out value= "a" /> <br>
 <c:out value= "${a}" /> <br>
 출력 ${a} <br>
 
 출력 ${"마나"} <br>
 
 </body>
</html>