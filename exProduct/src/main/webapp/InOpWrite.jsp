<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
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
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">제품 등록</h2>
				<form name="productwrite" id="form" method ="post" action="InOpWrite">
				<table>

					<tr>
						<th>입출고번호</th>
						<td><input type="text" size="20" name="t_no" value="${dto.tbl_inout.t_no}" readonly>예)20200006</td>
					</tr>
					<tr>
						<th>제품코드</th>
						<td><input type="text" size="20" name="p_code" value="${dto.tbl_inout.p_code}"></td>
					</tr>
					<tr>
						<th>입출고구분</th>
						<td>
						<input type="radio" name="t_type" value="I" checked>입고
						<input type="radio" name="t_type" value="O">출고
						</td>
						<!-- 입고, 출고  -->
					</tr>
					<tr>
						<th>수량</th>
						<td><input type="text" size="20" name="t_cnt" value="${dto.tbl_inout.t_cnt}"></td>
					</tr>
					<tr>
						<th>거래일자</th>
						<td><input type="text" size="20" name="t_date" value="${dto.tbl_inout.t_date}" ></td>
					</tr>
					<tr>
						<th>거래처</th>
						<td><select name="c_code" style="width:150px;" >
							<option value="">거래처명</option>
							<option value="10">서울공장</option>
							<option value="20">울산공장</option>
							<option value="30">부산상사</option>
							<option value="40">광주상사</option>
							<option value="50">대전상사</option>
						</select>
						</td>
						<!-- 10서울공장 20울산공장 30부산상사 40광주상사 50대전상사 -->
					</tr>
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="입출고등록" onClick="send()">
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
		if(!productwrite.t_no.value){
			alert("입출고 번호가 입력되지 않았습니다!");
			productwrite.t_no.focus();
			return;
		}
		if(!productwrite.p_code.value){
			alert("제품번호가 입력되지 않았습니다!");
			productwrite.p_code.focus();
			return;
		}

		if(!productwrite.t_cnt.value){
			alert("수량 입력되지 않았습니다!");
			productwrite.t_cnt.focus();
			return;
		}
		if(!productwrite.t_date.value){
			alert("거래일자가 입력되지 않았습니다!");
			productwrite.t_date.focus();
			return;
		}
		if(!/^\d{8}$/.test(productwrite.t_date.value)){
			alert("거래일자는 20200101 형식(yyyymmdd)으로 입력해주세요!");
			productwrite.t_date.focus();
			return;
		}
		if(!productwrite.c_code.value){
			alert("거래처가 선택되지 않았습니다!");
			productwrite.c_code.focus();
			return;
		}

		alert("입출고 정보가 등록되었습니다.");
		productwrite.submit();
	}
	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다");
	}
</script>
</html>
