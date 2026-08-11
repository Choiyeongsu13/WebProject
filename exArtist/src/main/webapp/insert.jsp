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
				<h2 class="title">오디션 등록 화면</h2>
			<form name="tbl_artist_001" id="form" method="post" action="artist_write">
				<table>
					<tr>
						<th colspan="2">오디션등록</th>
					</tr>	
					<tr>
						<th>참가번호</th>
						<td><input type="text" size="20" name="artist_id" >*참가번호는(A000)4자리입니다</td>
					</tr>
					<tr>
						<th>참가자명</th>
						<td><input type="text" size="20" name="artist_name"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="data" size="5" name="artist_birth1">년
						<input type="data" size="5" name="artist_birth2">월
						<input type="data" size="5" name="artist_birth3">일
						 </td>
					</tr>
					<tr>
						<th>성별</th>
					<td> 
					<input type="radio" name="artist_gender" value="M" checked>남자 
					<input type="radio" name="artist_gender" value="F">여자
					</td>
					</tr>
					<tr>
						<th>특기</th>
						<td><select name="talent" style="width:150px";>
						<option value =""></option>
						<option value ="1">댄스</option>
						<option value ="2">랩</option>
						<option value ="3">노래</option>
					</tr>
					<tr>
						<th>소속사명</th>
						<td><input type="text" size="20" name="agency"></td>
					</tr>
					
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="오디션등록" onClick="send()"> 
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
		if(!tbl_artist_001.artist_id.value){
			alert("참가 번호가 입력되지 않았습니다!");
			tbl_artist_001.artist_id.focus();
			return;
		}
		if(!tbl_artist_001.artist_name.value){
			alert("참가자명이 입력되지 않았습니다!");
			tbl_artist_001.artist_name.focus();
			return;
		}
		if(!tbl_artist_001.artist_birth1.value || !tbl_artist_001.artist_birth2.value || !tbl_artist_001.artist_birth3.value){
	        alert("생년월일이  입력되지 않았습니다!");
	        tbl_member_001.artist_birth1.focus();
	        return;
	    }
		if(!tbl_artist_001.talent.selectedIndex === 0){
			alert("특기가 입력되지 않았습니다");
			tbl_artist_001.talent.focus();
			return;
		}
		if(!tbl_artist_001.agency.value){
			alert("고객등급이 선택되지 않았습니다");
			tbl_artist_001.agency.focus();
			return;
		}
		alert("회원정보가 등록되었습니다.");
		tbl_artist_001.submit();
	}
	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다");
	}



</script>
</html>

