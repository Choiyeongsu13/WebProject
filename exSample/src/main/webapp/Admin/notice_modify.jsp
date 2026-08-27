<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
//JQuery를 이용한 유효성 검사
$(function(){
	$("#btn_write").click(function(){
		if($("#subject").val()==''){
			alert("제목을 입력하세요");
			$("#subject").focus();
			return;
		}
		if($("#contents").val()==''){
			alert("내용을 입력하세요");
			$("#contents").focus();
			return;
		}
		
		$("#notice").submit();
	});

	$("#btn_cancle").click(function(){
		history.back();
	});

});
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>공지사항 [수정]</b></a>
					</b></td>
				</tr>
			</table><br>
			<form id="notice" name="notice" method="post" action="/Admin/Notice?cmd=noticeModifyPro">
			<input type="hidden" name="idx" value="${nDTO.idx}">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff"><input id="subject" name="subject" type="text" value="${nDTO.subject}"  style="width:450; height:18; padding:2; border:1 solid slategray" size="120" ></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff"><textarea id="contents" name="contents" cols="10" rows="10" style="width:490; height:200; padding:2; border:1 solid slategray" tabindex="2">${nDTO.contents}</textarea></td>
							</tr>
						</table>
					</td>
				</tr>

			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center>
						<input type="button" value="수정" id="btn_write">
						<input type="button" value="취소" id="btn_cancle">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>			
</body>
</html>
