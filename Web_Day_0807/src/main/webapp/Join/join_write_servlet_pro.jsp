<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language = "java" contentType = "text/html;"charset=UTF-8 pageEncoding="UTF-8" %>
	<%@ page import ="java.util.*" %>
	<%
		Map<String,String> map = (Map)request.getAttribute("map");
		%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		이름 : <%= map.get("name") %> <br>
	성별 : <%= map.get("gender") %> <br>
	취미 : <%= map.get("fa") %> <br>
	직업 : <%= map.get("job") %> <br>
	전화 : <%= map.get("tel") %> <br>

</body>
</html>
