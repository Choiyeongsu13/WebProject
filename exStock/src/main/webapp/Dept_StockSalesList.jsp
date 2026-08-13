<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	.tdtext{text-align:center}
</style>

<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
			<form name="OpSales" id="form" method ="post" action="OpSales">
				<h2 class="title">부서별 주식매수 통계</h2>
				<table>
					<tr>
						<th>부서코드</th>
						<th>부서명</th>
						<th>총매수주식수</th>
						<th>총매수주식금액</th>
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="4">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.dept_code}</td>
						<td style="text-align:center">${dto.dept_name}</td>
						<td style="text-align:right"><fmt:formatNumber value="${dto.total_number}" pattern="#,##0"/></td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.total_amount}" pattern="#,##0"/></td>
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
