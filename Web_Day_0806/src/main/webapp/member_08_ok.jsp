<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String hobby[] = request.getParameterValues("hobby");
	//"a/b/c","a,b,c"
	String str=hobby[0];
	for(int i=1; i<hobby.length; i++){
		str= str + "," + hobby[i];
	}
	String job = request.getParameter("job");
	String intro = request.getParameter("intro");
	out.print("이름 : " + name);
	out.print("성별 : " + gender);
	out.print("취미 : " + str);
	out.print("직업 : " + job);
	out.print("소개 : " + intro);
	
	
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