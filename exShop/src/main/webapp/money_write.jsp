<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.time.*" %>
<%
	int saleno = (int) request.getAttribute("saleno");

	
	LocalDate date = LocalDate.now();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 매출 정보 등록</title>
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
				<h2 class="title">회원 매출 정보 등록</h2>
			<form name="tbl_money_001" id="form" method="post" action="/money_write">
				<table>
					<tr>
						<th>판매번호</th>
						<td><input type="text" size="10" name="saleno" value="<%= saleno+1 %>" readonly></td>
					</tr>
					<tr>
						<th>회원번호</th>
						<td><input type="text"  name="custno"></td>
					</tr>
					<tr>
						<th>상품코드</th>
						<td><input type="text"  name="pcode"></td>
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="text" name="amount"></td>
					</tr>
					<tr>
						<th>판매일자</th>
						<td><input type="text"  name="sdate" value="<%= date %>"></td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="등록하기" onClick="send()">
							<input type="button" value="다시쓰기" onClick="rewrite()">
						</td>
					</tr>
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
