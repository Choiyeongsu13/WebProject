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
					<td height=40 align="center" style="font-size: 15px;"><b>포토갤러리[수정]</b></a>
					</b></td>
				</tr>
			</table><br>
			<form action="/Admin/Gallery" method="post" name="gallery_write_form">
			<input type="hidden" name="cmd" value="galleryModifypro">
			<input type="hidden" name="idx" value="${dto.idx}">
			<table width="620" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td><table width="620" border="0" cellspacing="1" cellpadding="6" bgcolor="#dddddd">
											<tr align="center" bgcolor="#E3F3FF">
                        <td width=150 height="30" align="center">구분</td>
                        <td colspan="5" align="left" bgcolor="#ffffff">
							<select name="gubun" id="gubun" class="select">
								<option value="구분1" ${dto.gubun=='구분1' ? 'selected' : ''}>구분1</option>
								<option value="아기사진(돌)" ${dto.gubun=='아기사진(돌)' ? 'selected' : ''}>아기사진(돌)</option>
							</select>
						</td>
                      </tr>
                      <tr align="center" bgcolor="#E3F3FF">
                        <td width=150 height="30" align="center">제목</td>
                        <td colspan="5" align="left" bgcolor="#ffffff"><input name="subject" id="subject" value="${dto.subject}" type="text" size="50"></td>
                      </tr>
                      <tr align="center" bgcolor="#E3F3FF">
                        <td height="30" align="center">내용</td>
                        <td colspan="5" align="left" bgcolor="#ffffff"><textarea name="contents" id="contents" cols="50" rows="8">${dto.contents}</textarea></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="30" align="center" bgcolor="#ffffff"><a href="javascript:gallery_send()"><b>[수정하기]</b></a>&nbsp;<a href="javascript:history.back()"><b>[취소]</b></a></td>
                  </tr>
                </table>
			</form>
<!--------------------------------------------------------------------------------------------------------->
		</TD>
	</TR>
</TABLE>

<script type="text/javascript">
function gallery_send(){
	var frm = document.gallery_write_form;

	if(frm.subject.value.trim().length === 0){
		alert("제목을 입력하세요");
		frm.subject.focus();
		return false;
	}
	if(frm.contents.value.trim().length === 0){
		alert("내용을 입력하세요");
		frm.contents.focus();
		return false;
	}

	frm.submit();
	return true;
}
</script>
</body>
</html>
