<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적등록</title>
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
				<h2 class="title">성적 등록</h2>
			<form name="tbl_student_001" id="form" method="post" action="<%= request.getContextPath() %>/scoreWrite.do">
				<table>
					<tr>
						<th colspan="2">성적등록</th>
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
						<th>국어</th>
						<td><input type="text" size="10" name="kor">점수범위(0~100)</td>
					</tr>
					<tr>
						<th>영어</th>
						<td><input type="text" size="10" name="eng">점수범위(0~100)</td>
					</tr>
					<tr>
						<th>수학</th>
						<td><input type="text" size="10" name="mat">점수범위(0~100)</td>
					</tr>

					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="성적저장" onClick="send()"> 
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
		if(!tbl_student_001.kor.value){
			alert("국어점수가 입력되지 않았습니다!");
			tbl_student_001.kor.focus();
			return;
		}
		if(!tbl_student_001.eng.value){
			alert("영어점수가 입력되지 않았습니다!");
			tbl_student_001.eng.focus();
			return;
		}
		if(!tbl_student_001.mat.value){
	        alert("수학점수가 입력되지 않았습니다!");
	        tbl_student_001.mat.focus();
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

