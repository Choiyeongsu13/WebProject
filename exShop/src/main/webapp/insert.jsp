<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<h2 class="title">인사관리 사원등록 화면</h2>
			<form>
				<table>
					<tr>
						<th colspan="2">인사관리 사원등록</th>
					</tr>	
					<tr>
						<th>사원번호(자동입력)</th>
						<td><input type="text" size="10" name=""></td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" size="20" name=""></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<input type="radio" name="">남자
							<input type="radio" name="">여자
						</td>
					</tr>
					<tr>
						<th>직책</th>
						<td><select name="" style="width:150px;">
								<option>상무</option>
								<option>부장</option>
								<option>과장</option>
								<option>대리</option>
								<option>사원</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<th>입사일자</th>
						<td><input type="text" name=""></td>
					</tr>
					<tr>
						<th>부서코드</th>
						<td>
							<input type="text" name=""></td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="submit" value="등록"> 
							<input type="button" value="취소">
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