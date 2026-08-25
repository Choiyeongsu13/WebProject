<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="journal" />
<c:set var="pageTitle" value="JSP 프로젝트에서 DAO 패턴 정리하기" />
<c:set var="vLabel"    value="記録" />
<%@ include file="/common/header.jsp" %>

<article class="article">
	<div class="article-inner">

		<span class="label"><fmt:message key="cat.tech" /> · 2026.08.15</span>

		<h1 class="article-title">JSP 프로젝트에서<br>DAO 패턴 정리하기</h1>

		<div class="byline">
			<span class="ph" style="width:34px;height:34px;border-radius:50%;">
				<svg width="15" height="15" viewBox="0 0 24 24" fill="none" aria-hidden="true"><circle cx="12" cy="8" r="4" stroke="#1A1A18" stroke-width="1.3"/><path d="M4 20c0-4.4 3.6-7 8-7s8 2.6 8 7" stroke="#1A1A18" stroke-width="1.3" stroke-linecap="round"/></svg>
			</span>
			<span>
				<span class="byline-name" style="display:block;">최영수</span>
				<span class="byline-meta">6 <fmt:message key="journal.min" /></span>
			</span>
		</div>

<c:if test="${isJa}">
		<p class="kr-note"><fmt:message key="note.kronly" /></p>
</c:if>

		<div class="prose">

			<p>학과 팀 프로젝트를 진행하면서 JSP 안에 SQL이 그대로 들어가 있는 코드를 마주쳤습니다. 이 글에서는 그 코드를 DAO로 분리한 과정을 정리해봅니다.</p>

			<h2>문제 상황</h2>
			<p>처음에는 화면을 빨리 만드는 게 급해서 JSP 스크립틀릿 안에 <code>Connection</code>과 <code>PreparedStatement</code>를 직접 열었습니다. 화면이 늘어나자 같은 SQL이 여러 파일에 복사되었고, 컬럼 하나를 바꾸는 데도 파일을 전부 뒤져야 했습니다.</p>

			<h2>해결 과정</h2>
			<p>DB 접근 코드를 DAO 클래스로 옮기고, 결과를 담을 DTO를 따로 만들었습니다. JSP는 DAO가 돌려준 값을 화면에 뿌리는 역할만 하게 됩니다.</p>

			<div class="codeblock">
<pre><span class="tok-comment">// PostDAO.java</span>
<span class="tok-keyword">public</span> List&lt;PostDTO&gt; selectRecentPosts(<span class="tok-keyword">int</span> limit) {
    List&lt;PostDTO&gt; list = <span class="tok-keyword">new</span> ArrayList&lt;&gt;();
    String sql = <span class="tok-string">"SELECT * FROM ("</span>
               + <span class="tok-string">"  SELECT * FROM post ORDER BY created_at DESC"</span>
               + <span class="tok-string">") WHERE ROWNUM &lt;= ?"</span>;

    <span class="tok-keyword">try</span> (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, limit);
        <span class="tok-keyword">try</span> (ResultSet rs = pstmt.executeQuery()) {
            <span class="tok-keyword">while</span> (rs.next()) {
                list.add(mapRow(rs));
            }
        }
    } <span class="tok-keyword">catch</span> (SQLException e) {
        e.printStackTrace();
    }
    <span class="tok-keyword">return</span> list;
}</pre>
			</div>

			<p>try-with-resources를 쓰면 <code>close()</code>를 빠뜨려서 커넥션이 새는 문제도 함께 막을 수 있었습니다. Oracle에서 상위 N건을 가져올 때 <code>ROWNUM</code>을 바로 <code>ORDER BY</code>와 같이 쓰면 정렬 전에 잘려버려서, 서브쿼리로 감싸야 한다는 것도 이때 알게 됐습니다.</p>

			<h2>배운 점</h2>
			<p>화면과 데이터 접근을 나누는 것만으로도 수정할 곳이 명확해졌습니다. 다음 프로젝트에서는 처음부터 DAO와 DTO를 먼저 잡고 시작해보려 합니다.</p>

		</div>

		<div class="article-tags">
			<span>JSP</span>
			<span>ORACLE</span>
			<span>DAO</span>
		</div>

		<section class="related">
			<span class="label" style="display:block;margin-bottom:8px;"><fmt:message key="journal.more" /></span>
			<div class="rule"></div>
			<a class="related-item" href="${ctx}/post.jsp">
				<span class="related-name">Oracle 연동하며 겪은 커넥션 관리 문제</span>
				<span class="related-date">2026.07.28</span>
			</a>
			<div class="rule-soft"></div>
			<a class="related-item" href="${ctx}/post.jsp">
				<span class="related-name">Model2 MVC 패턴으로 게시판 다시 만들기</span>
				<span class="related-date">2026.06.02</span>
			</a>
			<div class="rule"></div>
		</section>

		<%@ include file="/common/comments.jsp" %>

	</div>
</article>

<%@ include file="/common/footer.jsp" %>
