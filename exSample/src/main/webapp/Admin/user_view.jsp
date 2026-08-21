<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<html>
<head>
<title>회원 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;}

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;}
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;}
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;}
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;}
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
					<td height=40 align="center" style="font-size: 15px;"><b>회원관리 내용보기</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="18%" align="center" bgcolor="EcECEC"><strong>아이디</strong></td>
								<td width="48%" bgcolor="ffffff">${dto.userid}</td>
								<td width="18%" align="center" bgcolor="EcECEC"><strong>이름</strong></td>
								<td align="center" bgcolor="ffffff">${dto.name}</td>
							</tr>
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>전화번호</strong></td>
								<td bgcolor="ffffff">${dto.tel}</td>
								<td align="center" bgcolor="EcECEC"><strong>이메일</strong></td>
								<td align="center" bgcolor="ffffff">${dto.email}</td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>가입일</strong></td>
								<td bgcolor="ffffff">${dto.firstTime}</td>
								<td align="center" bgcolor="EcECEC"><strong>최근접속일</strong></td>
								<td align="center" bgcolor="ffffff">${dto.lastTime}</td>
							</tr>
						</table>
					</td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="/Admin/User?cmd=userModify&userid=${dto.userid}"><b>[수정]</b></a>&nbsp; <a href="javascript:void(0)" onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='/Admin/User?cmd=userDeletepro&userid=${dto.userid}'"><b>[삭제]</b></a>&nbsp; <a href="/Admin/User?cmd=userList"><b>[목록]</b></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
