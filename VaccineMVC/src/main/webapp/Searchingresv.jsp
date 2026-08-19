<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>접종예약조회</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:800px;margin:0 auto; border-collapse:collapse;}
	.content table th, .content table td{border:1px solid #bbb; padding:8px;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}

		.content .saleTable{width:1450px; margin:0 auto; table-layout:fixed;}
	.content .saleTable th, .content .saleTable td{word-break:keep-all; padding:10px 6px;}
	
</style>
</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">접종예약조회</h2>
						<form name="Searchform" id="form" method="post" action="/Searchresv?cmd=Searchresv">
				<table class="dayTable">
					<tr>
						<th>예약번호를 입력하시오</th>
						<td style="text-align:center"><input type="text" size="20" name="resvno" ></td>
					</tr>
								<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="예약조회" onclick="send()">
							<input type="button" value="홈으로" onclick="back()">
						</td>
					</tr>
				</table>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2020 All rights reserved. Human Resources Development Service of Korea</p>
		</footer>
	</div>
		<script>
function send(){
	if (!Searchform.resvno.value) {
		alert("예약번호가 입력되지 않았습니다!");
		Searchform.resvno.focus();
		return;
	}

	Searchform.submit();
	}

function back() {
	location.href = "/";
}
	</script>
</body>
</html>
