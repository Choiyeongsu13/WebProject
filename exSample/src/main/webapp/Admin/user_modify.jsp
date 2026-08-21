<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<html>
<head>
<title>회원 관리 - 관리자페이지</title>
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
					<td height=40 align="center" style="font-size: 15px;"><b>회원관리[수정]</b></a>
					</b></td>
				</tr>
			</table><br>
			<form id="user" name="user" method="post" action="/Admin/User">
			<input type="hidden" name="cmd" value="userModifypro">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>아이디</strong></td>
								<td bgcolor="ffffff"><input name="userid" id="userid" type="text" value="${dto.userid}" readonly style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>이름</strong></td>
								<td bgcolor="ffffff"><input name="name" id="name" type="text" value="${dto.name}" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>비밀번호</strong></td>
								<td bgcolor="ffffff"><input name="passwd" id="passwd" type="password" value="${dto.passwd}" style="width:150; height:18; padding:2; border:1 solid slategray" size="20"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>전화번호</strong></td>
								<td bgcolor="ffffff"><input name="tel" id="tel" type="text" value="${dto.tel}" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>메일주소</strong></td>
								<td bgcolor="ffffff"><input name="email" id="email" type="text" value="${dto.email}" style="width:350; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="javascript:user_send()"><b>[수정]</b></a>&nbsp; <a href="javascript:history.back()"><b>[취소]</b></a></td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>

<script type="text/javascript">
function user_send(){
	var frm = document.user;

	if(frm.name.value.trim().length === 0){
		alert("이름을 입력하세요");
		frm.name.focus();
		return false;
	}
	if(frm.passwd.value.trim().length === 0){
		alert("비밀번호를 입력하세요");
		frm.passwd.focus();
		return false;
	}
	if(frm.tel.value.trim().length === 0){
		alert("전화번호를 입력하세요");
		frm.tel.focus();
		return false;
	}

	frm.submit();
	return true;
}
</script>
</body>
</html>
