<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.util.* , com.mnu.exArtist.model.*"%>
 <%
 	List<ArtistRankDTO> list = (List<ArtistRankDTO>)request.getAttribute("list");
 %>


<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>참가자 등수 조회</title>
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
				<h2 class="title">참가자 등수 조회</h2>
				<table>
					<tr>
						<th colspan="6">참가자 등수 조회</th>
					</tr>
					<tr>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>성별</th>
						<th>총점</th>
						<th>평균</th>
						<th>등수</th>
					</tr>
				<% if (list == null || list.size() == 0) { %>
					<tr class="text_center">
						<td colspan="6">등록된 자료가 없음</td>
					</tr>
				<% } else {
					int rank = 1;
					for (ArtistRankDTO dto : list) {
				%>
					<tr class="text_center">
						<td><%= dto.getArtist_id() %></td>
						<td><%= dto.getArtist_name() %></td>
						<td><%= dto.getArtist_gender() %></td>
						<td><%= dto.getTot() %></td>
						<td><%= String.format("%.2f", dto.getAve()) %></td>
						<td><%= rank++ %></td>
					</tr>
				<%
					}
				} %>
				</table>
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