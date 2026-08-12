<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록 결과</title>
</head>
<body>
<c:if test="${row == 1}">
	<h1> 성공 메시지</h1>
	<h3><a href="/">홈으로</a></h3>
</c:if>
<c:if test="${row != 1}">
	<h1> 실패 메시지</h1>
<h3><a href="javascript:history.back()">이전으로</a></h3>
</c:if>
</body>
</html>