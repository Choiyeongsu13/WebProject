<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	공통 헤더 — 여백 디자인

	사용법 : 각 화면 맨 위에서 lang.jsp 를 먼저 넣고, 값을 정한 뒤 이 파일을 넣습니다.

		<%@ include file="/common/lang.jsp" %>
		<c:set var="active"    value="home" />
		<c:set var="pageTitle"><fmt:message key="title.home" /></c:set>
		<c:set var="vLabel"    value="ポートフォリオ" />
		<%@ include file="/common/header.jsp" %>

	active : home | works | journal | travel | about
	vLabel : 오른쪽에 세로로 들어가는 일본어 라벨. 비우면 표시하지 않습니다.
--%>
<!DOCTYPE html>
<html lang="<fmt:message key="html.lang" />">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${pageTitle} | 최영수</title>

<meta name="description" content="컴퓨터공학 전공생 최영수의 포트폴리오 블로그. 대학 과제와 사이드 프로젝트, 여행 기록을 정리합니다.">
<meta property="og:title" content="${pageTitle} | 최영수">
<meta property="og:type" content="website">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@300;400;500&family=Noto+Sans+KR:wght@200;300;400;500&family=Noto+Serif+JP:wght@200;300;400&family=Noto+Serif+KR:wght@200;300;400&family=Zen+Kaku+Gothic+New:wght@300;400;500&display=swap">
<link rel="stylesheet" href="${ctx}/css/style.css">
</head>
<body>

<div style="position:relative;">

<c:if test="${not empty vLabel}">
	<span class="vlabel">${vLabel}</span>
</c:if>

<header class="site-header">

	<a class="brand" href="${ctx}/Home?cmd=home">CHOI&nbsp;&nbsp;YEONGSU</a>

	<nav class="nav">
		<a class="label ${active eq 'home'    ? 'is-active label-on' : ''}" href="${ctx}/Home?cmd=home"><fmt:message key="nav.home" /></a>
		<a class="label ${active eq 'works'   ? 'is-active label-on' : ''}" href="${ctx}/Work?cmd=work_list"><fmt:message key="nav.works" /></a>
		<a class="label ${active eq 'journal' ? 'is-active label-on' : ''}" href="${ctx}/Journal?cmd=journal_list"><fmt:message key="nav.journal" /></a>
		<a class="label ${active eq 'travel'  ? 'is-active label-on' : ''}" href="${ctx}/Travel?cmd=travel_list"><fmt:message key="nav.travel" /></a>
		<a class="label ${active eq 'about'   ? 'is-active label-on' : ''}" href="${ctx}/Home?cmd=about"><fmt:message key="nav.about" /></a>
	</nav>

	<div class="lang">
<%--
	로그인한 상태에서만 글쓰기 버튼이 보입니다.

	버튼을 숨기는 것만으로는 못 막습니다. 주소를 직접 치면 들어옵니다.
	실제 차단은 AdminController 가 합니다. 여기는 보이고 안 보이고만 정합니다.
--%>
<c:if test="${not empty sessionScope.loginUser}">
		<a class="label label-on header-write" href="${ctx}/Admin?cmd=admin_write"><fmt:message key="admin.write" /></a>
		<span class="lang-sep"></span>
</c:if>
<%--
	언어 버튼.

	lang 을 주소 맨 앞에 붙입니다. 원래 주소에 lang 이 이미 들어 있어도
	request.getParameter 는 먼저 나온 값을 돌려주므로 새로 누른 쪽이 이깁니다.
--%>
		<a class="label ${isJa ? '' : 'label-on'}"
		   href="${selfUri}?lang=ko<c:if test="${not empty selfQs}">&amp;${selfQs}</c:if>">KO</a>
		<span class="lang-sep"></span>
		<a class="label ${isJa ? 'label-on' : ''}"
		   href="${selfUri}?lang=ja<c:if test="${not empty selfQs}">&amp;${selfQs}</c:if>">JP</a>
	</div>

</header>
