<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
			<form name="InOpList" id="form" method ="post" action="InOpList">
				<h2 class="title">주식 매수 내역조회</h2>
				<table>
					<tr>
						<th>매수일자</th>
						<th>종목번호</th>
						<th>종목명</th>
						<th>매수수량</th>
						<th>매수가격</th>
						<th>부서명</th>
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="6">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${fn:substring(dto.buy_date,0,4)}년 ${fn:substring(dto.buy_date,4,6)}월 ${fn:substring(dto.buy_date,6,8)}일</td>
						<td style="text-align:center">${dto.stock_item_code}</td>
						<td style="text-align:center">${dto.stock_item_name}</td>
						<td style="text-align:right"><fmt:formatNumber value="${dto.buy_number}" pattern="#,##0"/></td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.buy_price}" pattern="#,##0"/></td>
						<td style="text-align:center">${dto.dept_name}</td>
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
