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
				<h2 class="title">성적 조회</h2>
				<table>
					<tr>
						<th>학년-반-번호</th>
						<th>이름</th>
						<th>성별</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
					</tr>
			<c:if test="${empty list}">		
					<tr>
						<td colspan="8">등록된 자료가 없음</td>
					</tr>
			</c:if>		
			<c:set var="tkor" value="0"/>
			<c:set var="teng" value="0"/>
			<c:set var="tmat" value="0"/>
			<c:forEach var="dto" items="${list}">
				<c:set var="tkor" value="${tkor + dto.kor }"/>
				<c:set var="teng" value="${teng + dto.eng }"/>
				<c:set var="tmat" value="${tmat + dto.mat }"/>
				<c:set var="tot" value="${(tkor + dto.kor) + (teng + dto.eng)+ (tmat + dto.mat)}"/>
					<tr>
						<td style="text-align:center">${dto.syear}-${dto.sclass}-${dto.sno}</td>
						<td class="tdtext">${dto.sname}</td>
						<td>${dto.gender=='M' ? "남자" : "여자"}</td>
						<td>${dto.kor}</td>
						<td>${dto.eng}</td>
						<td>${dto.mat}</td>
						<td>${dto.kor+dto.eng+dto.mat}</td>
					<!-- <td>${(dto.kor+dto.eng+dto.mat)/3.}</td>  -->
						<td><fmt:formatNumber pattern="#.00" value="${(dto.kor+dto.eng+dto.mat)/3.}"/></td>
					</tr>
			</c:forEach>	
				<tr>
					<td></td>
					<td></td>
					<td>학년총점</td>
					<td>${tkor}</td>
					<td>${teng}</td>
					<td>${tmat}</td>
					<td>${tkor + teng + tmat}</td>
					<td></td>	
				</tr>	
				<tr>
					<td></td>
					<td></td>
					<td>학년평균</td>
					<td><fmt:formatNumber pattern="#.00" value="${tkor/list.size()}"/></td>
					<td><fmt:formatNumber pattern="#.00" value="${teng/list.size()}"/></td>
					<td><fmt:formatNumber pattern="#.00" value="${tmat/list.size()}"/></td>
					<td><fmt:formatNumber pattern="#.00" value="${tot/3}"/></td>
					<td></td>	
				</tr>	
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