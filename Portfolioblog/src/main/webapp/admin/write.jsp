<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>

<c:set var="active"    value="" />
<c:set var="pageTitle"><fmt:message key="${isEdit ? 'admin.edit' : 'admin.write'}" /></c:set>
<c:set var="vLabel"    value="" />
<%@ include file="/common/header.jsp" %>

<div class="page-head">
	<span class="label"><fmt:message key="${isEdit ? 'admin.edit' : 'admin.write'}" /></span>
	<h1 class="page-title">${isEdit ? (isJa ? '記事を編集' : '글 수정') : (isJa ? '記事を書く' : '글 쓰기')}</h1>
</div>

<div class="section sp-2">
	<form class="write-form" method="post"
	      action="${ctx}/Admin?cmd=${isEdit ? 'admin_editpro' : 'admin_writepro'}"
	      enctype="multipart/form-data">

<c:if test="${not empty error}">
		<p class="auth-error"><c:out value="${error}" /></p>
</c:if>

<c:if test="${isEdit}">
		<input type="hidden" name="postId" value="${post.postid}">
</c:if>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.title" /> <em class="req">*</em></span>
			<input type="text" name="title" maxlength="200" required
			       value="<c:out value="${post.title}" />">
		</label>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.category" /> <em class="req">*</em></span>
			<select name="categoryId" class="field-select" required>
<c:forEach var="cg" items="${categories}">
				<option value="${cg.key}" ${post.categoryid eq cg.key ? 'selected' : ''}><c:out value="${cg.value}" /></option>
</c:forEach>
			</select>
		</label>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.content" /> <em class="req">*</em></span>
			<textarea name="content" rows="18" required><c:out value="${post.content}" /></textarea>
		</label>



		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.thumb" /></span>
<c:if test="${isEdit and not empty post.thumbnail}">
			<img class="article-thumb" style="margin:0 0 12px;max-width:220px;"
			     src="${ctx}/images/posts/<c:out value="${post.thumbnail}" />" alt="">
</c:if>
			<input type="file" name="thumbnail" accept="image/*" class="field-file">
<c:if test="${isEdit}">
			<span class="write-hint"><fmt:message key="admin.f.thumb.keep" /></span>
</c:if>
		</label>

		<div class="write-actions">
			<a class="cmt-act" href="${ctx}/Journal?cmd=journal_list"><fmt:message key="admin.cancel" /></a>
			<button type="submit" class="btn-line"><fmt:message key="${isEdit ? 'admin.update' : 'admin.save'}" /></button>
		</div>

	</form>
</div>

<%@ include file="/common/footer.jsp" %>