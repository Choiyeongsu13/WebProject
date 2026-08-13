<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>주식 매수 등록</title>
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
				<h2 class="title">주식 매수 등록</h2>
				<form name="StockUpload" id="form" method ="post" action="StockUpload">
				<table>

					<tr>
						<th>매수일자</th>
						<td><input type="text" size="20" name="BUY_DATE" value="${dto.upload.buy_date}" >2022년3월2일 예)20220302</td>
					</tr>
					<tr>
						<th>종목명</th>

						<td><select name="STOCK_ITEM_CATEGORY" id="stockItemSelect" style="width:150px;" onchange="stock_item()">
						<option value="">종목명</option>
						<c:forEach var= "fund" items="${slist }">
							<option value="${fund.stock_item_code}">${fund.stock_item_name}</option>
						</c:forEach>
						</select>
						</td>

					</tr>
					<tr>
						<th>종목코드</th>
						<td><input type="text" size="20" name="STOCK_ITEM_CODE" id="stockItemCode" value="${dto.upload.STOCK_ITEM_CODE}" readonly></td>
					</tr>
					<tr>
						<th>매수수량</th>
						<td><input type="text" size="20" name="BUY_NUMBER" value="${dto.upload.BUY_NUMBER}"></td>
					</tr>
					<tr>
						<th>매수가격</th>
						<td><input type="text" size="20" name="BUY_PRICE" value="${dto.upload.BUY_PRICE}" ></td>
					</tr>
					
						<tr>
						<th>부서코드</th>

						<td><select name="DEPT_CODE" style="width:150px;" >
							<option value="">부서코드</option>
						<c:forEach var = "team" items="${dlist}">
							<option value="${team.dept_code}">${team.dept_name}</option>
						</c:forEach>
						</select>
						</td>

					</tr>
			
					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="주식매수등록" onClick="send()">
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
 function stock_item(){
	 var sel = document.getElementById("stockItemSelect");
	 document.getElementById("stockItemCode").value = sel.value;
 }



	function send(){
		if(!StockUpload.BUY_DATE.value){
			alert("매수일자가 입력되지 않았습니다!");
			StockUpload.BUY_DATE.focus();
			return;
		}
		if(!StockUpload.stockItemSelect.value){
			alert("종목명이 선택되지 않았습니다!");
			StockUpload.stockItemSelect.focus();
			return;
		}

		if(!StockUpload.BUY_NUMBER.value){
			alert("메수수량이 입력되지 않았습니다!");
			StockUpload.BUY_NUMBER.focus();
			return;
		}
		if(!StockUpload.BUY_PRICE.value){
			alert("매수가격이 입력되지 않았습니다!");
			StockUpload.BUY_PRICE.focus();
			return;
		}
		if(!StockUpload.DEPT_CODE.value){
			alert("종목명이 선택되지 않았습니다!");
			StockUpload.DEPT_CODE.focus();
			return;
		}

		alert("주식 매수가 등록되었습니다.");
		productwrite.submit();
	}
	function rewrite(){
		alert("입력된 모든 정보를 지우고 다시 입력합니다");
	}
</script>
</html>
