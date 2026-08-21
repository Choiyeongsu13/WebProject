<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

<%@ include file="/Include/topmenu.jsp" %>

<html>
   <head><title>게시판 작성</title>
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
     <font size="2"> - 글쓰기</font><p>
     <img src="/Images/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Images/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form id="board" name="board" method="post" action="/Board">
	  <input type="hidden" name="cmd" value="boardWritepro">

	  <table border="0">
       <tr>
         <td width="5%" align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%">
         <input type="text" size="20" id="name" name="name"></td>
       </tr>
       <tr>
         <td align="right">&nbsp;</td>
         <td ><font size="2" face="돋움">메일주소</font></td>
         <td>
          <input type="text" size="20" id="email" name="email"></td>
       </tr>
	   <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" id="subject" name="subject" ></td>
       </tr>
       <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" id="contents" name="contents" cols="60"></textarea></td>
       </tr>
	   <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" id="pass" name="pass" ><font size="2" face="돋움">*.수정과 삭제시 꼭 입력하셔야 합니다.</font></td>
        </tr>
        <tr></tr>
		<tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td>
                     <a href="javascript:board_send()"><img src="/Images/img/save.gif" border=0></a>&nbsp;&nbsp;&nbsp;
                     <a href="javascript:history.back()"><img src="/Images/img/cancle.gif" border=0></a>
		</td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
  </table>

  <script>
  function board_send(){
	  var frm = document.board;

	  if(frm.name.value.trim().length === 0){
		  alert("이름이 비어있습니다");
		  frm.name.focus();
		  return false;
	  }
	  if(frm.subject.value.trim().length === 0){
		  alert("제목이 비어있습니다");
		  frm.subject.focus();
		  return false;
	  }
	  if(frm.contents.value.trim().length === 0){
		  alert("내용이 비어있습니다");
		  frm.contents.focus();
		  return false;
	  }
	  if(frm.pass.value.trim().length === 0){
		  alert("비밀번호가 비어있습니다");
		  frm.pass.focus();
		  return false;
	  }

	  frm.submit();
	  return true;
  }
  </script>

  </body>
  </html>
