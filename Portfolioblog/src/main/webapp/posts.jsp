<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="journal" />
<c:set var="pageTitle"><fmt:message key="title.journal" /></c:set>
<c:set var="vLabel"    value="記録" />
<%@ include file="/common/header.jsp" %>

<!-- ================= 페이지 제목 ================= -->
<div class="page-head">
	<span class="label"><fmt:message key="label.journal" /></span>
	<h1 class="page-title"><fmt:message key="title.journal" /></h1>
	<p class="page-lead"><fmt:message key="journal.lead" /></p>
</div>
<!-- ============== 필터 ================= -->
<div class="section sp-2">
	<div class="filters">
		<a class="filter ${empty cat ? 'is-active' : ''}"
		   href="${ctx}/Journal?cmd=journal_list"><fmt:message key="cat.all" /></a>
		<span class="filter-sep"></span>
		<a class="filter ${cat eq 'TECH' ? 'is-active' : ''}"
		   href="${ctx}/Journal?cmd=journal_list&amp;cat=TECH"><fmt:message key="cat.tech" /></a>
		<span class="filter-sep"></span>
		<a class="filter ${cat eq 'TRAVEL' ? 'is-active' : ''}"
		   href="${ctx}/Journal?cmd=journal_list&amp;cat=TRAVEL"><fmt:message key="cat.travel" /></a>
		<span class="filter-sep"></span>
		<a class="filter ${cat eq 'DAILY' ? 'is-active' : ''}"
		   href="${ctx}/Journal?cmd=journal_list&amp;cat=DAILY"><fmt:message key="cat.daily" /></a>
	</div>
</div>

<!-- ================= 글 목록 ================= -->
<div class="section sp-1">
	<div class="postrows" id="postList">

<c:choose>
	<c:when test="${empty posts}">
		<div class="rule"></div>
		<p class="filter-empty"><fmt:message key="journal.empty" /></p>
		<div class="rule"></div>
	</c:when>
	<c:otherwise>
		<div class="rule"></div>
		<c:forEach var="p" items="${posts}" varStatus="st">
		<a class="postrow" href="${ctx}/Journal?cmd=journal_view&amp;id=${p.postid}">
			<span class="postrow-date">${empty p.publishedat ? p.creadtedat : p.publishedat}</span>
			<span class="postrow-cat"><c:out value="${catNames[p.categoryid]}" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;"><c:out value="${p.title}" /></span>
			</span>
			<span class="postrow-read">
				<c:choose>
					<c:when test="${p.readminutes > 0}">${p.readminutes} <fmt:message key="journal.min" /></c:when>
					<c:otherwise>&mdash;</c:otherwise>
				</c:choose>
			</span>
		</a>
			<c:choose>
				<c:when test="${st.last}"><div class="rule"></div></c:when>
				<c:otherwise><div class="rule-soft"></div></c:otherwise>
			</c:choose>
		</c:forEach>
	</c:otherwise>
</c:choose>

	</div>
</div>

<%@ include file="/common/footer.jsp" %>
