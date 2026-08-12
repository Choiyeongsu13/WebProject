<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반별통계</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px; }
	.title {text-align:center;padding:22px;}
	.content table{width:500px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
 <%@include file ="header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">반 별 통계</h2>
			<form name="tbl_student_001" id="form" method="post" action="<%= request.getContextPath() %>/classTotal.do">
				<table>
					<tr>
						<th colspan="20" >반 별 통계</th>
					</tr>
					<tr>
						<th >학년</th>
						<th>반</th>
						<th>교사명</th>
						<th>국어총점</th>
						<th>영어총점</th>
						<th>수학총점</th>
						<th>국어평균</th>
						<th>영어평균</th>
						<th>수학평균</th>
					</tr>
				<c:if test="${empty list}">
					<tr>
						<td colspan="9">등록된 자료가 없음</td>
					</tr>
				</c:if>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.tbl_dept.syear}</td>
						<td>${dto.tbl_dept.sclass}</td>
						<td>${dto.tbl_dept.tname}</td>
						<td>${dto.tbl_score.kor}</td>
						<td>${dto.tbl_score.eng}</td>
						<td>${dto.tbl_score.mat}</td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.korAvg}"/></td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.engAvg}"/></td>
						<td><fmt:formatNumber pattern="#.00" value="${dto.matAvg}"/></td>
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
<script >



</script>
</html>

