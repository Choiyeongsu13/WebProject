<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>지역구의원투표 프로그램</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:rgb(0, 0, 0); padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px;}
	.title {text-align:center;padding:22px;}
	.content table{width:1000px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:rgb(0, 0, 0);}
</style>
</head>
<body>
	<div class="header">
		<h1 class="logo">(과정평가형 정보처리산업기사)지역구의원투표 프로그램  Ver 2009-06</h1>
		<div class="nav">
			<nav>
				<ul class="navi">
					<li><a href="/Election?cmd=Search">후보조회</a></li>
					<li><a href="/Election?cmd=Vote">투표하기</a></li>
					<li><a href="/Election?cmd=VoteList">투표검수조회</a></li>
					<li><a href="/Election?cmd=Score">후보자등수</a></li>
					<li><a href="/">홈으로</a></li>
				</ul>
				
			</nav>
		</div>
	</div>
</body>
</html>