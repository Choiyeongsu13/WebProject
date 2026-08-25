<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="travel" />
<c:set var="pageTitle"><fmt:message key="title.travel" /></c:set>
<c:set var="vLabel"    value="旅" />
<%@ include file="/common/header.jsp" %>

<!-- ================= 페이지 제목 ================= -->
<div class="page-head">
	<span class="label"><fmt:message key="label.travel" /></span>
	<h1 class="page-title"><fmt:message key="title.travel" /></h1>
	<p class="page-lead"><fmt:message key="travel.lead" /></p>
</div>

<!-- ================= 앨범 ================= -->
<div class="section sp-2">

	<!-- 앨범 1 -->
	<article class="album">
		<div class="album-head">
			<span class="album-no">01</span>
			<div class="album-title-wrap">
				<h2 class="album-title">${isJa ? '大阪の四日間' : '오사카 나흘'}</h2>
				<p class="album-meta">${isJa ? '大阪 · 日本' : '오사카 · 일본'} &nbsp;/&nbsp; 2026.07.18 &ndash; 07.21 &nbsp;/&nbsp; 12<fmt:message key="travel.photos" /></p>
			</div>
			<a class="album-link" href="${ctx}/post.jsp"><fmt:message key="travel.readpost" /></a>
		</div>

		<div class="gallery">
			<div class="ph shot shot-wide">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot shot-wide">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
		</div>

		<p class="album-caption">${isJa ? '道頓堀の夜、大阪城へ向かう道' : '도톤보리의 밤, 오사카성 가는 길'}</p>
	</article>

	<!-- 앨범 2 -->
	<article class="album">
		<div class="album-head">
			<span class="album-no">02</span>
			<div class="album-title-wrap">
				<h2 class="album-title">${isJa ? '京都の桜' : '교토 벚꽃'}</h2>
				<p class="album-meta">${isJa ? '京都 · 日本' : '교토 · 일본'} &nbsp;/&nbsp; 2026.04.02 &ndash; 04.04 &nbsp;/&nbsp; 8<fmt:message key="travel.photos" /></p>
			</div>
			<a class="album-link" href="${ctx}/post.jsp"><fmt:message key="travel.readpost" /></a>
		</div>

		<div class="gallery">
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot shot-wide">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
			<div class="ph shot">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
		</div>

		<p class="album-caption">${isJa ? '哲学の道を歩く' : '철학의 길을 걷다'}</p>
	</article>

	<!-- 다음 앨범 자리 -->
	<div class="album-next">
		<span class="label">${isJa ? '次の旅' : '다음 여행'}</span>
	</div>

</div>

<%@ include file="/common/footer.jsp" %>
