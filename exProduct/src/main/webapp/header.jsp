<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>물류창고 입출고 관리프로그램</title>
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
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
</head>
<body>
	<div class="header">
		<h1 class="logo">(과정평가형 정보처리산업기사)물류창고 입출고 관리프로그램  Ver 20019-06</h1>
		<div class="nav">
			<nav>
				<ul class="navi">
					<li><a href="/ProductList">제품조회</a></li>
					<li><a href="/InOpWrite">입출고등록</a></li>
					<li><a href="/InOpList">입출고내역조회</a></li>
					<li><a href="/OpSales">출고매출이익</a></li>
					<li><a href="/">홈으로</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>