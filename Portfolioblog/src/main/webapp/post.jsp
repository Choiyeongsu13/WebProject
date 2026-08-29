<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="journal" />
<c:set var="pageTitle" value="${post.title}" />
<c:set var="vLabel"    value="記録" />
<%@ include file="/common/header.jsp" %>

<article class="article">
	<div class="article-inner">

		<span class="label"><c:out value="${catNames[post.categoryid]}" /> ·
			${empty post.publishedat ? post.creadtedat : post.publishedat}</span>

		<h1 class="article-title"><c:out value="${post.title}" /></h1>

		<div class="byline">
			<span class="ph" style="width:34px;height:34px;border-radius:50%;">
				<svg width="15" height="15" viewBox="0 0 24 24" fill="none" aria-hidden="true"><circle cx="12" cy="8" r="4" stroke="#1A1A18" stroke-width="1.3"/><path d="M4 20c0-4.4 3.6-7 8-7s8 2.6 8 7" stroke="#1A1A18" stroke-width="1.3" stroke-linecap="round"/></svg>
			</span>
			<span>
				<span class="byline-name" style="display:block;">최영수</span>
				<span class="byline-meta">
<c:if test="${post.readminutes > 0}">${post.readminutes} <fmt:message key="journal.min" /> · </c:if>
					<fmt:message key="journal.views" /> ${post.viewcount}
				</span>
			</span>
		</div>

<c:if test="${not empty sessionScope.loginUser}">
		<div class="cmt-actions" style="margin:18px 0 0;">
			<a class="cmt-act" href="${ctx}/Admin?cmd=admin_edit&amp;id=${post.postid}"><fmt:message key="admin.edit" /></a>
			<form method="post" action="${ctx}/Admin" style="display:inline;"
			      onsubmit="return confirm('<fmt:message key="admin.delconfirm" />');">
				<input type="hidden" name="cmd" value="admin_deletepro">
				<input type="hidden" name="id" value="${post.postid}">
				<button type="submit" class="cmt-act"><fmt:message key="cmt.delete" /></button>
			</form>
		</div>
</c:if>

<c:if test="${not empty post.thumbnail}">
		<img class="article-thumb" src="${ctx}/images/posts/<c:out value="${post.thumbnail}" />"
		     alt="<c:out value="${post.title}" />">
</c:if>


		<div class="prose" style="white-space:pre-wrap;"><c:out value="${post.content}" /></div>

<c:if test="${not empty tags}">
		<div class="article-tags">
	<c:forEach var="t" items="${tags}">
			<span><c:out value="${t}" /></span>
	</c:forEach>
		</div>
</c:if>

<c:if test="${not empty related}">
		<section class="related">
			<span class="label" style="display:block;margin-bottom:8px;"><fmt:message key="journal.more" /></span>
			<div class="rule"></div>
	<c:forEach var="r" items="${related}" varStatus="st">
			<a class="related-item" href="${ctx}/Journal?cmd=journal_view&amp;id=${r.postid}">
				<span class="related-name"><c:out value="${r.title}" /></span>
				<span class="related-date">${empty r.publishedat ? r.creadtedat : r.publishedat}</span>
			</a>
		<c:choose>
			<c:when test="${st.last}"><div class="rule"></div></c:when>
			<c:otherwise><div class="rule-soft"></div></c:otherwise>
		</c:choose>
	</c:forEach>
		</section>
</c:if>

		<%@ include file="/common/comments.jsp" %>

	</div>
</article>

<%@ include file="/common/footer.jsp" %>