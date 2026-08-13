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
				<h2 class="title">제품 조회</h2>
				<table>
					<tr>
						<th>제품코드</th>
						<th>제품명</th>
						<th>사이즈</th>
						<th>매입단가</th>
						<th>출고단가</th>
					</tr>
			<c:if test="${empty list}">		
					<tr>
						<td colspan="8">등록된 자료가 없음</td>
					</tr>
			</c:if>		
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.tbl_product.p_code}</td>
						<td style="text-align:center">${dto.tbl_product.p_name}</td>
						<td style="text-align:center">${dto.tbl_product.p_size}mm</td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.tbl_product.p_incost}" pattern="#,##0"/></td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.tbl_product.p_outcost}" pattern="#,##0"/></td>
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