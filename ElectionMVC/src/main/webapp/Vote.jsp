<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
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
				<h2 class="title">투표하기</h2>
				<form name="voteform" id="form" method="post" action="/Election?cmd=Vote">
				<table>
					<tr>
						<th>주민번호</th>
						<td><input type="text" size="20" name="v_jumin" placeholder="예)9901011000001"></td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" size="20" name="v_name"></td>
					</tr>
					<tr>
						<th>후보번호</th>
						<td>
							<select name="m_no" id="m_no">
								<option value="">후보번호</option>
								<c:forEach var="m" items="${list}">
									<option value="${m.m_no}">[${m.m_no}] ${m.m_name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>투표시간</th>
						<td><input type="text" size="20" name="v_time" ></td>
					</tr>
					<tr>
						<th>투표장소</th>
						<td><input type="text" size="20" name="v_area" ></td>
					</tr>
					<tr>
						<th>유권자확인</th>
						<td>
							<input type="radio" name="v_confirm" value="Y">확인
							<input type="radio" name="v_confirm" value="N">미확인
						</td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="투표하기" onclick="send()">
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
		

		if (!voteform.v_jumin.value) {
			alert("주민번호가 입력되지 않았습니다!");
			voteform.v_jumin.focus();
			return;
		}
		if (!voteform.v_name.value) {
			alert("성명이 입력되지 않았습니다!");
			voteform.v_name.focus();
			return;
		}
		if (!voteform.m_no.value) {
			alert("후보번호을 선택하세요!");
			voteform.m_no.focus();
			return;
		}
		if (!voteform.v_time.value) {
			alert("투표시간이 입력되지 않았습니다!");
			voteform.v_time.focus();
			return;
		}
		if (!voteform.v_area.value) {
			alert("투표장소가 입력되지 않았습니다!");
			voteform.v_area.focus();
			return;
		}

		var confirmChecked = false;
		for (var i = 0; i < voteform.v_confirm.length; i++) {
			if (voteform.v_confirm[i].checked) {
				confirmChecked = true;
			}
		}
		if (!confirmChecked) {
			alert("유권자확인을 선택하세요!");
			return;
		}

		voteform.submit();
		alert("투표완료");
	}

	function Reset() {
		if (confirm("정보를 지우고 처음부터 다시 입력 합니다")) {
			voteform.reset();
			voteform.v_jumin.focus();
		}
	}

	<c:if test="${regResult == 'success'}">
	alert("투표하기 정보가 정상적으로 등록되었습니다!");
	location.href = "/";
	</c:if>
</script>
</body>
</html>
