<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="home" />
<c:set var="pageTitle"><fmt:message key="title.home" /></c:set>
<c:set var="vLabel"    value="ポートフォリオ" />
<%@ include file="/common/header.jsp" %>

<!-- ================= 히어로 ================= -->
<div class="hero">

	<div class="hero-top">
		<span class="seal"></span>
		<h1 class="hero-title"><fmt:message key="hero.greeting" /></h1>
	</div>

	<p class="hero-lead hero-indent"><fmt:message key="hero.lead" /></p>

	<div class="hero-actions hero-indent">
		<a class="link-u" href="${ctx}/projects.jsp"><fmt:message key="hero.cta1" /></a>
		<a class="link-u-off" href="${ctx}/posts.jsp"><fmt:message key="hero.cta2" /></a>
	</div>

</div>

<!-- ================= 기술 ================= -->
<div class="section sp-6">
	<div class="rule"></div>
	<div class="section-body" style="padding-top:26px;">
		<span class="label section-label" style="padding-top:0;"><fmt:message key="label.stack" /></span>
		<div class="section-main stackrow">
			<span>Java / Python</span>
			<span>JSP / Servlet / YOLO</span>
			<span>Oracle</span>
			<span>JavaScript</span>
			<span>Git</span>
		</div>
	</div>
</div>

<!-- ================= 작업 ================= -->
<div class="section sp-3">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.works" /></span>

		<div class="section-main worklist">

			<div class="rule"></div>
			<a class="work" href="${ctx}/projects.jsp">
				<span class="work-no">01</span>
				<span class="work-main">
					<span class="work-title" style="display:block;">[프로젝트명]</span>
					<span class="work-desc" style="display:block;">${isJa ? 'JSP と Oracle でつくった学内コミュニティサービス。4人チームで画面開発を担当しました。' : 'JSP와 Oracle로 만든 학내 커뮤니티 서비스. 4인 팀에서 화면 개발을 담당했습니다.'}</span>
				</span>
				<span class="work-tech">JSP · ORACLE</span>
			</a>

			<div class="rule"></div>
			<a class="work" href="${ctx}/projects.jsp">
				<span class="work-no">02</span>
				<span class="work-main">
					<span class="work-title" style="display:block;">${isJa ? '選挙結果の照会' : '선거 결과 조회'}</span>
					<span class="work-desc" style="display:block;">${isJa ? 'Model2 MVC パターンで実装した選挙データ照会アプリケーション。' : 'Model2 MVC 패턴으로 구현한 선거 데이터 조회 웹 애플리케이션.'}</span>
				</span>
				<span class="work-tech">SERVLET · MVC</span>
			</a>

			<div class="rule"></div>
			<a class="work" href="${ctx}/projects.jsp">
				<span class="work-no">03</span>
				<span class="work-main">
					<span class="work-title" style="display:block;">${isJa ? 'ポートフォリオブログ' : '포트폴리오 블로그'}</span>
					<span class="work-desc" style="display:block;">${isJa ? 'いまご覧いただいているこのサイトを、自分で設計して実装しました。' : '지금 보고 계신 이 사이트를 직접 설계하고 구현했습니다.'}</span>
				</span>
				<span class="work-tech">JSP · MVC</span>
			</a>
			<div class="rule"></div>

		</div>
	</div>
</div>

<!-- ================= 글 ================= -->
<div class="section sp-3">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.journal" /></span>

		<div class="section-main journal">

			<div>
				<div class="journal-head">
					<span class="journal-dash"></span>
					<span class="label label-on"><fmt:message key="cat.tech" /></span>
				</div>
				<div class="postlist">
					<a href="${ctx}/post.jsp">
						<span class="post-title" style="display:block;">JSP 프로젝트에서 DAO 패턴 정리하기</span>
						<span class="post-date">2026.08.10</span>
					</a>
					<a href="${ctx}/post.jsp">
						<span class="post-title" style="display:block;">Oracle 연동하며 겪은 커넥션 관리 문제</span>
						<span class="post-date">2026.07.28</span>
					</a>
				</div>
			</div>

			<div>
				<div class="journal-head">
					<span class="journal-dash soft"></span>
					<span class="label"><fmt:message key="cat.travel" /></span>
				</div>
				<div class="postlist">
					<a href="${ctx}/travel.jsp">
						<span class="post-title" style="display:block;">오사카에서 보낸 나흘</span>
						<span class="post-date">2026.07.22</span>
					</a>
					<a href="${ctx}/travel.jsp">
						<span class="post-title" style="display:block;">종강 후 떠난 교토 벚꽃 산책</span>
						<span class="post-date">2026.04.05</span>
					</a>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="/common/footer.jsp" %>
