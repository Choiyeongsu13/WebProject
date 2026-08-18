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
				<h2 class="title">회원 등록</h2>
			<form name="tbl_member_001" id="form" method="post" action="">
				<table>
					<tr>
						<th colspan="2">회원 기본 정보</th>
					</tr>	
	
						<th>사용자이름</th>
						<td><input type="text" size="20" name="name"></td>
					</tr>
					<tr>
						<th>사용자아이디</th>
						<td><input type="text" size="20" name="id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" size="20" name="password"></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" size="20" name="verify_password"></td>
					</tr>
					
					<tr>
						<th>회원성별</th>
					<td> 
					<input type="radio" name="gender" value="M" checked="남자">남자 
					<input type="radio" name="gender" value="F">여자
					</td>
					</tr>
					
					<tr>
						<th>회원전화</th>
						<td>
						<select name="defalt_phone">
							<option value="010">010</option>
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="032">032</option>
							<option value="042">042</option>
							<option value="052">052</option>
						</select>
						 -
						<input type="tel" size="5" name="phone"> -
						<input type="tel" size="5" name="phone">
						 </td>
					</tr>
	
					<tr>
						<th>이메일</th>
						<td>
							<input type="email" size="10" name="email1" >
								@
							<input type="email" size="10" name="email2" id="email2">
							<select name="email_select" id="email_select" onchange="setemail()">
								<option value="">직접입력</option>
								<option value="naver.com">네이버</option>
								<option value="nate.com">네이트</option>
								<option value="google.com">구글</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>직업</th>
						<td><select name="job">
								<option value="">직업을 선택하세요</option>
								<option value="자영업">자영업</option>
								<option value="공무원">공무원</option>
								<option value="회사원">회사원</option>
								<option value="교.강사">교.강사</option>
								<option value="학생">학생</option>
								<option value="기타">기타</option>
							</select>
						</td>
					</tr>
					
				
					<tr>
						<th>관심분야</th>
						<td>
							골프<input type="checkbox" name="interest" value ="골프" >
							축구<input type="checkbox" name="interest" value ="축구">
							야구<input type="checkbox" name="interest" value ="야구">
							농구<input type="checkbox" name="interest" value ="농구">
							배구<input type="checkbox" name="interest" value ="배구">
						</td>
					</tr>
					<tr>
						<th>기타(한마디)</th>
						<td>
						<textarea name="comment" row="4" ></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="가입하기" onClick="send()"> 
							<input type="button" value="돌아가기" onClick="history.back()">
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
	function send(){
		if(!tbl_member_001.name.value){
			alert("이름이 입력되지 않았습니다");
			tbl_member_001.name.focus();
			return;
		}
		if(!tbl_member_001.id.value){
			alert("아이디가 입력되지 않았습니다");
			tbl_member_001.id.focus();
			return;
		}
		if(!tbl_member_001.password.value){
			alert("비밀번호가 입력되지 않았습니다");
			tbl_member_001.password.focus();
			return;
		}
		if(!tbl_member_001.verify_password.value){
			alert("비밀번호를 확인란에 재입력해주세요");
			tbl_member_001.verify_password.focus();
			return;
		}
		if(tbl_member_001.password.value != tbl_member_001.verify_password.value){
			alert("비밀번호가 일치하지 않습니다");
			tbl_member_001.verify_password.focus();
			return;
		}
		if(!tbl_member_001.phone[0].value || !tbl_member_001.phone[1].value){
			alert("전화번호를 입력해주세요");
			tbl_member_001.phone[0].focus();
			return;
		}
		if(!tbl_member_001.email1.value){
			alert("메일을 입력해주세요");
			tbl_member_001.email1.focus();
			return;
		}
		if(!tbl_member_001.email2.value){
			alert("메일을 입력해주세요");
			tbl_member_001.email2.focus();
			return;
		}
		if(tbl_member_001.job.selectedIndex == 0){
			alert("직업이 선택되지 않았습니다");
			tbl_member_001.job.focus();
			return;
		}

		
		var flag = 0;
		for(var i = 0; i < tbl_member_001.interest.length; i++){
			if(tbl_member_001.interest[i].checked){
				flag = 1;
				break;
			}
		}
		if(!flag){
			alert("관심분야를 선택해주세요");
			return;
		}

		
		tbl_member_001.submit();
	}
	
	function setemail() {
		var domain = document.getElementById("email_select").value;
		var email2 = document.getElementById("email2");

		if (domain === "") {
			email2.value = "";
			email2.readOnly = false;
		} else {
			email2.value = domain;
			email2.readOnly = true;
		}
	}


</script>

</html>