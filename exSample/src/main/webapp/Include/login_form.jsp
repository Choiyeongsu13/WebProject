<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Login</title>

 </head>

 <body>
 
   <table width="100%" height="120" border="0">
   <!-- FIX: action=""가 현재 페이지 URL로 그대로 제출되어 cmd가 없거나 다른 컨트롤러로 잘못 전달되던 문제 + 정의되지 않은 check_login() 호출 제거 -->
   <form name="login_form" action="/User?cmd=UserLoginPro" method="post" >
     <tr>
       <td colspan="2" bgcolor="#6FA0E" height="20" align="center">
         <font size="2" color="white"><b>Member Login</b></font>
       </td>
     </tr>
     <tr>
       <td ><font size="2">아 이 디</font></td>
       <td ><input type="text" size="10" name="userid"></td>
     </tr>
     <tr>
       <td><font size="2">비밀번호</font></td>
			 <td>
         <input type="password" size="10" name="passwd">
       </td>
     </tr>
    
     <tr>
       <td><input type="image" src="/Images/img/login1.gif" border="0"></td>
			 <td>
           <a href=""><img src="/Images/img/regist.gif" border="0"></a>
       </td>
     </tr>
     
 </form>
 </table>
  <c:if test="${!empty user }"> 
 <table width="100%" height="120" border="0">
   <tr>
     <td bgcolor="#6FA0E" align="center" height="20">
       <font size="2" color="white">홍길동 님!</font>
     </td>
   </tr>
   <tr>
  
     <td align="center">
       <font size="2">
       <a href="adminpage.jsp">관리자 페이지</a><br>
       <a href="/User?cmd=UserLogout">로그오프</a><br>
       <a href="userinfo_view.jsp">회원정보수정</a><br>
       </font>
     </td>
     
   </tr>
 </table>
 </c:if>
 <c:if test="${!empty user }"> 
 <table width="100%" height="120" border="0">
   <tr>
     <td bgcolor="#6FA0E" align="center" height="20">
       <font size="2" color="white">홍길동민 님!</font>
     </td>
   </tr>
   <tr>
  
     <td align="center">
       <font size="2">
       <a href="/User?cmd=UserLogout">로그오프</a><br>
       <a href="userinfo_view.jsp">회원정보수정</a>
       <a href="userinfo_del.jsp">회원탈퇴</a>
       </font>
     </td>
     
   </tr>

 </table>
</c:if>
 </body>
 </html>
