<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>경연결과조회</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:rgb(0, 0, 0); padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:500px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">경연결과조회</h2>

				<form name="ScoreSearch" id="form" method="post" action="ScoreSearch">
				<table>
					<tr>
						<th>참가번호</th>
						<td style="text-align:center">
							<input type="text" size="10" name="entry_no" value="${entry_no}">
							<input type="button" value="결과조회" onClick="send()">
						</td>
					</tr>
				</table>
				</form>

				<c:if test="${not empty entry_no}">

					<c:choose>
						<c:when test="${not empty dto}">
						<table>
							<tr>
								<th>참가번호</th>
								<td style="text-align:center">${dto.tbl_entryDTO.entry_no}</td>
							</tr>
							<tr>
								<th>성명</th>
								<td style="text-align:center">
									${dto.tbl_entryDTO.entry_name}
									<c:choose>
										<c:when test="${fn:substring(dto.tbl_entryDTO.entry_jumin,6,7) == '1'}">(남)</c:when>
										<c:when test="${fn:substring(dto.tbl_entryDTO.entry_jumin,6,7) == '2'}">(여)</c:when>
									</c:choose>
								</td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td style="text-align:center">
									${fn:substring(dto.tbl_entryDTO.entry_jumin,0,2)}년
									${fn:substring(dto.tbl_entryDTO.entry_jumin,2,4)}월
									${fn:substring(dto.tbl_entryDTO.entry_jumin,4,6)}일
								</td>
							</tr>
							<tr>
								<th>참가부문</th>
								<td style="text-align:center">
									<c:choose>
										<c:when test="${dto.tbl_entryDTO.entry_type == '1'}">기악</c:when>
										<c:when test="${dto.tbl_entryDTO.entry_type == '2'}">민요</c:when>
										<c:when test="${dto.tbl_entryDTO.entry_type == '3'}">무용</c:when>
										<c:when test="${dto.tbl_entryDTO.entry_type == '4'}">판소리</c:when>
									</c:choose>
								</td>
							</tr>
							<tr>
								<th>지역</th>
								<td style="text-align:center">${dto.tbl_entryDTO.entry_area}</td>
							</tr>
							<tr>
								<th>${dto.tbl_refereeDTO.rname1}</th>
								<td style="text-align:center">${dto.tbl_recordDTO.score1}</td>
							</tr>
							<tr>
								<th>${dto.tbl_refereeDTO.rname2}</th>
								<td style="text-align:center">${dto.tbl_recordDTO.score2}</td>
							</tr>
							<tr>
								<th>${dto.tbl_refereeDTO.rname3}</th>
								<td style="text-align:center">${dto.tbl_recordDTO.score3}</td>
							</tr>
							<tr>
								<th>${dto.tbl_refereeDTO.rname4}</th>
								<td style="text-align:center">${dto.tbl_recordDTO.score4}</td>
							</tr>
							<tr>
								<th>${dto.tbl_refereeDTO.rname5}</th>
								<td style="text-align:center">${dto.tbl_recordDTO.score5}</td>
							</tr>
							<tr>
								<th>최대</th>
								<td style="text-align:center">${dto.tbl_recordDTO.s_max}</td>
							</tr>
							<tr>
								<th>최소</th>
								<td style="text-align:center">${dto.tbl_recordDTO.s_min}</td>
							</tr>
							<tr>
								<th>합계</th>
								<td style="text-align:center">${dto.tbl_recordDTO.s_tot}</td>
							</tr>
							<tr>
								<th>평균</th>
								<td style="text-align:center"><fmt:formatNumber value="${dto.tbl_recordDTO.s_ave}" pattern="0.00"/></td>
							</tr>
						</table>
						</c:when>

						<c:otherwise>
							<p style="text-align:center; padding:16px;">'${entry_no}' 경연점수가 존재하지 않습니다!</p>
						</c:otherwise>
					</c:choose>

					<p style="text-align:center; padding:16px;">
						<input type="button" value="돌아가기" onClick="goBack()">
					</p>

				</c:if>

			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources
			Development Serivce of Korea</p>
		</footer>
	</div>
</body>
<script>
	function send() {
		var frm = ScoreSearch;

		if (!frm.entry_no.value) {
			alert("참가번호가 입력되지 않았습니다!");
			frm.entry_no.focus();
			return;
		}

		frm.submit();
	}

	function goBack() {
		history.back();
	}
</script>
</html>