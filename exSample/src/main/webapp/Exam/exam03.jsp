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

 점수 :${score}<br>

 
 <c:if test="${score>=80}">
 	합격
 </c:if>
 
 <c:if test="${!(score>=80)}">
 	불합격
 </c:if>
 
 <c:if test="${score<90 && score>=80}">우</c:if>
 <c:if test="${score<80 and score>=70}">미</c:if>
 <c:if test="${score<70 and score>=60}">양</c:if>
 <c:if test="${score<60}">가</c:if>
 <br>
 
 <c:choose>
 	<c:when test="${score>=90 }">수</c:when>
 	<c:when test="${score>=80 }">무</c:when>
 	<c:when test="${score>=70 }">상</c:when>
 	<c:when test="${score>=60 }">부</c:when>
 	<c:otherwise>가</c:otherwise>
 </c:choose>
 <br>
 
 <c:if test="${a=='A'}">ok</c:if>
 </body>
</html>