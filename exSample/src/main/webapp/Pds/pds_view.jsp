<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%@ include file="/Include/topmenu.jsp" %>

<html>
   <head>
      <title> 게시판 내용 보기 </title>
 <link rel="stylesheet" type="text/css" href="/stylesheet.css">
   <style type="text/css">
     td.title { padding:4px; background-color:#e3e9ff }
     td.content { padding:10px; line-height:1.6em; text-align:justify; }
     a.list { text-decoration:none;color:black;font-size:10pt; }
   </style>
 </head>

   <!--DB에서 검색한 자료를 화면에 출력  -->
 <body topmargin="0" leftmargin="0">
 <table border="0" width="800">
   <tr>
     <td width="20%"  height="500" bgcolor="#ecf1ef" valign="top">

		<!--  로그인 폼 추가 -->
		<jsp:include page="/Include/login_form.jsp" /> 

     </td>
     <td width="80%" valign="top">
       &nbsp;<br>
     <table border="0" width="90%" align="center">
       <tr>
         <td colspan="2"><img src="/Images/img/bullet-01.gif"> 
           <font color="blue" size="3">참 좋은 자료실</font><font size="2"> - 자료읽기</font></td>
       </tr>
     </table>
     <p>

     <table border="0" width="90%" align="center" cellspacing="0" style="border-width:1px;border-color:#0066cc;border-style:outset;">
       <tr bgcolor="e3e9ff">
         <td class="title">
           <img src="/Images/img/bullet-04.gif">
           <font size="2" face="돋움">${pDTO.subject}</font></td></tr>
  <tr>
    <td class="content">
    <p align="right"><font size="2" face="돋움">
			${pDTO.name } / ${pDTO.regdate } / ${pDTO.readcnt }번 읽음</font>
    <p>${pDTO.contents }<p>
    <c:if test="${not empty pDTO.filename }">
    <p align="left"><font size="2" face="돋움">
    첨부파일 : <a class="list" href="/Pds?cmd=pdsDown&idx=${pDTO.idx}">${pDTO.filename }</a></font>
    </c:if>
	</td></tr>
  </table>

  <!--**** 여기서부터 게시물 내용 아래쪽의 버튼들이 나옵니다. 수정, 삭제, 목록보기 ****-->
  <p align="center">
  <font size="2">
  <!-- 새글쓰기 -->
  <a href="/Pds?cmd=pdsWrite">
  <img src="/Images/img/write.gif" border="0"></a>&nbsp;&nbsp;
  <!-- 수정하기 -->
  <a href="/Pds?cmd=pdsModify&idx=${pDTO.idx}">
  <img src="/Images/img/edit-1.gif" border="0"></a>&nbsp;&nbsp;
  <!-- 삭제하기 -->
  <a href="javascript:pds_delete()">
  <img src="/Images/img/del.gif" border="0"></a>&nbsp;&nbsp;
  <!-- 목록보기 -->
  <a href="/Pds?cmd=pdsList">
  <img src="/Images/img/list-2.gif" border="0"></a>&nbsp;&nbsp;
  </font></td></tr>
</table>
</body>
</html>

<script>
	function pds_delete(){
		var url="/Pds?cmd=pdsDelete&idx=${pDTO.idx}"
		window.open(url,"pdsDelete","width=300, height=200");
	}
</script>