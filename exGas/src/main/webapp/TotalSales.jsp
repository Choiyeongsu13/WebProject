<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체매출조회</title>
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
			<form name="TotalSales" id="form" method ="post" action="TotalSales">
				<h2 class="title">전체매출조회</h2>
				<table class="saleTable">

					<tr>
						<th>매출번호</th>
						<th>주유일자</th>
						<th>유종</th>
						<th>주유량</th>
						<th>결제방법</th>
						<th>회원성명</th>
						<th>회원번호</th>
						<th>전화번호</th>
						<th>카드번호</th>
						<th>금액</th>
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="10">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>		<td style="text-align:center">${dto.saleno}</td>
						<td style="text-align:center">${fn:substring(dto.oildate,0,4)}년 ${fn:substring(dto.oildate,4,6)}월 ${fn:substring(dto.oildate,6,8)}일</td>
						<td style="text-align:center">${dto.oiltype}</td>
						<td style="text-align:center">${dto.amount}</td>
						<td style="text-align:center">${dto.paytype}</td>
						<td style="text-align:center">${dto.custname }</td>
						<td style="text-align:center">${dto.custno}</td>
						<td style="text-align:center">${dto.custtel1}-${dto.custtel2}-${dto.custtel3}</td>
						<td style="text-align:center">${dto.creditcart}</td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.oilcost}" pattern="#,##0"/></td>
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