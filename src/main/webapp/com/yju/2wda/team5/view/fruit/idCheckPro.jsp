<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center"></div>
   <h3>* 아이디 중복 확인 결과 *</h3>
<%
 	int result = (Integer) request.getAttribute("result"); 
	String mem_id = (String) request.getAttribute("id");
	
	if(result == 1) {
		out.println("<p style='color: red'>해당 아이디는 사용하실 수 없습니다.</p>");
	} else {
		out.println("<p>사용 가능한 아이디입니다.</p>");
	    out.println("<a href='javascript:apply(\"" + mem_id + "\")'>[적용]</a>");
%>

<script>
          function apply(mem_id){
               //2) 중복확인 id를 부모창에 적용
               //부모창 opener
               opener.document.regForm.mem_id.value=mem_id;
               opener.document.regForm.idDuplication.value="idCheck";
               window.close(); //창닫기
           }//apply () end
       </script>
      <%}%>
 <hr>
 <a href="javascript:history.back()">[다시시도]</a>
 &nbsp; &nbsp;
 <a href="javascript:window.close()">[창닫기]</a>
</body>
</html>