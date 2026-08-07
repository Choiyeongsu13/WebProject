<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
			<h1 class="logo">인사관리 시스템  Ver 2.0</h1>
			<div class="nav">
				<nav>
					<ul class="navi">
						<li><a href="list.jsp">조회</a></li>
						<li><a href="insert.jsp">사원등록</a></li>
						<li><a href="">정보변경</a></li>
						<li><a href="">부서별 사원현황</a></li>
						<li><a href="">퇴사처리</a></li>
						<li><a href="index.jsp">홈으로</a></li>
					</ul>
				</nav>			
			</div>
		</header>
	</div>
</body>
</html>