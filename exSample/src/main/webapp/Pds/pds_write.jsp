<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/Include/topmenu.jsp" %>

<html>
   <head><title> 자료 올리기 </title>
   </head> 
<body>
<link rel="stylesheet" type="text/css" href="stylesheet.css">

<table border="0" width="800">
 <tr>
   <td width="20%" height="500" bgcolor="#ecf1ef" valign="top">

	<!--     다음에 추가할 로그인  -->
	<jsp:include page="/Include/login_form.jsp" /> 

   </td>
   <td width="80%" valign="top">&nbsp;<br>
     <img src="/Images/img/bullet-01.gif"><font size="3" face="돋움" color="blue"> <b>참 좋은 자료실</b></font>
     <font size="2"> - 자료올리기</font><p>
     <img src="/Images/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
     <img src="/Images/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
     <form name="pds" id="pds" method ="post" enctype ="multipart/form-data" action ="/Pds?cmd=pds_WrtiePro">

	  <table border="0" >
		<tr>
         <td width="5%" align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td width="15%"><font size="2" face="돋움">글쓴이</font></td>
         <td width="80%">
			<input type="text" size="20" name="name"></td>
		</tr>
		<tr> 
		  <td align="right">&nbsp;</td>
          <td><font size="2" face="돋움">메일주소</font></td>
		  <td><input type="text" size="20" name="email"></td>
		</tr>	
       <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">제목</font></td>
         <td><input type="text" size="60" name="subject"></td>
       </tr>
       <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">내용</font></td>
         <td><textarea wrap="physical" rows="10" name="contents" cols="60"></textarea></td>
       </tr>
		<tr>
		  <td align="right"><img src="/Images/img/bullet-02.gif"></td>
		  <td><font size="2" face="돋움">파일첨부</font></td>
		  <td><input type="file" name="filename" size="30"></td></tr>
		<tr>
       <tr>
         <td align="right"><img src="/Images/img/bullet-02.gif"></td>
         <td><font size="2" face="돋움">비밀번호</font></td>
          <td><input type="password" size="10" name="pass" > 
          <font size="2" face="돋움">*.게시글의 수정 및 삭제시 필요.</font>
         </td>
        </tr>

		<tr></tr>			<tr></tr>
          <td align="right">&nbsp;</td>
          <td><font size="2">&nbsp;</font></td>
          <td align=center>
			<img src="/Images/img/save.gif" width="56" height="18" border="0" id="pds_save">
			<img src="/Images/img/cancle.gif" width="56" height="18" border="0" id="pds_cancle">

		  </td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
 </table>
</body>		
</html>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<script>
	$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정

		});
		
		$("#pds_save").click(function(){
			if($("#name").val()==''){
				alert("이름을 입력하세요");
				$("#name").focus();
				return;
			}
			if($("#subject").val()==''){
				alert("제목을 입력하세요");
				$("#subject").focus();
				return;
			}
			if($("textarea[name='contents']").val()==''){
				alert("내용을 입력하세요");
				$("textarea[name='contents']").focus();
				return;
			}
			if($("#pass").val()==''){
				alert("비밀번호을 입력하세요");
				$("#pass").focus();
				return;
			}

			$("#pds").submit();
		});
		
		$("#pds_cancle").click(function(){
			history.back();
		});

	});

</script>
