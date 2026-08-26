<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<c:if test="${row==1}">
	<script>
		location.href="/BoardPhoto?cmd=board_list";
	</script>
</c:if>

<c:if test="${row==0 }">
	<script>
		alert("비밀번호가 맞지않습니다");
		history.back();
	</script>
</c:if>