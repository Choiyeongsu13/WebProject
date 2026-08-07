<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>쇼핑몰 회원관리</title>
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
				<h2 class="title">인사관리 직원정보 조회 화면</h2>
				<table>
					<tr>
						<th colspan="7">직원 정보 조회 결과</th>
					</tr>
					<tr>
						<th>사원번호</th>
						<th>사원명</th>
						<th>직책</th>
						<th>연락처</th>
						<th>입사일자</th>
						<th>퇴사일자</th>
						<th>부서코드</th>
					</tr>
					<tr class="text_center">
						<td class="white">1001</td>
						<td>박민우</td>
						<td>상무</td>
						<td>010-1234-5678</td>
						<td>2017-02-03</td>
						<td></td>
						<td>01</td>
					</tr>
					<tr class="text_center">
						<td class="white"> ..</td>
						<td> . . </td>
						<td> . . </td>
						<td> . . </td>
						<td> . . </td>
						<td> . . </td>
						<td> . . </td>
					</tr>
					<tr class="text_center">
						<td class="white">1006</td>
						<td>이광주</td>
						<td>과장</td>
						<td>010-3333-1111</td>
						<td>2018-07-08</td>
						<td>2019-05-25</td>
						<td>04</td>
					</tr>
					<tr>
						<td colspan="7" class="btn_group">
							<input type="submit" value="확인">
						</td>
					</tr>
				</table>
			</div>
		</section>
	</div>
<!--  footer  -->
	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Serivce of Korea</p>
		</footer>
		
	</div>
</body>
</html>