<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int row= (int) request.getAttribute("row");
    
    if(row==1){
    %>
    <script>
    alert("등록 완료");
    location.href="/";
    
    </script>
    <%
    
    }else{
    %>
    <script>
    alert("현재 접속자 폭주로 잠시후 다시 등록해주세요");
    history.back();
    
    </script>
    <%
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>