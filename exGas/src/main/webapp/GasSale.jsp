<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>매출 등록</title>

</head>
<body>
<%@ include file="header.jsp" %>

	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">매출 등록</h2>
				<form name="Gassale" id="form" method="post" action="GasSale">
				<table>

					<tr>
						<th>매출번호</th>
						<td><input type="text" size="20" name="saleno" value="${dto.saleno}">예)9001</td>
					</tr>
					<tr>
						<th>주유일자</th>
						
						<td><input type="text" size="20" name="oildate" value="${dto.oildate}">예)20201001</td>
					</tr>
					<tr>
						<th>유종</th>

						<td><select name="oiltype" id="oiltype" style="width:150px;">
						<option value="">유종</option>
						<c:forEach var="type" items="${list}">
			
							<option value="${type.oiltype}">${type.oilname}</option>
						</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<th>주유량</th>

						<td><input type="text" size="20" name="amount" id="amount" value="${dto.amount}">리터</td>
					</tr>
					<tr>
						<th>결제방법</th>

						
						<td><input type="text" size="20" name="paytype" value="${dto.paytype}">(1:현금/2:카드)</td>
					</tr>

					<tr>
						<th>카드번호</th>

						<td>
							<input type="text" size="10" name="creditcard1">-
							<input type="text" size="10"  name="creditcard2">-
							<input type="text" size="10"  name="creditcard3">-
							<input type="text" size="10" name="creditcard4">

							<input type="hidden" name="creditcart">
						</td>
					</tr>
					<tr>
						<th>금액</th>
						<td><input type="text" size="20" name="oilcost" value="${dto.oilcost}"></td>
					</tr>

					<tr>
						<td colspan="2" class="btn_group">
							<input type="button" value="결제" onClick="send()">
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
<script>
	function send() {
		var frm = Gassale;

		if (!frm.saleno.value) {
			alert("매출번호가 입력되지 않았습니다!");
			frm.saleno.focus();
			return;
		}
		if (!frm.oildate.value) {
			alert("주유일자가 입력되지 않았습니다!");
			frm.oildate.focus();
			return;
		}
		if (!frm.oiltype.value) {
			alert("유종이 선택되지 않았습니다!");
			frm.oiltype.focus();
			return;
		}
		if (!frm.amount.value) {
			alert("주유량이 입력되지 않았습니다!");
			frm.amount.focus();
			return;
		}
		if (!frm.paytype.value) {
			alert("결제방법이 입력되지 않았습니다!");
			frm.paytype.focus();
			return;
		}
		if (!frm.oilcost.value) {
			alert("금액이 입력되지 않았습니다!");
			frm.oilcost.focus();
			return;
		}

		if (frm.paytype.value === "2") {
			frm.creditcart.value = frm.creditcard1.value + frm.creditcard2.value
					+ frm.creditcard3.value + frm.creditcard4.value;
		}

		alert("매출정보가 정상적으로 등록되었습니다!");
		frm.submit();
	}


	function rewrite() {
		if (confirm("정보를 지우고 처음부터 다시 입력 합니다")) {
			Gassale.reset();
			Gassale.saleno.focus();
		}
	}
</script>
</html>