<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접종예약조회</title>
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
				<h2 class="title">접종예약조회</h2>
			<table class="resv">
					<tr>
						<th>이름</th>
						<th>주민번호</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>예약일자</th>
						<th>예약시간</th>
						<th>병원명</th>
						<th>대표전화</th>
						<th>병원주소</th>
						<th>백신종류</th>
					</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.pname}</td>
						<td style="text-align:center">${dto.jumin}</td>
						<td style="text-align:center">${dto.gender}</td>
						<td style="text-align:center">${dto.tel}</td>
						<td style="text-align:center">${dto.resvdate}</td>
						<td style="text-align:center">${dto.resvyime}</td>
						<td style="text-align:center">${dto.hospname}</td>
						<td style="text-align:center">${dto.hosptel}</td>
						<td style="text-align:center">${dto.hospaddr}</td>
						<td style="text-align:center">${dto.vname}</td>
					</tr>
			</c:forEach>
						
				</table>
					<td colspan="2" class="btn_group">
				    <input type="button" value="돌아가기" onclick="back()" style="display: block; margin: 0 auto;">
				</td>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2020 All rights reserved. Human Resources Development Service of Korea</p>
		</footer>
	</div>
	<script>
	function back(){
		history.back();
	}
	
	</script>

</body>
</html>
