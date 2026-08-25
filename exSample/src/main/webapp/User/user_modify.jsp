<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/Include/topmenu.jsp" %>
<html>
<head>
<title>회원수정</title>
<STYLE TYPE="text/css">
<!--
body { font-family: 돋움, Verdana; font-size: 9pt}
td   { font-family: 돋움, Verdana; font-size: 9pt; text-decoration: none; color: #000000; BACKGROUND-POSITION: left top; BACKGROUND-REPEAT: no-repeat;}
-->
.formbox {
	BACKGROUND-COLOR: #F0F0F0; FONT-FAMILY: "Verdana", "Arial", "Helvetica", "돋움"; FONT-SIZE:9pt
}
--->
</STYLE>
</head>

<body bgcolor="#FFFFFF" LEFTMARGIN=0  TOPMARGIN=0 >

 <!-- 탑 메뉴 영역 삽입-->


<table border="0" width="800">
<tr>
  <td width="20%"  bgcolor="#ecf1ef" valign="top" style="padding-left:0;">

	<!--로그인 영역 삽입-->
	<%@ include file="/Include/login_form.jsp" %>

  </td>
  <td width="80%" valign="top">&nbsp;<img src="/Images/img/title1.gif" ><br>
	<!-- FIX: action의 쿼리스트링 cmd=user_modify와 아래 hidden cmd=UserModifyPro가 중복/충돌 -> 서블릿이 쿼리스트링 값을 먼저 채택해 제출해도 폼이 다시 표시되기만 하던 문제. hidden 필드 하나로 통일 -->
	<form name=modify method=post action="/User?cmd=UserModify">
	<input type="hidden" name="cmd" value="UserModifyPro">
	<table border=0 cellpadding=0 cellspacing=0 width=730 valign=top>
		<tr><td align=center><br>
			<table cellpadding=0 cellspacing=0 border=0 width=650 align=center>
				<tr>
					<td bgcolor="#7AAAD5">
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td align=left BORDER="0" HSPACE="0" VSPACE="0"><img src="/Images/img/u_b02.gif"></td>
								<td align=center bgcolor="#7AAAD5"><FONT COLOR="#FFFFFF"><b>회원정보수정&nbsp;</b><font color=black>(</font><font color=red>&nbsp;*&nbsp;</font><font color=black>표시항목은 반드시 입력하십시요.)</font></FONT></td>
								<td align=right BORDER="0" HSPACE="0" VSPACE="0"><img src="/Images/img/u_b03.gif"></td>
							</tr>
						</table>
						<table cellpadding=3 cellspacing=1 border=0 width=100%>
							<tr>
								<td width=110 bgcolor=#EFF4F8>&nbsp;회원 성명<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=name size=16 maxlength=20 value="${dto.name}">성명은 빈칸없이 입력하세요.
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;회원 ID</td>
								<TD BGCOLOR=WHITE>
									<input type=text name=userid size=12 maxlength=16 value="${dto.userid}" readonly style="width:120">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;전화번호<font color=red>&nbsp;*</font></td>
								<TD BGCOLOR=WHITE>
									<input type=text name=tel size=13 maxlength=13 value="${dto.tel}">
								</td>
							</tr>
							<tr>
								<TD BGCOLOR="#EFF4F8">&nbsp;E-mail</td>
								<td bgcolor=WHITE valign=middle>
									<input type="text" name="email" size=30 maxlength="40" value="${dto.email}">
								</td>
							</tr>
						</table>
						<table cellpadding=0 cellspacing=0 border=0 width=100%>
							<tr bgcolor=#7AAAD5>
								<td valign=bottom>
									<img src="/Images/img/u_b04.gif" align=left hspace=0 vspace=0 border=0>
								</td>
								<td align=center></td>
								<td valign=bottom>
									<img src="/Images/img/u_b05.gif" align=right hspace=0 vspace=0 border=0>
								</td>
							</tr>
							<tr bgcolor=#ffffff>
							<td colspan=3 align=center>
									<input type="submit" value="수정">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				</td>
			</tr>
		</table>
	</form>
	</td>
</tr>
</table>

 <!-- copyright 영역 삽입-->

</body>
</html>
