<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>경연점수등록</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:rgb(0, 0, 0); padding:16px 0;}
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
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">경연점수등록</h2>
				<form name="ScoreWrite" id="form" method="post" action="ScoreWrite2">
				<table>

					<tr>
						<th>참가번호</th>
						<td style="text-align:center"><input type="text" size="10" name="entry_no" value="${dto.entry_no}">예)0001</td>
					</tr>
					<tr>
						<th>심사위원</th>
						<td style="text-align:center">심사점수(1~100)</td>
					</tr>
					<tr>
						<th>김심사</th>
						<td style="text-align:center"><input type="text" size="10" name="score" value="${dto.score[0]}">점</td>
					</tr>
					<tr>
						<th>이심사</th>
						<td style="text-align:center"><input type="text" size="10" name="score" value="${dto.score[1]}">점</td>
					</tr>
					<tr>
						<th>박심사</th>
						<td style="text-align:center"><input type="text" size="10" name="score" value="${dto.score[2]}">점</td>
					</tr>

					<tr>
						<th>황심사</th>
						<td style="text-align:center"><input type="text" size="10" name="score" value="${dto.score[3]}">점</td>
					</tr>
					<tr>
						<th>조심사</th>
						<td style="text-align:center"><input type="text" size="10" name="score" value="${dto.score[4]}">점</td>
					</tr>

					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="등록" onClick="send()">
							<input type="reset" value="다시쓰기" onClick="rewrite()">
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
<script>
	function send() {
		var frm = ScoreWrite;

		if (!frm.entry_no.value) {
			alert("참가번호가 입력되지 않았습니다!");
			frm.entry_no.focus();
			return;
		}

		var scores = document.getElementsByName("score");
		for (var i = 0; i < scores.length; i++) {
			if (!scores[i].value) {
				alert("심사위원 점수가 입력되지 않았습니다!");
				scores[i].focus();
				return;
			}
		}

		alert("경연점수정보가 등록되었습니다!");
		frm.submit();
	}

	function rewrite() {
		if (confirm("정보를 지우고 처음부터 다시 입력 합니다")) {
			ScoreWrite.reset();
			ScoreWrite.entry_no.focus();
		}
	}
</script>
</html>