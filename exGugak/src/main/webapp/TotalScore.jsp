<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최종등수조회</title>
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

	.content .saleTable{width:1450px; margin:0 auto; table-layout:fixed;}
	.content .saleTable th, .content .saleTable td{word-break:keep-all; padding:10px 6px;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
			<form name="TotalScore" id="form" method ="post" action="TotalScore">
				<h2 class="title">최종등수조회</h2>
				<table class="saleTable">

					<tr>
						<th>참가번호</th>
						<th>성명</th>
						<th>생년월일</th>
						<th>참가부문</th>
						<th>지역</th>
						<th>총점</th>
						<th>평균</th>
						<th>등수</th>
					</tr>
	
			<c:forEach var="dto" items="${list}">
				<tr>		<td style="text-align:center">${dto.tbl_entryDTO.entry_no}</td>
					
						<td style="text-align:center">${dto.tbl_entryDTO.entry_name}
						<c:choose>
							<c:when test="${fn:substring(dto.tbl_entryDTO.entry_jumin,6,7) == '1'}">(남)</c:when>
							<c:when test="${fn:substring(dto.tbl_entryDTO.entry_jumin,6,7) == '2'}">(여)</c:when>
						</c:choose>
						</td>
						<td style="text-align:center">${fn:substring(dto.tbl_entryDTO.entry_jumin,0,2)}년 
						${fn:substring(dto.tbl_entryDTO.entry_jumin,2,4)}월
						${fn:substring(dto.tbl_entryDTO.entry_jumin,4,6)}일 </td>
						<td style="text-align:center">
						<c:choose>
							<c:when test="${dto.tbl_entryDTO.entry_type == '1'}">기악</c:when>
							<c:when test="${dto.tbl_entryDTO.entry_type == '2'}">민요</c:when>
							<c:when test="${dto.tbl_entryDTO.entry_type == '3'}">무용</c:when>
							<c:when test="${dto.tbl_entryDTO.entry_type == '4'}">판소리</c:when>
						</c:choose>
						</td>
						<td style="text-align:center">${dto.tbl_entryDTO.entry_area}</td>
						<td style="text-align:center">${dto.tbl_recordDTO.s_tot}</td>
						<td style="text-align:center">${dto.tbl_recordDTO.s_ave}</td>
					</tr>
			</c:forEach>
				</table>
			</form>
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
</html>