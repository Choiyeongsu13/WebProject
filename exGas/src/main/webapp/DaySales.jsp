<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일 매출통계</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">일 매출통계</h2>
				<table class="dayTable">
					<tr>
						<th>주유일자</th>
						<th>유종</th>
						<th>건수</th>
						<th>금액합계</th>
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="4">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>	<td style="text-align:center">${fn:substring(dto.oildate,0,4)}년 ${fn:substring(dto.oildate,4,6)}월 ${fn:substring(dto.oildate,6,8)}일</td>
						<td style="text-align:center">${dto.oilname}</td>
						<td style="text-align:center">${dto.cnt}</td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.totalCost}" pattern="#,##0"/></td>
					</tr>
			</c:forEach>
				</table>
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