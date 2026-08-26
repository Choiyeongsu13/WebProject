<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="works" />
<c:set var="pageTitle"><fmt:message key="title.works" /></c:set>
<c:set var="vLabel"    value="作品" />
<%@ include file="/common/header.jsp" %>

<%--
	필터에 보일 언어 목록은 WorkListService 가 filterLangs 로 넘겨 줍니다.
	project_tag 에 실제로 붙어 있는 태그 이름을 모아 만든 것이라,
	글쓰기 화면에서 태그를 새로 적으면 여기 버튼도 저절로 늘어납니다.
--%>
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
<%--
	data-langs 에는 그 작업에 붙은 태그 이름이 띄어쓰기로 들어갑니다.
	WorkListService 가 langs 라는 이름으로 project_id -> "Java JSP Oracle" 를 넘겨 줍니다.
	썸네일은 파일 이름만 DB 에 넣고, 파일 자체는 webapp/images/works 폴더에 둡니다.
--%>
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
// 언어 필터 (화면 확인용 — 나중에 Servlet 쿼리로 대체 가능)
(function () {
	var buttons = document.querySelectorAll('.filter');
	var items = document.querySelectorAll('#workGrid article[data-langs]');
	var empty = document.getElementById('filterEmpty');

	for (var i = 0; i < buttons.length; i++) {
		buttons[i].addEventListener('click', function () {
			var target = this.getAttribute('data-filter');
			var shown = 0;

			for (var j = 0; j < buttons.length; j++) {
				buttons[j].classList.remove('is-active');
			}
			this.classList.add('is-active');

			for (var k = 0; k < items.length; k++) {
				var langs = (' ' + items[k].getAttribute('data-langs') + ' ');
				var match = (target === 'all') || (langs.indexOf(' ' + target + ' ') !== -1);
				items[k].style.display = match ? '' : 'none';
				if (match) { shown++; }
			}

			empty.hidden = (shown > 0);
		});
	}
})();
</script>

<%@ include file="/common/footer.jsp" %>
