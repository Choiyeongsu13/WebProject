<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="works" />
<c:set var="pageTitle"><fmt:message key="title.works" /></c:set>
<c:set var="vLabel"    value="作品" />
<%@ include file="/common/header.jsp" %>


<!-- ================= 페이지 제목 ================= -->
<div class="page-head">
	<span class="label"><fmt:message key="label.works" /></span>
	<h1 class="page-title"><fmt:message key="title.works" /></h1>
	<p class="page-lead"><fmt:message key="works.lead" /></p>
</div>

<!-- ================= 필터 (언어 기준) ================= -->
<div class="section sp-2">
	<div class="filters">
		<button type="button" class="filter is-active" data-filter="all"><fmt:message key="cat.all" /></button>
<c:forEach var="lang0" items="${filterLangs}">
		<span class="filter-sep"></span>
		<button type="button" class="filter" data-filter="${lang0}">${lang0}</button>
</c:forEach>
	</div>
</div>

<!-- ================= 작업 목록 ================= -->

<div class="section sp-1">
	<div class="workgrid" id="workGrid">

<c:forEach var="p" items="${projects}">
		<article data-langs="<c:out value="${langs[p.project_id]}" />">
	<c:choose>
		<c:when test="${not empty p.thumbnail}">
			<img class="ph-4x3" src="${ctx}/images/works/<c:out value="${p.thumbnail}" />"
			     alt="<c:out value="${p.title}" />" style="width:100%;display:block;">
		</c:when>
		<c:otherwise>
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
		</c:otherwise>
	</c:choose>
			<h2 class="card-title"><c:out value="${p.title}" /></h2>
			<p class="card-desc"><c:out value="${p.description}" /></p>
			<div class="card-meta">
				<span class="card-tech"><c:out value="${empty langs[p.project_id] ? p.category_code : langs[p.project_id]}" /></span>
	<c:if test="${not empty p.github_url}">
				<a class="link-u" href="<c:out value="${p.github_url}" />" target="_blank" rel="noopener">GitHub</a>
	</c:if>
			</div>
		</article>
</c:forEach>

	</div>

<c:if test="${empty projects}">
	<p class="filter-empty"><fmt:message key="works.empty" /></p>
</c:if>

	<p class="filter-empty" id="filterEmpty" hidden>${isJa ? 'この言語の作品はまだありません。' : '이 언어로 만든 작업이 아직 없습니다.'}</p>
</div>

<script>
$(function () {

	var $buttons = $('.filter');
	var $items   = $('#workGrid article[data-langs]');
	var $empty   = $('#filterEmpty');

	$buttons.on('click', function () {

		var target = $(this).attr('data-filter');
		var shown  = 0;

		$buttons.removeClass('is-active');
		$(this).addClass('is-active');

		$items.each(function () {
			var langs = ' ' + $(this).attr('data-langs') + ' ';
			var match = (target === 'all') || (langs.indexOf(' ' + target + ' ') !== -1);

			$(this).toggle(match);
			if (match) { shown++; }
		});

		$empty.prop('hidden', shown > 0);
	});
});
</script>
<%@ include file="/common/footer.jsp" %>
