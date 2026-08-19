<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>백신접종예약</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:500px;margin:0 auto;}
	.content table th, .content table td{border:1px solid #bbb; padding:6px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">백신접종예약</h2>
				<form name="Vaccresvform" id="form" method="post" action="/Vaccresv?cmd=Vaccresv">
				<table>
					<tr>
						<th>접종예약번호</th>
						<td><input type="text" size="20" name="resvno" >예)20210001</td>
					</tr>
					<tr>
						<th>주민번호</th>
						<td><input type="text" size="20" name="jumin" >예)710101 - 1000001</td>
					</tr>
					<tr>
						<th>백신코드</th>
						<td><input type="text" size="20" name="vcode" >예)V001 ~ V003</td>
					</tr>
					<tr>
						<th>병원코드</th>
						<td><input type="text" size="20" name="hospcode">예)H001</td>
					</tr>
			
					<tr>
						<th>예약일자</th>
						<td><input type="text" size="20" name="resvdate" >예)20211231</td>
					</tr>
			
					<tr>
						<th>예약시간</th>
						<td><input type="text" size="20" name="resvyime" >예)1230"</td>
					</tr>
			
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="등록" onclick="send()">
							<input type="button" value="다시쓰기" onclick="Reset()">
						</td>
					</tr>
				</table>
				</form>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2020 All rights reserved. Human Resources Development Service of Korea</p>
		</footer>
	</div>

<script>
	function send() {
		

		if (!Vaccresvform.resvno.value) {
			alert("접종예약번호 입력되지 않았습니다!");
			Vaccresvform.resvno.focus();
			return;
		}
		if (!Vaccresvform.jumin.value) {
			alert("주민번호가 입력되지 않았습니다!");
			Vaccresvform.jumin.focus();
			return;
		}
		if (!Vaccresvform.vcode.value) {
			alert("백신코드가 입력되지 않았습니다1");
			Vaccresvform.jumin.focus();
			return;
		}
		if (!Vaccresvform.hospcode.value) {
			alert("병원코드가 입력되지 않았습니다!");
			Vaccresvform.hospcode.focus();
			return;
		}
		if (!Vaccresvform.resvdate.value) {
			alert("예약일자가 입력되지 않았습니다!");
			Vaccresvform.resvdate.focus();
			return;
		}
		if (!Vaccresvform.resvyime.value) {
			alert("예약시간이 입력되지 않았습니다!");
			Vaccresvform.resvyime.focus();
			return;
		}

		Vaccresvform.submit();
		alert("접종예약정보가 등록되었습니다!");
	}

	function Reset() {
		if (confirm("정보를 지우고 처음부터 다시 입력 합니다")) {
			Vaccresvform.reset();
		}
	}
</script>
</body>
</html>
