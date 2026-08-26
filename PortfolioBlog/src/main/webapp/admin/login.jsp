<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="" />
<c:set var="pageTitle"><fmt:message key="admin.login" /></c:set>
<c:set var="vLabel"    value="" />
<%@ include file="/common/header.jsp" %>

<%--
	관리자 로그인

	AdminController 의 cmd=admin_loginpro 로 보냅니다.
	비밀번호 비교는 ProfillDAO.userLogin 이 DB 안에서 합니다.
	성공하면 세션에 loginUser 가 들어가고 홈으로 돌아갑니다.
--%>

<div class="auth">
	<div class="auth-box">

		<span class="label"><fmt:message key="admin.login" /></span>
		<h1 class="auth-title">${isJa ? '管理者' : '관리자'}</h1>

		<form class="auth-form" method="post" action="${ctx}/Admin">

			<input type="hidden" name="cmd" value="admin_loginpro">

			<label class="field">
				<span class="field-label"><fmt:message key="admin.id" /></span>
				<input type="text" name="loginId" autocomplete="username" required>
			</label>

			<label class="field">
				<span class="field-label"><fmt:message key="admin.pw" /></span>
				<input type="password" name="password" autocomplete="current-password" required>
			</label>

			<%--
				로그인 실패 메시지.
				AdminLoginProService 가 error 라는 이름으로 담아 보냅니다.
				아이디가 틀렸는지 비밀번호가 틀렸는지는 구분해서 알려주지 않습니다.
			--%>
<c:if test="${not empty error}">
			<p class="auth-error"><c:out value="${error}" /></p>
</c:if>

			<div class="auth-actions">
				<button type="submit" class="btn-line"><fmt:message key="admin.signin" /></button>
			</div>
		</form>

	</div>
</div>

<%@ include file="/common/footer.jsp" %>
