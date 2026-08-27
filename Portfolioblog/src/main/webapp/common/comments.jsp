<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	댓글 영역 (티스토리 방식)

	사용법 : 글 상세 화면에서 본문 아래에 include 한다.
		<%@ include file="/common/comments.jsp" %>

	받아 쓰는 값
		post     : 지금 보고 있는 글            (JournalViewService)
		comments : 그 글의 댓글 목록            (JournalViewService)

	- 회원가입 없이 닉네임 + 비밀번호로 답니다.
	- 비밀번호는 DAO 가 STANDARD_HASH 로 바꿔서 넣습니다. 원본은 저장하지 않습니다.
	- 지운 댓글도 목록에는 남깁니다. 빼 버리면 그 밑에 달린 답글이 붕 뜹니다.
--%>

<%-- 지우지 않은 댓글만 셉니다 --%>
<c:set var="cmtCount" value="0" />
<c:forEach var="c0" items="${comments}">
	<c:if test="${not c0.deleted}"><c:set var="cmtCount" value="${cmtCount + 1}" /></c:if>
</c:forEach>

<section class="comments" id="comments">

	<div class="cmt-head">
		<span class="label label-on"><fmt:message key="cmt.title" /></span>
		<span class="cmt-count">${cmtCount}<fmt:message key="cmt.count" /></span>
	</div>

	<div class="rule"></div>

<%--
	댓글을 쓰거나 지우다 실패하면 서비스가 세션에 commentError 를 담아 둡니다.
	한 번 보여 준 뒤에는 지웁니다. 안 지우면 다음 화면에도 계속 따라다닙니다.
--%>
<c:if test="${not empty sessionScope.commentError}">
	<p class="cmt-error"><c:out value="${sessionScope.commentError}" /></p>
	<c:remove var="commentError" scope="session" />
</c:if>

	<!-- ================= 댓글 목록 ================= -->
	<div class="cmt-list">

<c:choose>
	<c:when test="${empty comments}">
		<p class="cmt-empty"><fmt:message key="cmt.empty" /></p>
	</c:when>
	<c:otherwise>
		<c:forEach var="cm" items="${comments}">
		<article class="cmt ${cm.reply ? 'cmt-child' : ''}">
			<div class="cmt-meta">
				<span class="cmt-nick"><c:out value="${cm.nickname}" /></span>
				<span class="cmt-date">${cm.createdat}</span>
			</div>

			<c:choose>
				<c:when test="${cm.deleted}">
			<p class="cmt-body cmt-removed"><fmt:message key="cmt.removed" /></p>
				</c:when>
				<c:when test="${cm.secret and empty sessionScope.loginUser}">
			<p class="cmt-body cmt-removed"><fmt:message key="cmt.locked" /></p>
				</c:when>
				<c:otherwise>
			<p class="cmt-body"><c:out value="${cm.content}" /></p>
				</c:otherwise>
			</c:choose>

			<c:if test="${not cm.deleted}">
			<div class="cmt-actions">
				<c:if test="${not cm.reply}">
				<button type="button" class="cmt-act" data-reply="${cm.commentid}"><fmt:message key="cmt.reply" /></button>
				</c:if>
				<button type="button" class="cmt-act" data-del="${cm.commentid}"><fmt:message key="cmt.delete" /></button>
			</div>
			</c:if>
		</article>
		</c:forEach>
	</c:otherwise>
</c:choose>

	</div>

	<!-- ================= 댓글 쓰기 ================= -->
	<form class="cmt-form" method="post" action="${ctx}/Journal" id="cmtForm">

		<input type="hidden" name="cmd" value="comment_write">
		<input type="hidden" name="postId" value="${post.postid}">
		<input type="hidden" name="parentId" value="" id="cmtParent">

		<p class="cmt-replying" id="cmtReplying" hidden>
			<span id="cmtReplyingTo"></span>
			<button type="button" class="cmt-act" id="cmtCancelReply"><fmt:message key="admin.cancel" /></button>
		</p>

		<div class="cmt-row">
			<label class="field">
				<span class="field-label"><fmt:message key="cmt.nick" /></span>
				<input type="text" name="nickname" maxlength="30" required
				       placeholder="${isJa ? 'ニックネーム' : '닉네임'}">
			</label>

			<label class="field">
				<span class="field-label"><fmt:message key="cmt.pw" /> <em class="req">*</em></span>
				<input type="password" name="password" maxlength="20" required
				       placeholder="<fmt:message key="cmt.pw.hint" />">
			</label>

			<label class="field field-check">
				<input type="checkbox" name="secret" value="on">
				<span><fmt:message key="cmt.secret" /></span>
			</label>
		</div>

		<label class="field">
			<span class="field-label"><fmt:message key="cmt.content" /></span>
			<textarea name="content" rows="4" maxlength="1000" required
			          placeholder="<fmt:message key="cmt.placeholder" />"></textarea>
		</label>

		<div class="cmt-submit">
			<button type="submit" class="btn-line"><fmt:message key="cmt.submit" /></button>
		</div>
	</form>

	<%--
		삭제 확인.

		비밀번호는 서버로 보냅니다. 화면에서 비교하면 안 됩니다.
		개발자 도구로 자바스크립트를 고치면 그대로 통과되기 때문입니다.
		맞는지 틀린지는 DAO 의 update ... where 조건이 가립니다.
	--%>
	<div class="cmt-delbox" id="cmtDelBox" hidden>
		<form method="post" action="${ctx}/Journal">
			<input type="hidden" name="cmd" value="comment_delete">
			<input type="hidden" name="postId" value="${post.postid}">
			<input type="hidden" name="commentId" value="" id="cmtDelId">
			<span class="field-label"><fmt:message key="cmt.pw" /></span>
			<input type="password" name="password" maxlength="20" required>
			<button type="submit" class="btn-line"><fmt:message key="cmt.delete" /></button>
			<button type="button" class="cmt-act" id="cmtDelCancel"><fmt:message key="admin.cancel" /></button>
		</form>
	</div>

</section>

<script>
// 답글 / 삭제 칸 열고 닫기 (화면 동작만)
(function () {
	var parent   = document.getElementById('cmtParent');
	var replying = document.getElementById('cmtReplying');
	var toLabel  = document.getElementById('cmtReplyingTo');
	var delBox   = document.getElementById('cmtDelBox');
	var delId    = document.getElementById('cmtDelId');

	document.querySelectorAll('.cmt-act[data-reply]').forEach(function (b) {
		b.addEventListener('click', function () {
			var nick = this.closest('.cmt').querySelector('.cmt-nick').textContent.trim();
			parent.value = this.getAttribute('data-reply');
			toLabel.textContent = nick;
			replying.hidden = false;
			document.getElementById('cmtForm').scrollIntoView({behavior: 'smooth', block: 'center'});
		});
	});

	document.getElementById('cmtCancelReply').addEventListener('click', function () {
		parent.value = '';
		replying.hidden = true;
	});

	document.querySelectorAll('.cmt-act[data-del]').forEach(function (b) {
		b.addEventListener('click', function () {
			delId.value = this.getAttribute('data-del');
			delBox.hidden = false;
			this.closest('.cmt').after(delBox);
		});
	});

	document.getElementById('cmtDelCancel').addEventListener('click', function () {
		delBox.hidden = true;
	});
})();
</script>
