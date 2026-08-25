<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	댓글 영역 (티스토리 방식)

	사용법 : 글 상세 화면에서 본문 아래에 include 한다.
		<%@ include file="/common/comments.jsp" %>

	- 회원가입 없이 닉네임 + 비밀번호로 답니다.
	- 비밀번호는 지울 때 본인 확인용입니다. 반드시 해시로 저장하세요.
	- 지금은 화면만 있습니다. 아래 [연결 지점] 주석 자리에 DAO 를 붙이면 됩니다.
--%>

<section class="comments">

	<div class="cmt-head">
		<span class="label label-on"><fmt:message key="cmt.title" /></span>
		<%-- [연결 지점] 실제 댓글 수로 바꾸기
		     SELECT count(*) FROM post_comment WHERE post_id = ? AND is_deleted = 'N' --%>
		<span class="cmt-count">3<fmt:message key="cmt.count" /></span>
	</div>

	<div class="rule"></div>

	<!-- ================= 댓글 목록 ================= -->
	<%-- [연결 지점] 아래 세 덩어리를 반복문으로 바꾸기
	     SELECT comment_id, parent_id, nickname, content, is_secret, is_deleted, created_at
	       FROM post_comment
	      WHERE post_id = ?
	      ORDER BY NVL(parent_id, comment_id), created_at --%>
	<div class="cmt-list">

		<article class="cmt">
			<div class="cmt-meta">
				<span class="cmt-nick">지나가던개발자</span>
				<span class="cmt-date">2026.08.16</span>
			</div>
			<p class="cmt-body">try-with-resources 부분 도움 많이 됐습니다. 저도 예전에 커넥션 안 닫아서 고생했네요.</p>
			<div class="cmt-actions">
				<button type="button" class="cmt-act" data-reply="1"><fmt:message key="cmt.reply" /></button>
				<button type="button" class="cmt-act" data-del="1"><fmt:message key="cmt.delete" /></button>
			</div>
		</article>

		<!-- 대댓글 : parent_id 가 있는 댓글 -->
		<article class="cmt cmt-child">
			<div class="cmt-meta">
				<span class="cmt-nick">최영수 <span class="cmt-owner">·</span></span>
				<span class="cmt-date">2026.08.16</span>
			</div>
			<p class="cmt-body">읽어주셔서 감사합니다. ROWNUM 쪽도 한참 헤맸어요.</p>
			<div class="cmt-actions">
				<button type="button" class="cmt-act" data-del="2"><fmt:message key="cmt.delete" /></button>
			</div>
		</article>

		<article class="cmt">
			<div class="cmt-meta">
				<span class="cmt-nick">travel_lover</span>
				<span class="cmt-date">2026.08.14</span>
			</div>
			<p class="cmt-body">사진 분위기가 좋네요. 도톤보리는 밤에 가는 게 확실히 예쁜 것 같아요.</p>
			<div class="cmt-actions">
				<button type="button" class="cmt-act" data-reply="3"><fmt:message key="cmt.reply" /></button>
				<button type="button" class="cmt-act" data-del="3"><fmt:message key="cmt.delete" /></button>
			</div>
		</article>

	</div>

	<!-- ================= 댓글 쓰기 ================= -->
	<%-- [연결 지점] action 을 실제 서블릿 주소로 바꾸기 (예: commentWrite.do) --%>
	<form class="cmt-form" method="post" action="#" id="cmtForm">

		<input type="hidden" name="postId" value="1">
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
				<input type="checkbox" name="isSecret" value="Y">
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

	<!-- ================= 삭제 확인 ================= -->
	<%-- [연결 지점] 비밀번호를 서버로 보내 해시를 비교한 뒤 지웁니다.
	     화면에서 비밀번호를 검사하면 안 됩니다. --%>
	<div class="cmt-delbox" id="cmtDelBox" hidden>
		<form method="post" action="#">
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
