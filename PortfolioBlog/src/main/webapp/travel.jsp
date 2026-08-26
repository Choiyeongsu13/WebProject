<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
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

<%--
	앨범 목록.

	albums : album 테이블의 목록            (TravelListService)
	photos : album_id -> 그 앨범의 사진 목록 (TravelListService)

	사진 파일은 DB 에 넣지 않습니다. file_name 만 넣고
	파일 자체는 webapp/images/travel 폴더에 둡니다.
--%>
<!-- ================= 앨범 ================= -->
<div class="section sp-2">

<c:forEach var="a" items="${albums}" varStatus="st">
	<c:set var="shots" value="${photos[a.albumid]}" />

	<article class="album">
		<div class="album-head">
			<span class="album-no"><fmt:formatNumber value="${st.count}" minIntegerDigits="2" /></span>
			<div class="album-title-wrap">
				<h2 class="album-title"><c:out value="${a.title}" /></h2>
				<p class="album-meta">
					<c:out value="${a.place}" /><c:if test="${not empty a.country}"> · <c:out value="${a.country}" /></c:if>
					<c:if test="${not empty a.travelfrom}">
						&nbsp;/&nbsp; ${a.travelfrom}<c:if test="${not empty a.travelto}"> &ndash; ${a.travelto}</c:if>
					</c:if>
					<c:if test="${not empty shots}">
						&nbsp;/&nbsp; ${fn:length(shots)}<fmt:message key="travel.photos" />
					</c:if>
				</p>
			</div>
	<c:if test="${a.postid > 0}">
			<a class="album-link" href="${ctx}/Journal?cmd=journal_view&amp;id=${a.postid}"><fmt:message key="travel.readpost" /></a>
	</c:if>
		</div>

		<div class="gallery">
	<c:choose>
		<c:when test="${empty shots}">
			<div class="ph shot shot-wide">
				<svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true"><rect x="3" y="3" width="18" height="18" stroke="#1A1A18" stroke-width="1.2"/><path d="M21 15L16 10L5 21" stroke="#1A1A18" stroke-width="1.2"/></svg>
			</div>
		</c:when>
		<c:otherwise>
			<c:forEach var="ph" items="${shots}" varStatus="ps">
			<img class="shot ${ps.first or ps.last ? 'shot-wide' : ''}"
			     src="${ctx}/images/travel/<c:out value="${ph.filename}" />"
			     alt="<c:out value="${ph.caption}" />">
			</c:forEach>
		</c:otherwise>
	</c:choose>
		</div>

	<c:if test="${not empty a.description}">
		<p class="album-caption"><c:out value="${a.description}" /></p>
	</c:if>
	</article>

</c:forEach>

<c:if test="${empty albums}">
	<p class="filter-empty"><fmt:message key="travel.empty" /></p>
</c:if>

	<!-- 다음 앨범 자리 -->
	<div class="album-next">
		<span class="label">${isJa ? '次の旅' : '다음 여행'}</span>
	</div>

</div>

<%@ include file="/common/footer.jsp" %>
