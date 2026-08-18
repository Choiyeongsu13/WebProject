<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:800px;margin:0 auto; border-collapse:collapse;}
	.content table th, .content table td{border:1px solid #bbb; padding:8px;}
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
				<h2 class="title">후보조회</h2>
				<table class="dayTable">
					<tr>
						<th>후보번호</th>
						<th>성명</th>
						<th>소속정당</th>
						<th>학력</th>
						<th>주민번호</th>
						<th>지역구</th>
						<th>대표전화</th>
					</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.m_no}</td>
						<td style="text-align:center">${dto.m_name}</td>
						<td style="text-align:center">${dto.p_name}</td>
						<td style="text-align:center">${dto.p_school}</td>
						<td style="text-align:center">${dto.m_jumin}</td>
						<td style="text-align:center">${dto.m_city}</td>
						<td style="text-align:center">${dto.p_tel1}-${dto.p_tel2}-${dto.p_tel3}</td>
					</tr>
			</c:forEach>
				</table>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2020 All rights reserved. Human Resources Development Service of Korea</p>
		</footer>
	</div>
</body>
</html>
