<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="" />
<c:set var="pageTitle" value="404" />
<c:set var="vLabel"    value="" />
<%@ include file="/common/header.jsp" %>

<%--
	주소가 틀렸거나 서버에서 문제가 생겼을 때 나오는 화면입니다.
	web.xml 의 <error-page> 에서 이 파일을 가리키고 있습니다.

	톰캣 기본 오류 화면에는 서버 버전과 파일 경로가 그대로 나옵니다.
	그걸 보여 주지 않으려고 화면을 따로 두었습니다.
--%>

<div class="page-head">
	<span class="label">ERROR</span>
	<h1 class="page-title">${isJa ? '見つかりません' : '찾을 수 없습니다'}</h1>
	<p class="page-lead">${isJa ? 'アドレスが変わったか、削除されたページです。' : '주소가 바뀌었거나 지워진 페이지입니다.'}</p>
</div>

<div class="section sp-2">
	<div class="rule"></div>
	<div class="section-body" style="padding-top:26px;">
		<span class="label section-label" style="padding-top:0;">GO</span>
		<div class="section-main">
			<a class="link-u" href="${ctx}/Home?cmd=home">${isJa ? 'ホームに戻る' : '홈으로 돌아가기'}</a>
		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp" %>
