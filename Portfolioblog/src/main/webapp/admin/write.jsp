<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<%--
	글 쓰기.

	로그인하지 않은 사람은 AdminController 가 여기까지 못 오게 막습니다.
	헤더에서 버튼을 숨기는 것만으로는 못 막습니다. 막는 일은 서버에서 합니다.

	받아 쓰는 값
		categories : category_id -> 분류 이름   (AdminWriteService)
		error      : 저장 실패 사유             (AdminWriteProService)
		post       : 적다가 되돌아온 내용        (AdminWriteProService)
--%>
<c:set var="active"    value="" />
<c:set var="pageTitle"><fmt:message key="admin.write" /></c:set>
<c:set var="vLabel"    value="" />
<%@ include file="/common/header.jsp" %>

<div class="page-head">
	<span class="label"><fmt:message key="admin.write" /></span>
	<h1 class="page-title">${isJa ? '記事を書く' : '글 쓰기'}</h1>
</div>

<div class="section sp-2">
	<form class="write-form" method="post" action="${ctx}/Admin">

		<input type="hidden" name="cmd" value="admin_writepro">

<c:if test="${not empty error}">
		<p class="auth-error"><c:out value="${error}" /></p>
</c:if>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.title" /> <em class="req">*</em></span>
			<input type="text" name="title" maxlength="200" required
			       value="<c:out value="${post.title}" />">
		</label>

		<div class="write-row">
			<label class="field">
				<span class="field-label"><fmt:message key="admin.f.category" /></span>
				<select name="categoryId">
<c:forEach var="cg" items="${categories}">
					<option value="${cg.key}" ${post.categoryid eq cg.key ? 'selected' : ''}><c:out value="${cg.value}" /></option>
</c:forEach>
				</select>
			</label>

			<label class="field">
				<span class="field-label"><fmt:message key="admin.f.tags" /></span>
				<input type="text" name="tags" placeholder="<fmt:message key="admin.f.tags.h" />">
			</label>
		</div>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.summary" /></span>
			<input type="text" name="summary" maxlength="500"
			       placeholder="<fmt:message key="admin.f.summary.h" />"
			       value="<c:out value="${post.summary}" />">
		</label>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.content" /> <em class="req">*</em></span>
			<textarea name="content" rows="18" required><c:out value="${post.content}" /></textarea>
		</label>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.thumb" /></span>
			<input type="text" name="thumbnail" placeholder="osaka-01.jpg"
			       value="<c:out value="${post.thumbnail}" />">
		</label>

		<div class="write-actions">
			<a class="cmt-act" href="${ctx}/Journal?cmd=journal_list"><fmt:message key="admin.cancel" /></a>
			<button type="submit" name="status" value="DRAFT" class="cmt-act"><fmt:message key="admin.draft" /></button>
			<button type="submit" name="status" value="PUBLISHED" class="btn-line"><fmt:message key="admin.save" /></button>
		</div>

	</form>
</div>

<%@ include file="/common/footer.jsp" %>
