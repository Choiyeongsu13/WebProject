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
<style type="text/css">
<!--
.style1 {color: #4692c9}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr>
					<td height=40 align="center" style="font-size: 15px;"><b>포토갤러리 리스트</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 등록수 : <font color=red>${totcount}</font> 건</td>
                </tr>
                <tr>
                    <td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
                        <td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
                        <td width="15%" align="center" bgcolor="EcECEC"><strong>구분</strong></td>
						<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
                        <td width="20%" align="center"><strong>등록일</strong></td>
                        <td width="10%" align="center"><strong>조회수</strong></td>
                      </tr>
                      <c:forEach var="dto" items="${AnList}">
                      <tr>
                        <td align="center" bgcolor="#FFFFFF">${dto.idx}</td>
                        <td align="center" bgcolor="#FFFFFF">${dto.gubun}</td>
                        <td bgcolor="#FFFFFF"><a href="/Admin/Gallery?cmd=galleryView&idx=${dto.idx}" class="unnamed1">${dto.subject}</a></td>
                        <td align="center" bgcolor="#FFFFFF">${dto.regdate}</td>
						<td align="center" bgcolor="#FFFFFF">${dto.readcnt}</td>
                      </tr>
                      </c:forEach>
                      <tr>
                        <td height="35" colspan="10" align="center" bgcolor="#FFFFFF">&nbsp;</td>
                      </tr>
                      <tr>
                        <td colspan="10" align="right" bgcolor="#FFFFFF"><a href="/Admin/Gallery?cmd=galleryWrite"><b>[등록하기]</b></a></td>
                      </tr>
                    </table>
                   </td>
               </tr>
           </table>
       </td>
    </tr>
</table>
</body>
</html>
