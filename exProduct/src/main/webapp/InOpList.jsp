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
			<form name="InOpList" id="form" method ="post" action="InOpList">
				<h2 class="title">입출고 내역조회</h2>
				<table>
					<tr>
						<th>입출고번호</th>
						<th>제품코드</th>
						<th>제품명</th>
						<th>입출고구분</th>
						<!-- 입출고 구분이 I:입고, O:출고가 나타나도록 한다 -->
						<th>수량</th>
						<th>거래처</th>
						<th>거래일자</th>
						<!-- 거래일자는 yyyy-mm-dd로 표시한다. -->
					</tr>
			<c:if test="${empty list}">
					<tr>
							<td colspan="7">등록된 자료가 없음</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${list}">
				<tr>
						<td style="text-align:center">${dto.tbl_inout.t_no}</td>
						<td style="text-align:center">${dto.tbl_inout.p_code}</td>
						<td style="text-align:center">${dto.tbl_product.p_name}</td>
						<td style="text-align:center">${dto.tbl_inout.t_type == 'I' ? '입고' : '출고'}</td>
						<td style="text-align:right">${dto.tbl_inout.t_cnt}</td>
						<td style="text-align:center">
							<c:choose>
								<c:when test="${dto.tbl_inout.c_code == '10'}">서울공장</c:when>
								<c:when test="${dto.tbl_inout.c_code == '20'}">울산공장</c:when>
								<c:when test="${dto.tbl_inout.c_code == '30'}">부산상사</c:when>
								<c:when test="${dto.tbl_inout.c_code == '40'}">광주상사</c:when>
								<c:when test="${dto.tbl_inout.c_code == '50'}">대전상사</c:when>
								<c:otherwise>${dto.tbl_inout.c_code}</c:otherwise>
							</c:choose>
						</td>
						<td style="text-align:center">${dto.tbl_inout.t_date}</td>
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
