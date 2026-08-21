<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<html>
<head>
<title>포토갤러리 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #606060;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	background-image:    url(img/bg_img01.gif);
}
-->
</style>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr>
					<td height=40 align="center" style="font-size: 15px;"><b>포토갤러리 내용보기</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>구분</strong></td>
								<td bgcolor="ffffff">${dto.gubun}</td>
							</tr>
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff">${dto.subject}</td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>등록일</strong></td>
								<td bgcolor="ffffff">${dto.regdate}</td>
							</tr>
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>조회수</strong></td>
								<td bgcolor="ffffff">${dto.readcnt}</td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff">${dto.contents}</td>
							</tr>
						</table>
					</td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="/Admin/Gallery?cmd=galleryModify&idx=${dto.idx}"><b>[수정]</b></a>&nbsp; <a href="javascript:void(0)" onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='/Admin/Gallery?cmd=galleryDeletepro&idx=${dto.idx}'"><b>[삭제]</b></a>&nbsp; <a href="/Admin/Gallery?cmd=galleryList"><b>[목록]</b></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
