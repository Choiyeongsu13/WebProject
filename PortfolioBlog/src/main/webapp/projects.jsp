<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="works" />
<c:set var="pageTitle"><fmt:message key="title.works" /></c:set>
<c:set var="vLabel"    value="作品" />
<%@ include file="/common/header.jsp" %>

<%--
	필터에 보일 언어 목록.

	쉼표로 나눠 적습니다. 여기만 고치면 아래 필터 버튼이 알아서 바뀝니다.
	새 작업을 추가하면서 쓴 언어가 없으면 여기에 이름을 하나 더 넣으세요.

	[연결 지점] 나중에 DAO 를 붙이면 이 값 자리에 아래 쿼리 결과를 넣으면 됩니다.
	   SELECT DISTINCT t.name
	     FROM tag t JOIN project_tag pt ON pt.tag_id = t.tag_id
	    ORDER BY t.name
	   컨트롤러에서 request.setAttribute("filterLangs", 목록) 으로 넘기고
	   아래 c:set 한 줄을 지우면 그대로 돌아갑니다.
--%>
<c:set var="filterLangs" value="Java,JSP,Oracle,JavaScript" />

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
	data-langs 에 그 작업에서 쓴 언어를 띄어쓰기로 나열합니다.
	위 filterLangs 에 적은 이름과 철자를 맞춰주세요.
--%>
<div class="section sp-1">
	<div class="workgrid" id="workGrid">

		<article data-langs="Java JSP Oracle">
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
			<h2 class="card-title">[프로젝트명]</h2>
			<p class="card-desc">JSP와 Oracle로 만든 학내 커뮤니티 서비스입니다. 4인 팀에서 화면 개발을 담당했습니다.</p>
			<div class="card-meta">
				<span class="card-tech">JAVA · JSP · ORACLE</span>
			</div>
		</article>

		<article data-langs="Java JSP">
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
			<h2 class="card-title">선거 결과 조회</h2>
			<p class="card-desc">Model2 MVC 패턴으로 구현한 선거 데이터 조회 웹 애플리케이션입니다.</p>
			<div class="card-meta">
				<span class="card-tech">JAVA · JSP</span>
			</div>
		</article>

		<article data-langs="Java Oracle">
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
			<h2 class="card-title">[프로젝트명]</h2>
			<p class="card-desc">백신 접종 데이터를 조회하고 통계를 시각화한 프로젝트입니다.</p>
			<div class="card-meta">
				<span class="card-tech">JAVA · ORACLE</span>
			</div>
		</article>

		<article data-langs="Java">
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
			<h2 class="card-title">[프로젝트명]</h2>
			<p class="card-desc">캠퍼스 길찾기 앱입니다. 팀 발표에서 좋은 평가를 받았습니다.</p>
			<div class="card-meta">
				<span class="card-tech">JAVA</span>
			</div>
		</article>

		<article data-langs="Java JSP Oracle JavaScript">
			<div class="ph ph-4x3">
				<svg width="22" height="22" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
				<span><fmt:message key="works.shot" /></span>
			</div>
			<h2 class="card-title">포트폴리오 블로그</h2>
			<p class="card-desc">지금 보고 계신 이 사이트를 직접 설계하고 구현했습니다. 화면 설계부터 DB 설계까지 혼자 진행했습니다.</p>
			<div class="card-meta">
				<span class="card-tech">JAVA · JSP · ORACLE · JAVASCRIPT</span>
			</div>
		</article>

	</div>

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
