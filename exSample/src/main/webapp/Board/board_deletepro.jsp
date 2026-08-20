<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<c:if test="${row==1}">
	<script>
	//opener.location.href="/board?cmd=boardList"; //객체
	//새로운 페이지 이동
	
	
	//기존 페이지를 새로운 페이지로 변경 (뒤로가기가안됌)
		opener.location.href="/Board?cmd=board_list"; //메소드
		self.close();
	</script>
</c:if>

<c:if test="${row==0 }">
	<script>
		alert("비밀번호가 맞지않습니다");
		history.back();
	</script>
</c:if>