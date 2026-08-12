<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록</title>
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
				<h2 class="title">학생 등록</h2>
			<form name="tbl_student_001" id="form" method="post" action="<%= request.getContextPath() %>/studentWrite.do">
				<table>
					<tr>
						<th colspan="2">학생등록</th>
					</tr>	
					<tr>
						<th>학년</th>
						<td><input type="text" size="10" name="syear" >(예)1</td>
					</tr>
					<tr>
						<th>반</th>
						<td><input type="text" size="10" name="sclass">(예)01</td>
					</tr>
					<tr>
						<th>번호</th>
						<td><input type="text" size="10" name="sno">(예)01</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" size="20" name="sname"></td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td><input type="text" size="20" name="birth">(예)20190301
						 </td>
					</tr>
					<tr>
						<th>성별</th>
					<td> 
					<input type="radio" name="gender" value="M" checked>남자 
					<input type="radio" name="gender" value="F">여자
					</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" size="5" name="tel1"> -
						<input type="tel" size="5" name="tel2"> -
						<input type="tel" size="5" name="tel3">
						 </td>
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="학생등록" onClick="send()"> 
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
		if(!tbl_student_001.syear.value){
			alert("학년이 입력되지 않았습니다!");
			tbl_student_001.syear.focus();
			return;
		}
		if(!tbl_student_001.sclass.value){
			alert("반이 입력되지 않았습니다!");
			tbl_student_001.sclass.focus();
			return;
		}
		
		if(!tbl_student_001.sno.value){
			alert("번호가 입력되지 않았습니다!");
			tbl_student_001.sno.focus();
			return;
		}
		if(!tbl_student_001.sname.value){
			alert("이름이 입력되지 않았습니다!");
			tbl_student_001.sname.focus();
			return;
		}
		if(!tbl_student_001.birth.value){
			alert("생년월일 입력되지 않았습니다!");
			tbl_student_001.birth.focus();
			return;
		}
		if(!tbl_student_001.tel1.value || !tbl_student_001.tel2.value || !tbl_student_001.tel3.value){
	        alert("전화번호가  입력되지 않았습니다!");
	        tbl_student_001.tel1.focus();
	        return;
	    }

		alert("학생 정보가 등록되었습니다.");
		tbl_student_001.submit();
	}
	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다");
	}



</script>
</html>

