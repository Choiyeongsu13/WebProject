<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<%@ include file="/Include/topmenu.jsp" %>

<html>
   <head><title>게시판 수정</title>
    <link rel="stylesheet" type="text/css" href="/stylesheet.css">

</head>
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

   <!-- 다음에 추가할 부분 -->
	<jsp:include page="/Include/login_form.jsp" />
   </td>

   <td width="80%" valign="top">&nbsp;<br>
     <img src="/Images/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>반갑습니다</b></font>
     <font size="2"> - 글 수정</font><p>
     <img src="/Images/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Images/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form id="board" name="board" method="post" action="/BoardPhoto">
	  <input type="hidden" name="cmd" value="boardPhotoModifyPro">
	  <input type="hidden" name="idx" value="${dto.idx}">

	  <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" id="name" name="name" value="${dto.name}" readonly></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2" face="돋움">메일주소</font></td>
         <td>
          <input type="text" size="20" id="email" name="email" value=""></td>
       </tr>
	   <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" id="subject" name="subject" value="${dto.subject}"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" id="contents" name="contents" cols="60">${dto.contents}</textarea></td>
       </tr>
	   <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" id="pass" name="pass" ><font size="2" face="돋움" value="${dto.pass }">*.글 작성시 입력한 비밀번호를 다시 입력하셔야 합니다.</font></td>
        </tr>
        <tr></tr>
		<tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
          			[<img src="/Images/img/save.gif" border=0 id="btn_send" style="cursor:pointer;"> ]
          			[<img src="/Images/img/cancle.gif" border=0 id="btn_cancel" style="cursor:pointer;">]
          </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>

  <script type="text/javascript"
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
  </script>

  <script>
  //jQuery를 이용한 유효성 검사
  $(function(){
	 $("#btn_send").click(function(){
		 if($("#name").val().trim() == ''){
			 alert("이름을 입력하세요");
			 $("#name").focus();
			 return;
		 }
		 if($("#subject").val().trim() == ''){
			 alert("제목을 입력하세요");
			 $("#subject").focus();
			 return;
		 }
		 if($("#contents").val().trim() == ''){
			 alert("내용을 입력하세요");
			 $("#contents").focus();
			 return;
		 }
		 if($("#pass").val().trim() == ''){
			 alert("비밀번호를 입력하세요");
			 $("#pass").focus();
			 return;
		 }

		 $("#board").submit();
	 });

	 $("#btn_cancel").click(function(){
		 history.back();
	 });
  });
  </script>

  </body>
  </html>