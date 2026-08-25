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

	[연결 지점]
	  action 을 실제 서블릿 주소로 바꾸고, 서블릿에서 blog_user 를 조회합니다.
	    SELECT user_id, name, password FROM blog_user WHERE login_id = ?
	  비밀번호는 해시를 비교하세요. 평문 비교는 절대 금지입니다.
	  성공하면 session.setAttribute("loginUser", ...) 를 넣고 write.jsp 로 보냅니다.
--%>

<div class="auth">
	<div class="auth-box">

		<span class="label"><fmt:message key="admin.login" /></span>
		<h1 class="auth-title">${isJa ? '管理者' : '관리자'}</h1>

		<form class="auth-form" method="post" action="#">

			<label class="field">
				<span class="field-label"><fmt:message key="admin.id" /></span>
				<input type="text" name="loginId" autocomplete="username" required>
			</label>

			<label class="field">
				<span class="field-label"><fmt:message key="admin.pw" /></span>
				<input type="password" name="password" autocomplete="current-password" required>
			</label>

			<%-- 로그인 실패 시 이 자리에 메시지를 넣습니다 --%>
			<p class="auth-error" hidden>${isJa ? 'IDまたはパスワードが違います。' : '아이디 또는 비밀번호가 맞지 않습니다.'}</p>

			<div class="auth-actions">
				<button type="submit" class="btn-line"><fmt:message key="admin.signin" /></button>
			</div>
		</form>

	</div>
</div>

<%@ include file="/common/footer.jsp" %>
