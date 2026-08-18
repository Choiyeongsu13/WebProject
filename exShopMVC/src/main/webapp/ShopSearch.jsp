<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title> 회원정보검색</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px; }
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
 </head>
 <body>
	<%@include file="header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">회원정보검색</h2>
				<form name="tbl_member_001" id="form" method="get" action="${pageContext.request.contextPath}/Shop">
					<input type="hidden" name="cmd" value="ShopSearch">
					검색어 <input type="text" size="20" name="keyword">
					<input type="submit" value="검색">
				</form>
				<table>
					<tr>
						<th colspan="7">회원 정보 검색 결과</th>
					</tr>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>성별</th>
						<th>가입일</th>
						<th>고객등급</th>
						<th>거주구역</th>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
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
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Serivce of Korea</p>
		</footer>
	</div>
 </body>
</html>
