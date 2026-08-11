<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.util.* , com.mnu.exArtist.model.*"%>
 <%
 	Boolean searched = (Boolean) request.getAttribute("searched");
 	List<mentoScoreDTO> mlist = (List<mentoScoreDTO>) request.getAttribute("mlist");
 	String serial_no = (String) request.getAttribute("serial_no");
 	if (serial_no == null) serial_no = "";
 %>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>채점 점수 조회</title>
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
	.content table th, td{border:1px solid #bbb; padding:6px;}
	.text_center{text-align:center;}
	.footer {padding:16px 0; text-align:center; background-color:#0040FF;}
</style>
 </head>
 <body>

	<%@include file="header.jsp" %>
	<div class="section">
		<section>
			<div class="content">
				<h2 class="title">채점 점수 조회</h2>
				<form name="tbl_mento_search" method="get" action="mento_score_search">
				<table>
					<tr>
						<td>채점번호</td>
						<td>
							<input type="text" name="serial_no" value="<%= serial_no %>">
							<input type="submit" value="검색">
						</td>
					</tr>
				</table>
				</form>
				<br>

			<% if (searched != null && searched) { %>
				<table>
					<tr>
						<th colspan="7">채점 점수 조회 결과</th>
					</tr>
					<tr>
						<th>채점번호</th>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>생년월일</th>
						<th>점수</th>
						<th>평점</th>
						<th>멘토</th>
					</tr>
				<% if (mlist == null || mlist.size() == 0) { %>
					<tr class="text_center">
						<td colspan="7">검색 결과가 없음</td>
					</tr>
				<% } else {
					for (mentoScoreDTO dto : mlist) {
						String grade;
						if (dto.getPoint() >= 90) grade = "A";
						else if (dto.getPoint() >= 80) grade = "B";
						else if (dto.getPoint() >= 70) grade = "C";
						else if (dto.getPoint() >= 60) grade = "D";
						else grade = "F";
				%>
					<tr class="text_center">
						<td><%= dto.getSerial_no() %></td>
						<td><%= dto.getArtist_id() %></td>
						<td><%= dto.getArtist_name() %></td>
						<td><%= dto.getArtist_birth() %></td>
						<td><%= dto.getPoint() %></td>
						<td><%= grade %></td>
						<td><%= dto.getMento_name() %></td>
					</tr>
				<%
					}
				} %>
				</table>
			<% } %>
			</div>
		</section>
	</div>

	<div class="footer">
		<footer>
			<p>HRDKOREA Copyright@2016 All rights reserve. Human Resources Development Serivce of Korea</p>
		</footer>
	</div>
</body>
</html>