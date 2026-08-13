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
				<h2 class="title">주식 종목 조회</h2>
				<table>
					<tr>
						<th>종목코드</th>
						<th>주식이름</th>
						<th>종목시장</th>
						<th>업종</th>
						<th>상장일</th>
					</tr>
			<c:if test="${empty list}">		
					<tr>
						<td colspan="8">등록된 자료가 없음</td>
					</tr>
			</c:if>		
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.stock_item_code}</td>
						<td style="text-align:center">${dto.stock_item_name}</td>
						<td style="text-align:center">${dto.stock_item_market}</td>
						<td style="text-align:center">${dto.stock_item_category}</td>
						<td style="text-align:center">${dto.stock_item_listed_date}</td>
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