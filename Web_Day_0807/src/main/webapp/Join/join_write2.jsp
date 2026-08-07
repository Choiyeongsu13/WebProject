<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<style>
	table {
		width: 550px; 
		border: 1px solid black;
		border-collapse: collapse; 
		margin: 0 auto;
	}
	td {
		border: 1px solid black;
		padding: 5px;
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
	<form name="join" id="form" method="post" action="../join_write.do">
		<h1 align="center">会員登録(서블릿)</h1>
			
		<table>
			<tr>
				<td width="100" align="center">名前</td>
				<td><input type="text" name="name" id="name" placeholder="이름을 입력하시오"></td>
			</tr>
			<tr>
				<td align="center">性別</td> 
				<td> 
					<input type="radio" name="gender" value="M">남자 
					<input type="radio" name="gender" value="F">여자
				</td>
			</tr>
			<tr>
				<td align="center">趣味</td>
				<td> 
					<input type="checkbox" name="fa" value="여행">여행
					<input type="checkbox" name="fa" value="영화">영화
					<input type="checkbox" name="fa" value="운동">운동
				</td>
			</tr>
			<tr>
				<td align="center">職業</td>
				<td> 
					<select name="job">
						<option value=""> 직업선택 </option>
						<option value="학생">학생</option>
						<option value="군인">군인</option>
						<option value="교사">교사</option>
						<option value="공무원">공무원</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center">連絡先</td>
				<td>
					<select name="tel1">
						<option value="010">010</option> 
						<option value="061">061</option> 
						<option value="011">011</option>  
					</select> - 
					<input type="tel" name="tel2" size="5"> - 
					<input type="tel" name="tel3" size="5">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btn_group" align="center">
					<input type="reset" value="리셋">
					<input type="button" value="등록" onClick="send()">
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
			
			
			var flag = 0;
			for (var i = 0; i < join.fa.length; i++) {
				if (join.fa[i].checked) {
					flag = 1;
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
			
			
			if (!join.tel2.value || !join.tel3.value) {
				alert("전화번호 입력");
				join.tel2.focus();
				return;
			}

			alert("등록을 진행합니다.");
			join.submit();
		}
	</script>
</body>
</html>