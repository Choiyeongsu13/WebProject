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
				<h2 class="title">출고매출이익</h2>
				<table>
					<tr>
						<th>제품코드</th>
						<th>제품명</th>
						<th>출고수량</th>
						<th>출고매출이익</th>
						<!--     ① 제품별 출고수량합계
    ② 출고매출이익 = 제품별 출고수량 *
                             (제품별 출고단가-제품별 입고단가)
   ② 출고매출이익은 화폐단위와 3자리마다 (,)를 표시되도록 출력하시오
       ③ 출고매출이익은 오른쪽으로 정렬되어 출력하시오 -->
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="4">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.tbl_product.p_code}</td>
						<td style="text-align:center">${dto.tbl_product.p_name}</td>
						<td style="text-align:right">${dto.tbl_inout.t_cnt}</td>
						<td style="text-align:right">￦<fmt:formatNumber value="${dto.tbl_product.profit}" pattern="#,##0"/></td>
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
