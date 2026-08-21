<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<html>
<head>
<title>협력업체 관리 - 관리자페이지</title>
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
}
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
					<td height=40 align="center" style="font-size: 15px;"><b>협력업체[등록]</b></a>
					</b></td>
				</tr>
			</table><br>
			<form id="board" name="board" method="post" action="/Admin/Board">
			<input type="hidden" name="cmd" value="boardWritepro">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>글쓴이</strong></td>
								<td bgcolor="ffffff"><input name="name" id="name" type="text" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>메일주소</strong></td>
								<td bgcolor="ffffff"><input name="email" id="email" type="text" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff"><input name="subject" id="subject" type="text" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff">
										<textarea name="contents" id="contents" cols="62" rows="10" class="textfield"></textarea>
								</td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>비밀번호</strong></td>
								<td bgcolor="ffffff"><input name="pass" id="pass" type="password" style="width:150; height:18; padding:2; border:1 solid slategray" size="20"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="javascript:board_send()"><b>[등록]</b></a>&nbsp; <a href="javascript:history.back()"><b>[취소]</b></a></td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>

<script type="text/javascript">
function board_send(){
	var frm = document.board;

	if(frm.name.value.trim().length === 0){
		alert("글쓴이를 입력하세요");
		frm.name.focus();
		return false;
	}
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
	if(frm.pass.value.trim().length === 0){
		alert("비밀번호를 입력하세요");
		frm.pass.focus();
		return false;
	}

	frm.submit();
	return true;
}
</script>
</body>
</html>
