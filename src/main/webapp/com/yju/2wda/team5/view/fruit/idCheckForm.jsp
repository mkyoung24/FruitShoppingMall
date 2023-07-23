<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div style="text-align: center">
   <h3>* 아이디 중복확인 *</h3>
    <form method="get" action="./idCheck.be" onsubmit="return blankCheck(this)">
    아이디 : <input type="text" name="mem_id" id="mem_id" maxlength="30" value="" autofocus>
    <input type="submit" value="중복확인">
    </form>
    </div>
    
<script>
   function blankCheck(f){
       var mem_id=f.mem_id.value;
       mem_id=mem_id.trim();
        if(mem_id.length<4){
           alert("4~30자의 숫자 , 문자로만 사용 가능합니다.");
            return false;
        }//if end
        return true;
    }//blankCheck() end
    
  //아이디 정규식
</script>
 </body>
 </html>
</html>