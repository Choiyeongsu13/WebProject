<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String gender = (String)request.getAttribute("gender");
	String fa = (String)request.getAttribute("fa");
	String job = (String)request.getAttribute("job");
	// "-" 기준으로 split 처리
	String tel[] = ((String)request.getAttribute("tel")).split("-");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 폼</title>
<style>
	table {
		width: 550px; 
		border: 1px solid black;
		border-collapse: collapse; 
		margin: 0 auto;
	}
	td {
		border: 1px solid black;
		padding: 5px; /* 5p -> 5px */
	}
	.title {
		font-size: 20px; 
		text-align: center;
	}
	.btn_group {
		text-align: center;
	}
</style>
</head>
<body>
	<h1 align="center">会員修正</h1>
	<form name="join" id="form" method="post" action="/join_modify.do">
		<table>
			<tr>
				<td width="100" align="center">名前</td>
				<td><input type="text" name="name" value="<%=name%>"></td>
			</tr>
			<tr>
				<td align="center">性別</td> 
				<td> 
					<input type="radio" name="gender" value="M" <%="M".equals(gender) ? "checked" : ""%>>남자 
					<input type="radio" name="gender" value="F" <%="F".equals(gender) ? "checked" : ""%>>여자
				</td>
			</tr>
			<tr>
				<td align="center">趣味</td>
				<td> 
					<input type="checkbox" name="fa" value="여행" <%=fa.contains("여행") ? "checked" : ""%>>여행
					<input type="checkbox" name="fa" value="영화" <%=fa.contains("영화") ? "checked" : ""%>>영화
					<input type="checkbox" name="fa" value="운동" <%=fa.contains("운동") ? "checked" : ""%>>운동
				</td>
			</tr>
			<tr>
				<td align="center">職業</td>
				<td> 
					<select name="job">
						<option> 직업선택 </option>
						<option value="학생" <%="학생".equals(job) ? "selected" : ""%>>학생</option>
						<option value="군인" <%="군인".equals(job) ? "selected" : ""%>>군인</option>
						<option value="교사" <%="교사".equals(job) ? "selected" : ""%>>교사</option>
						<option value="공무원" <%="공무원".equals(job) ? "selected" : ""%>>공무원</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">連絡先</td>
				<td>
					<select name="tel1">
						<option value="010" <%="010".equals(tel[0]) ? "selected" : ""%>>010</option> 
						<option value="061" <%="061".equals(tel[0]) ? "selected" : ""%>>061</option> 
						<option value="011" <%="011".equals(tel[0]) ? "selected" : ""%>>011</option>  
					</select> - 
					<input type="tel" name="tel2" value="<%=tel[1]%>" size="5"> - 
					<input type="tel" name="tel3" value="<%=tel[2]%>" size="5">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn_group" align="center">
					<input type="reset" value="리셋">
					<input type="button" value="수정" onClick="send()">
					<input type="button" value="취소" onClick="history.back()">
				</td>
			</tr>
		</table>
	</form>

	<script>
		function send() {
			if (!join.name.value) {
				alert("이름이 비어있음");
				join.name.focus();
				return;
			}
			if (!join.gender[0].checked && !join.gender[1].checked) {
				alert("성별 선택");
				return;
			}
			var flag = false;
			for (var i = 0; i < join.fa.length; i++) {
				if (join.fa[i].checked) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				alert("취미 선택");
				return;
			} 
			if (join.job.selectedIndex === 0) {
				alert("직업선택");
				join.job.focus();
				return;
			}
			join.submit();
		}
	</script>
</body>
</html>