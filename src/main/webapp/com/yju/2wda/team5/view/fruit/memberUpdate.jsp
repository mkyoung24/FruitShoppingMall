<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp" %>
<%@ page import="mky20_mvc_fruit.model.fruit.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link rel="stylesheet" href="<%=workDir%>/CSS/register.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
	MemberDTO member = (MemberDTO)request.getAttribute("member");
%>
<div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 class="mb-3">회원정보 수정 및 탈퇴</h1>
        <hr>
        <form class="validation-form" method="post" action="./updateMember.be" onsubmit="return updateCheck()" name="regForm">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="mem_name"  name="mem_name" placeholder="" value="<%=member.getMem_name()%>" required>
            </div>
          </div>
          <div class="mb-3">
			<label for="name">회원번호</label>
            <input type="text" class="form-control" id="mem_num"  name="mem_num" placeholder="" value="<%=member.getMem_num()%>" required readonly>	
		  </div>
		  <div class="mb-3">
			<label for="name">아이디</label>
            <input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="" value="<%=member.getMem_id()%>" required readonly>	
		  </div>
		  <div class="mb-3">
			<label for="name">비밀번호</label>
            <input type="text" class="form-control" id="mem_pw" name="mem_pw" placeholder="" value="<%=member.getMem_pw()%>" required>	
		  </div>
          <div class="mb-3">
            <label for="email">전화번호</label>
            <input type="text" class="form-control" id="mem_phone" name="mem_phone" placeholder="ex)010-1111-2222"  value="<%=member.getMem_phone()%>" required>
          </div>

          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" id="mem_address" name="mem_address" placeholder="ex)서울특별시 강남구" value="<%=member.getMem_address()%>" required>
          </div>
          <div class="mb-4">
          	<button class="btn btn-primary btn-lg btn-block" type="submit">회원 정보 수정</button>
          </div>
        </form>
        <br>
        <div class="mb-4">
          	<button class="btn btn-primary btn-lg btn-block" type="button" onclick="location.href='./deleteMember.be?id=<%=member.getMem_id()%>'">회원 탈퇴</button>
         </div>
      </div>
    </div>
  </div>
  
<script type="text/javascript">

function updateCheck() {
	var joinForm = document.regForm;
	var name = joinForm.mem_name.value;
	var pw1 = joinForm.mem_pw.value;
	var phone = joinForm.mem_phone.value;
	var address = joinForm.mem_address.value;
	var nameCheck = /^[가-힣]{2,4}$/;
	var phoneCheck = /^(01[016789])-([0-9]{3,4})-([0-9]{4})+$/;
	var addrCheck = /^[ㄱ-ㅎ|가-힣|0-9|\s]+$/;
	var pwCheck = /^[A-Za-z0-9]{6,12}$/;
	
	if(!nameCheck.test(name)) {
		alert('한글 이름 2~4자 이내로 입력하세요.');
		return false;
	}  else if(!phoneCheck.test(phone)) {
		alert('전화번호는 숫자 및 - 만 사용가능합니다.');
		return false;
	} else if(!addrCheck.test(address)) {
		alert('올바른 주소가 아닙니다.');
		return false;
	} else if(!pwCheck.test(pw1)) {
		alert("6~12자의 숫자 , 영어만 사용 가능합니다.");
		return false;
	} else {
		var cf_rs = confirm("정말로 수정하시겠습니까?")
	 	if(cf_rs)
		{	
			alert("회원 정보를 수정했습니다.");
			return true;
		}
		
		else
		{
			alert("회원 정보를 수정하지 않았습니다.")
			return false;
		}
	}
}
</script>
</body>
</html>