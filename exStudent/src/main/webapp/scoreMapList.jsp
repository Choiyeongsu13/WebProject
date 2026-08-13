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
			<c:if test="${empty map}">		
					<tr>
						<td colspan="8">등록된 자료가 없음</td>
					</tr>
			</c:if>		
			<c:set var="tkor" value="0"/>
			<c:set var="teng" value="0"/>
			<c:set var="tmat" value="0"/>
			<c:forEach var="map" items="${map}">
				<c:set var="tkor" value="${tkor + map.value.kor }"/>
					<tr>
						<td style="text-align:center">${map.key.syear}-${map.key.sclass}-${map.key.sno}</td>
						<td class="tdtext">${map.key.sname}</td>
						<td>${map.key.gender=='M' ? "남자" : "여자"}</td>
						<td>${map.value.kor}</td>
						<td>${map.value.eng}</td>
						<td>${map.value.mat}</td>
						<td>${map.value.kor+map.value.eng+map.value.mat}</td>
					<!-- <td>${(dto.value.kor+dto.value.eng+dto.value.mat)/3.}</td>  -->
						<td><fmt:formatNumber pattern="#.00" value="${(map.value.kor+map.value.eng+map.value.mat)/3.}"/></td>
					</tr>
			</c:forEach>	
				<tr>
					<td></td>
					<td></td>
					<td>학년총점</td>
					<td>${tkor}</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>	
				</tr>	
				<tr>
					<td></td>
					<td></td>
					<td>학년평균</td>
					<td><fmt:formatNumber pattern="#.00" value="${tkor/map.size()}"/></td>
					<td></td>
					<td></td>
					<td></td>
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