<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.util.* , com.mnu.exshop.model.*"%>
 <%
 	List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");

 %>
 
 
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title> 회원관리</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:#0040FF; padding:16px 0;}
	.nav{padding:12px 0; overflow:hidden;background-color:#BCA9F5;}
	.nav ul,li{float:left; padding:0 20px; text-align:center;}
	.content {background-color:#E6E6E6; padding:16px; }
	.title {text-align:center;padding:22px;}
	.content table{width:700px;margin:0 auto;}
	.content table th, td{border:1px solid #bbb;}
	.content table .btn_group {text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
 </head>
 <body>
  
	<%@include file="header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">회원목록조회/수정</h2>
				<form name="tbl_member_001" id="form" method="post" action="/member_list">
				<table>
					<tr>
						<th colspan="7">회원 정보 조회 결과</th>
					</tr>
					<tr>
						<th>회원번호</th>
						<th>회원성명</th>
						<th>전화번호</th>
						<th>성별</th>
						<th>가입일</th>
						<th>고객등급</th>
						<th>거주구역</th>
					</tr>
				<% if(list.size()==0){ %>
				
						<tr class="text_center">
						<td class="white" colsoan="7">1001</td>
							등록된 자료가 없음
					</tr>
				
					<%}else{ 
						for(MemberDTO dto : list){
						%>
						<tr class="text_center">
						<td class="white"><a href="MemberModify?custno=<%= dto.getCustno() %>"><%= dto.getCustname() %></a></td>
						<td><a href="MemberModify?custno=<%= dto.getCustno() %>"><%= dto.getCustno() %></a></td>
						<td><%= dto.getPhone() %></td>
						<td><%= dto.getGender() %></td>
						<td><%= dto.getJoindate() %></td>
						<td><%= dto.getGrade() %></td>
						<td><%= dto.getCityname() %></td>
			<%}
					}
			%>
					<tr>
						<td colspan="7" class="btn_group">
							<input type="submit" value="확인">
						</td>
					</tr>
				</table>
			</div>
		</section>
	</div>
<!--  footer  -->
	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Serivce of Korea</p>
		</footer>
		
	</div>
</body>
</html>