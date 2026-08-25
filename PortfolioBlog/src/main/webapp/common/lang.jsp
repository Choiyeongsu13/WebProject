<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	언어 결정 (한국어 / 일본어)

	사용법 : 각 화면 맨 위에서 이 파일을 먼저 넣습니다.
		<%@ include file="/common/lang.jsp" %>

	동작
	  1. 주소에 ?lang=ja 가 붙어 오면 세션에 기억한다.
	  2. 기억된 값이 없으면 ko 로 본다.
	  3. 그 언어의 message_XX.properties 를 붙인다.

	글자 꺼내 쓰기
		<fmt:message key="nav.home" />

	글자를 고치거나 추가할 때는 src/main/java 아래
	message_ko.properties 와 message_ja.properties 를 같이 손보세요.
--%>

<%-- 언어를 바꾸겠다고 눌렀을 때만 세션에 저장합니다 --%>
<c:if test="${param.lang eq 'ko' or param.lang eq 'ja'}">
	<c:set var="lang" scope="session" value="${param.lang}" />
</c:if>

<%-- 처음 온 사람은 한국어 --%>
<c:if test="${sessionScope.lang ne 'ko' and sessionScope.lang ne 'ja'}">
	<c:set var="lang" scope="session" value="ko" />
</c:if>

<%-- 화면에서 자주 쓰는 값들을 미리 만들어 둡니다 --%>
<c:set var="lang" value="${sessionScope.lang}" />
<c:set var="isJa" value="${lang eq 'ja'}" />
<c:set var="ctx"  value="${pageContext.request.contextPath}" />

<%--
	언어 전환 버튼이 "지금 보고 있는 화면" 으로 돌아오게 하기 위한 주소입니다.
	pageContext.request.requestURI 에는 컨텍스트 경로(/PortfolioBlog)가 이미 들어 있으니
	앞에 ${ctx} 를 또 붙이면 안 됩니다.
--%>
<c:set var="selfUri" value="${pageContext.request.requestURI}" />

<%--
	fmt:setLocale 은 ko / ja 같은 언어 코드를 받습니다.
	fmt:setBundle 의 basename 은 파일 이름에서 _ko, _ja 와 확장자를 뺀 부분입니다.
	message_ko.properties -> basename 은 message
--%>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="message" />
