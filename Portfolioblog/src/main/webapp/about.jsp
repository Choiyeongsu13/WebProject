<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/common/lang.jsp" %>
<c:set var="active"    value="about" />
<c:set var="pageTitle"><fmt:message key="title.about" /></c:set>
<c:set var="vLabel"    value="紹介" />
<%@ include file="/common/header.jsp" %>

<!-- ================= 프로필 ================= -->
<div class="section sp-5">
	<div class="profile">

		<div class="ph ph-avatar">
			<svg width="34" height="34" viewBox="0 0 24 24" fill="none" aria-hidden="true"><circle cx="12" cy="8" r="4" stroke="#1A1A18" stroke-width="1.2"/><path d="M4 20c0-4.4 3.6-7 8-7s8 2.6 8 7" stroke="#1A1A18" stroke-width="1.2" stroke-linecap="round"/></svg>
		</div>

		<div>
			<h1 class="profile-name">최영수</h1>
			<p class="profile-role">초보 개발자</p>
			<p class="profile-bio">목포대학교 융합소프트웨어학과에 재학중입니다. 재학중에는 주로 Python을 공부했고
			캡스톤 프로젝트에서 YOLO를 활용한 이미지 딥러닝, RAG를 활용한 챗봇을 담당했습니다.
			현재는 IT전문가 과정에서 자바를 공부하며 일본으로의 취업을 준비하고 있습니다.</p>
			<div class="profile-links">
				<a class="link-u" href="mailto:choiyeongsu0813@gmail.com">choiyeongsu0813@gmail.com</a>
				<a class="link-u-off" href="https://github.com/Choiyeongsu13" target="_blank" rel="noopener">GitHub</a>
			</div>
		</div>

	</div>
</div>

<!-- ================= 기술 ================= -->
<div class="section sp-4">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.stack" /></span>
		<div class="section-main skilltable">

			<div class="skillrow">
				<span class="skillrow-name"><fmt:message key="about.langs" /></span>
				<span class="skillrow-list">
					<span>Java / Python</span><span>JavaScript</span><span>HTML / CSS</span>
				</span>
			</div>

			<div class="skillrow">
				<span class="skillrow-name"><fmt:message key="about.backend" /></span>
				<span class="skillrow-list">
					<span>JSP</span><span>Servlet</span><span>JDBC</span><span>YOLO</span>
				</span>
			</div>

			<div class="skillrow">
				<span class="skillrow-name"><fmt:message key="about.db" /></span>
				<span class="skillrow-list">
					<span>OracleDB / MySQL</span>
				</span>
			</div>

			<div class="skillrow">
				<span class="skillrow-name"><fmt:message key="about.tools" /></span>
				<span class="skillrow-list">
					<span>VsCode /Eclipse</span><span>Git</span><span>Docker</span>
				</span>
			</div>

		</div>
	</div>
</div>

<!-- ================= 연혁 ================= -->
<div class="section sp-4">
	<div class="section-body">
		<span class="label section-label"><fmt:message key="label.history" /></span>
		<div class="section-main timeline">

			<div class="tl-item">
				<span class="tl-rail">
					<span class="tl-dot now"></span>
					<span class="tl-line"></span>
				</span>
				<span class="tl-body">
					<span class="tl-date" style="display:block;">[2021]</span>
					<span class="tl-title" style="display:block;">국립 목포대학교 융합소프트웨어</span>
					<span class="tl-desc" style="display:block;">C , Python, Java등을 공부했습니다.</span>
				</span>
			</div>

			<div class="tl-item">
				<span class="tl-rail">
					<span class="tl-dot"></span>
					<span class="tl-line"></span>
				</span>
				<span class="tl-body">
					<span class="tl-date" style="display:block;">[2026]</span>
					<span class="tl-title" style="display:block;">전라남도청년 해외지원사업 일본취업IT전문가과정</span>
					<span class="tl-desc" style="display:block;">Java 공부중</span>
				</span>
			</div>

			<div class="tl-item">
				<span class="tl-rail">
					<span class="tl-dot"></span>
				</span>
				<span class="tl-body" style="padding-bottom:0;">
					<span class="tl-date" style="display:block;">[기간]</span>
					<span class="tl-title" style="display:block;"><fmt:message key="about.intern" /></span>
					<span class="tl-desc" style="display:block;"><fmt:message key="about.intern.desc" /></span>
				</span>
			</div>

		</div>
	</div>
</div>


<%@ include file="/common/footer.jsp" %>
