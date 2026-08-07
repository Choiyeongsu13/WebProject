<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    request.setCharacterEncoding("utf-8");
    
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String fa[] = request.getParameterValues("fa"); //배열
    
    String strFa="";
    for(String s : fa){
   	strFa += s + " ";
   	}
   	
   	String job = request.getParameter("job");
   	String tel1 = request.getParameter("tel1"); 
   	String tel2 = request.getParameter("tel2"); 
   	String tel3 = request.getParameter("tel3"); 
    String tel = tel1 + "-" + tel2 + "-" +tel3;
    
    //DB저장
    int row =0;
    if(row==1){
    		response.sendRedirect("/index.jsp");
    }else{
    	%>
    	
    		<script>
    			alert("회원가입 실패");
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
	이름 : <%= name %> <br>
	성별 : <%= gender.equals("M")? "남자":"여자" %> <br>
	취미 : <%= fa %> <br>
	직업 : <%= job %> <br>
	전화 : <%= tel %> <br>

</body>
</html>