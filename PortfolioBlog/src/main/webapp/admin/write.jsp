<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<%--
	[연결 지점] 로그인하지 않은 사람은 들여보내지 않습니다.

	지금은 화면만 있어서 주소를 직접 치면 그냥 열립니다.
	컨트롤러(또는 필터)를 붙이면 그쪽에서 아래처럼 막아 주세요.

	  if (session.getAttribute("loginUser") == null) {
	      response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	      return;
	  }

	헤더에서 글쓰기 버튼을 숨기는 것만으로는 못 막습니다.
	막는 일은 반드시 서버에서 해야 합니다.
--%>
<c:set var="active"    value="" />
<c:set var="pageTitle"><fmt:message key="admin.write" /></c:set>
<c:set var="vLabel"    value="" />
<%@ include file="/common/header.jsp" %>

<div class="page-head">
	<span class="label"><fmt:message key="admin.write" /></span>
	<h1 class="page-title">${isJa ? '記事を書く' : '글 쓰기'}</h1>
</div>

<%--
	[연결 지점]
	  action 을 실제 서블릿 주소로 바꾸세요 (예: postWrite.do).
	  사진을 올리려면 enctype="multipart/form-data" 로 바꾸고
	  cos.jar 나 commons-fileupload 를 WEB-INF/lib 에 넣어야 합니다.
--%>
<div class="section sp-2">
	<form class="write-form" method="post" action="#">

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.title" /> <em class="req">*</em></span>
			<input type="text" name="title" maxlength="200" required>
		</label>

		<div class="write-row">
			<label class="field">
				<span class="field-label"><fmt:message key="admin.f.category" /></span>
				<%-- [연결 지점] SELECT category_id, name_ko FROM category ORDER BY sort_order --%>
				<select name="categoryId">
					<option value="1"><fmt:message key="cat.tech" /></option>
					<option value="2"><fmt:message key="cat.travel" /></option>
					<option value="3">${isJa ? '日常' : '일상'}</option>
				</select>
			</label>

			<label class="field">
				<span class="field-label"><fmt:message key="admin.f.tags" /></span>
				<input type="text" name="tags" placeholder="<fmt:message key="admin.f.tags.h" />">
			</label>
		</div>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.summary" /></span>
			<input type="text" name="summary" maxlength="500" placeholder="<fmt:message key="admin.f.summary.h" />">
		</label>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.content" /> <em class="req">*</em></span>
			<textarea name="content" rows="18" required></textarea>
		</label>

		<!-- 여행 글일 때만 쓰는 칸 -->
		<fieldset class="write-fieldset">
			<legend class="field-label">${isJa ? '旅行の記事' : '여행 글'}</legend>

			<div class="write-row">
				<label class="field">
					<span class="field-label"><fmt:message key="admin.f.place" /></span>
					<input type="text" name="place" maxlength="100" placeholder="<fmt:message key="admin.f.place.h" />">
				</label>

				<label class="field">
					<span class="field-label"><fmt:message key="admin.f.coord" /></span>
					<input type="text" name="coord" placeholder="<fmt:message key="admin.f.coord.h" />">
				</label>
			</div>

			<p class="write-hint">${isJa ? '座標は album テーブルの latitude / longitude に保存されます。地図はまだ表示しません。' : '좌표는 album 테이블의 latitude / longitude 에 저장됩니다. 지도 표시는 아직 붙이지 않았습니다.'}</p>
		</fieldset>

		<label class="field">
			<span class="field-label"><fmt:message key="admin.f.thumb" /></span>
			<input type="text" name="thumbnail" placeholder="images/osaka-01.jpg">
		</label>

		<div class="write-actions">
			<a class="cmt-act" href="${ctx}/posts.jsp"><fmt:message key="admin.cancel" /></a>
			<button type="submit" name="status" value="DRAFT" class="cmt-act"><fmt:message key="admin.draft" /></button>
			<button type="submit" name="status" value="PUBLISHED" class="btn-line"><fmt:message key="admin.save" /></button>
		</div>

	</form>
</div>

<%@ include file="/common/footer.jsp" %>
