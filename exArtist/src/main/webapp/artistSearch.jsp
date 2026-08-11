<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.util.* , com.mnu.exArtist.model.*"%>
<%
	Boolean searched = (Boolean) request.getAttribute("searched");
	List<ArtistSearchDTO> list = (List<ArtistSearchDTO>) request.getAttribute("list");
	String artist_id = (String) request.getAttribute("artist_id");
	if (artist_id == null) artist_id = "";
%>

<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>참가자 검색</title>
<style type="text/css">
	*{margin:0; padding:0;}
	ul,li {list-style:none;}
	a {text-decoration:none; color:#fff;}
	.logo {color:#fff; text-align:center; background-color:rgb(0, 255, 255); padding:16px 0;}
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
				<h2 class="title">참가자 검색</h2>
				<form name="tbl_search" method="get" action="artist_Search">
				<table>
					<tr>
						<td>참가번호</td>
						<td>
							<input type="text" name="artist_id" value="<%= artist_id %>" >
							<input type="submit" value="검색" onclick="send()">
						</td>
					</tr>
				</table>
				</form>
				<br>

			<% if (searched != null && searched) { %>
				<table>
					<tr>
						<th colspan="5">참가자 검색 결과</th>
					</tr>
					<tr>
						<th>참가번호</th>
						<th>참가자명</th>
						<th>생년월일</th>
						<th>멘토이름</th>
						<th>점수</th>
					</tr>
				<% if (list == null || list.size() == 0) { %>
					<tr class="text_center">
						<td colspan="5">검색 결과가 없음</td>
					</tr>
				<% } else {
					int tot=0;
					for (ArtistSearchDTO dto : list) {
						tot += dto.getPoint();
				%>
					<tr class="text_center">
						<td><%= dto.getArtist_id() %></td>
						<td><%= dto.getArtist_name() %></td>
						<td><%= dto.getArtist_birth() %></td>
						<td><%= dto.getMento_name() %></td>
						<td><%= dto.getPoint() %></td>
					</tr>
				<%
					}
				} %>
				<tr>
					<th colspan=4>합계</th>
					<th> <%=tot %></th>
				</tr>
				<tr>
					<th colspan=4>합계</th>
					<th> <%=String.format("%.2f"(double)tot/list.size()) %></th>
				</tr>
				
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
<script>
function send(){
	if(!tbl_search.artist_id.value){
		alert("참가 번호가 입력되지 않았습니다");
		tbl_search.artist_id.focus();
		return;
	}

	tbl_search.submit();
	}
</script>


</html>