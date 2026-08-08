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
				<h2 class="title">회원 등록 화면</h2>
			<form name="tbl_member_001" id="form" method="post" action="/member_write">
				<table>
					<tr>
						<th colspan="2">회원등록</th>
					</tr>	
					<tr>
						<th>회원번호(자동생성)</th>
						<td><input type="text" size="10" name="custno"></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" size="20" name="custname"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="tel" size="5" name="phone"> -
						<input type="tel" size="5" name="phone"> -
						<input type="tel" size="5" name="phone">
						 </td>
					</tr>
					<tr>
						<th>회원성별</th>
					<td> 
					<input type="radio" name="gender" value="M">남자 
					<input type="radio" name="gender" value="F">여자
					</td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="text" name="joindate"></td>
					</tr>
					<tr>
						<th>고객등급</th>
						<td><select name="grade" style="width:150px;">
								<option value="">고객등급</option>
								<option value="A">VIP</option>
								<option value="B">일반</option>
								<option value="C">직원</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td>
							<input type="text" name="city"></td>
					</tr>
					
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="등록하기" onClick="send()"> 
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

<script >
	function send(){
		if(!tbl_member_001.custname.value){
			alert("회원 성명이 입력되지 않았습니다!");
			tbl_member_001.custname.focus();
			return;
		}
		if(!tbl_member_001.phone[0].value || !tbl_member_001.phone[1].value || 
				!tbl_member_001.phone[2].value){
			alert("회원전화번호가 입력되지 않았습니다!");
			tbl_member_001.phone.focus();
			return;
		}
		if(!tbl_member_001.gender[0].checked && !tbl_member_001.gender[1].checked){
			alert("성별이 선택되지 않았습니다!");
			tbl_member_001.gender.focus();
			return;
		}
		if(!tbl_member_001.joindate.value){
			alert("가입일자가 입력되지 않았습니다");
			tbl_member_001.joindate.focus();
			return;
		}
		if(tbl_member_001.grade.selectedIndex === 0){
			alert("고객등급이 선택되지 않았습니다");
			tbl_member_001.grade.focus();
			return;
		}
		
		if(!tbl_member_001.city.value){
			alert("도시코드가 입력되지 않았습니다");
			tbl_member_001.city.focus();
			return;
		}
		alert("회원정보가 등록되었습니다.");
		tbl_member_001.submit();
	}
	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다");
	}



</script>

</html>

