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

<!-- ================= 필터 ================= -->
<div class="section sp-2">
	<div class="filters">
		<button type="button" class="filter is-active" data-filter="all"><fmt:message key="cat.all" /></button>
		<span class="filter-sep"></span>
		<button type="button" class="filter" data-filter="tech"><fmt:message key="cat.tech" /></button>
		<span class="filter-sep"></span>
		<button type="button" class="filter" data-filter="travel"><fmt:message key="cat.travel" /></button>
	</div>
</div>

<!-- ================= 글 목록 ================= -->
<div class="section sp-1">
	<div class="postrows" id="postList">

		<div class="rule"></div>

		<a class="postrow" data-category="tech" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.08.15</span>
			<span class="postrow-cat"><fmt:message key="cat.tech" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">JSP 프로젝트에서 DAO 패턴 정리하기</span>
			</span>
			<span class="postrow-read">6 <fmt:message key="journal.min" /></span>
		</a>
		<div class="rule-soft"></div>

		<a class="postrow" data-category="tech" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.07.28</span>
			<span class="postrow-cat"><fmt:message key="cat.tech" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">Oracle 연동하며 겪은 커넥션 관리 문제</span>
			</span>
			<span class="postrow-read">4 <fmt:message key="journal.min" /></span>
		</a>
		<div class="rule-soft"></div>

		<a class="postrow" data-category="travel" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.07.22</span>
			<span class="postrow-cat"><fmt:message key="cat.travel" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">오사카에서 보낸 나흘, 여행 기록</span>
			</span>
			<span class="postrow-read">&mdash;</span>
		</a>
		<div class="rule-soft"></div>

		<a class="postrow" data-category="tech" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.06.02</span>
			<span class="postrow-cat"><fmt:message key="cat.tech" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">Model2 MVC 패턴으로 게시판 다시 만들기</span>
			</span>
			<span class="postrow-read">7 <fmt:message key="journal.min" /></span>
		</a>
		<div class="rule-soft"></div>

		<a class="postrow" data-category="travel" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.04.05</span>
			<span class="postrow-cat"><fmt:message key="cat.travel" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">종강 후 떠난 교토 벚꽃 산책</span>
			</span>
			<span class="postrow-read">&mdash;</span>
		</a>
		<div class="rule-soft"></div>

		<a class="postrow" data-category="tech" href="${ctx}/post.jsp">
			<span class="postrow-date">2026.03.14</span>
			<span class="postrow-cat"><fmt:message key="cat.tech" /></span>
			<span class="postrow-main">
				<span class="post-title" style="display:block;">처음 만든 JSP 게시판을 돌아보며</span>
			</span>
			<span class="postrow-read">5 <fmt:message key="journal.min" /></span>
		</a>
		<div class="rule"></div>

	</div>

	<!-- 페이징 — 지금은 화면만. DAO 연결 후 실제 페이지 수로 바뀝니다 -->
	<div class="pager">
		<span class="is-off">&larr;</span>
		<span class="is-current">1</span>
		<a href="#">2</a>
		<a href="#">&rarr;</a>
	</div>
</div>

<script>
// 카테고리 필터 (화면 확인용 — 나중에 Servlet 쿼리로 대체 가능)
(function () {
	var buttons = document.querySelectorAll('.filter');
	var rows = document.querySelectorAll('#postList .postrow[data-category]');

	for (var i = 0; i < buttons.length; i++) {
		buttons[i].addEventListener('click', function () {
			var target = this.getAttribute('data-filter');

			for (var j = 0; j < buttons.length; j++) {
				buttons[j].classList.remove('is-active');
			}
			this.classList.add('is-active');

			for (var k = 0; k < rows.length; k++) {
				var match = (target === 'all') || (rows[k].getAttribute('data-category') === target);
				rows[k].style.display = match ? '' : 'none';
			}
		});
	}
})();
</script>

<%@ include file="/common/footer.jsp" %>
