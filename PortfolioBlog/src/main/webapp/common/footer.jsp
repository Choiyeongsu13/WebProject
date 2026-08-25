<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	공통 푸터 — 여백 디자인
	사용법 : <%@ include file="/common/footer.jsp" %>
--%>

<footer class="site-footer">
	<div class="rule"></div>
	<div class="footer-in">
		<span class="footer-copy">&copy; 2026 CHOI YEONGSU</span>
		<div class="footer-links">
<%-- 로그인 전에는 관리자 입구, 로그인 후에는 로그아웃 --%>
<c:choose>
	<c:when test="${empty sessionScope.loginUser}">
			<a class="label footer-admin" href="${ctx}/admin/login.jsp"><fmt:message key="admin.entry" /></a>
	</c:when>
	<c:otherwise>
			<%-- [연결 지점] 로그아웃 처리 주소로 바꾸세요 (session.invalidate()) --%>
			<a class="label footer-admin" href="#"><fmt:message key="admin.logout" /></a>
	</c:otherwise>
</c:choose>
		</div>
	</div>
</footer>

</div>

</body>
</html>
