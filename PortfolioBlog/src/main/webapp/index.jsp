<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="home" />
<c:set var="pageTitle"><fmt:message key="title.home" /></c:set>
<c:set var="vLabel"    value="ポートフォリオ" />
<%@ include file="/common/header.jsp" %>

<!-- ================= 히어로 ================= -->
<div class="hero">

	<div class="hero-top">
		<span class="seal"></span>
		<h1 class="hero-title"><fmt:message key="hero.greeting" /></h1>
	</div>

	<p class="hero-lead hero-indent"><fmt:message key="hero.lead" /></p>

	<div class="hero-actions hero-indent">
		<a class="link-u" href="${ctx}/Work?cmd=work_list"><fmt:message key="hero.cta1" /></a>
		<a class="link-u-off" href="${ctx}/Journal?cmd=journal_list"><fmt:message key="hero.cta2" /></a>
	</div>

</div>

<!-- ================= 기술 ================= -->
<div class="section sp-6">
	<div class="rule"></div>
	<div class="section-body" style="padding-top:26px;">
		<span class="label section-label" style="padding-top:0;"><fmt:message key="label.stack" /></span>
		<div class="section-main stackrow">
			<span>Java</span>
			<span>JSP / Servlet</span>
			<span>Oracle</span>
			<span>JavaScript</span>
			<span>Git</span>
		</div>
	</div>
</div>

<!-- ================= 작업 ================= -->
<div class="section sp-3">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.works" /></span>

		<div class="section-main worklist">

<c:choose>
	<c:when test="${empty featured}">
			<div class="rule"></div>
			<p class="filter-empty"><fmt:message key="works.empty" /></p>
			<div class="rule"></div>
	</c:when>
	<c:otherwise>
		<c:forEach var="p" items="${featured}" varStatus="st">
			<div class="rule"></div>
			<a class="work" href="${ctx}/Work?cmd=work_list">
				<span class="work-no"><fmt:formatNumber value="${st.count}" minIntegerDigits="2" /></span>
				<span class="work-main">
					<span class="work-title" style="display:block;"><c:out value="${p.title}" /></span>
					<span class="work-desc" style="display:block;"><c:out value="${p.description}" /></span>
				</span>
				<span class="work-tech"><c:out value="${empty langs[p.project_id] ? p.category_code : langs[p.project_id]}" /></span>
			</a>
		</c:forEach>
			<div class="rule"></div>
	</c:otherwise>
</c:choose>

		</div>
	</div>
</div>

<!-- ================= 글 ================= -->
<div class="section sp-3">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.journal" /></span>

		<div class="section-main journal">

			<div>
				<div class="journal-head">
					<span class="journal-dash"></span>
					<span class="label label-on"><fmt:message key="cat.tech" /></span>
				</div>
				<div class="postlist">
<c:choose>
	<c:when test="${empty techPosts}">
					<p class="filter-empty"><fmt:message key="journal.empty" /></p>
	</c:when>
	<c:otherwise>
		<c:forEach var="p" items="${techPosts}">
					<a href="${ctx}/Journal?cmd=journal_view&amp;id=${p.postid}">
						<span class="post-title" style="display:block;"><c:out value="${p.title}" /></span>
						<span class="post-date">${empty p.publishedat ? p.creadtedat : p.publishedat}</span>
					</a>
		</c:forEach>
	</c:otherwise>
</c:choose>
				</div>
			</div>

			<div>
				<div class="journal-head">
					<span class="journal-dash soft"></span>
					<span class="label"><fmt:message key="cat.travel" /></span>
				</div>
				<div class="postlist">
<c:choose>
	<c:when test="${empty travelPosts}">
					<p class="filter-empty"><fmt:message key="journal.empty" /></p>
	</c:when>
	<c:otherwise>
		<c:forEach var="p" items="${travelPosts}">
					<a href="${ctx}/Journal?cmd=journal_view&amp;id=${p.postid}">
						<span class="post-title" style="display:block;"><c:out value="${p.title}" /></span>
						<span class="post-date">${empty p.publishedat ? p.creadtedat : p.publishedat}</span>
					</a>
		</c:forEach>
	</c:otherwise>
</c:choose>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp" %>
