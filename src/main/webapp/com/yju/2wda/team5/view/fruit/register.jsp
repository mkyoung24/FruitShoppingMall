<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link rel="stylesheet" href="<%=workDir%>/CSS/register.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script type="text/javascript">
function idCheck(){
    //새창 만들기
    window.open("/mky20_mvc_shoppingMall/com/yju/2wda/team5/view/fruit/idCheckForm.jsp", "idwin", "width=400, height=350");
 }

</script>
</head>
<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 class="mb-3">회원가입</h1>
        <hr>
        <form class="validation-form" method="post" action="./insertMember.be" name="regForm" onsubmit="return formCheck()">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="mem_name" name="mem_name" placeholder="" value="" required>
            </div>
          </div>
		  <div class="mb-3">
			<label for="name">아이디</label>
            <input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="" value="" required>	
            <button class="btn btn-primary" type="submit" onclick="idCheck()">아이디 중복 체크</button>
            <input type="hidden" name="idDuplication" value="idUnCheck"/>
		  </div>
		  <div class="mb-3">
			<label for="name">비밀번호</label>
            <input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="" value="" required>	
		  </div>
		  <div class="mb-3">
			<label for="name">비밀번호 확인</label>
            <input type="password" class="form-control" id="mem_pw2" name="mem_pw2" placeholder="비밀번호를 한번 더 입력해주세요" value="" required>	
		  </div>
          <div class="mb-3">
            <label for="email">휴대폰 번호</label>
            <input type="text" class="form-control" id="mem_phone" name="mem_phone" placeholder="ex)010-xxxx-xxxx" required>
          </div>
          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" id="mem_address" name="mem_address" placeholder="ex)서울특별시 강남구" required>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
        </form>
      </div>
    </div>
  </div>
<script type="text/javascript">
	function formCheck() {
		var joinForm = document.regForm;
		var name = joinForm.mem_name.value;
		var pw1 = joinForm.mem_pw.value;
		var pw2 = joinForm.mem_pw2.value;
		var phone = joinForm.mem_phone.value;
		var address = joinForm.mem_address.value;
		var nameCheck = /^[가-힣]{2,4}$/;
		var phoneCheck = /^(01[016789])-([0-9]{3,4})-([0-9]{4})+$/;
		var addrCheck = /^[ㄱ-ㅎ|가-힣|0-9|\s]+$/;
		var pwCheck = /^[A-Za-z0-9]{6,12}$/;
		
		if(!nameCheck.test(name)) {
			alert('한글 이름 2~4자 이내로 입력하세요.');
			return false;
		} else if(pw1 != pw2) {
			alert('비밀번호가 맞지 않습니다.');
			return false;
		} else if(joinForm.idDuplication.value != "idCheck") {
			alert('아이디 중복체크를 해주세요.')
			return false;
		} else if(!phoneCheck.test(phone)) {
			alert('전화번호는 숫자 및 -만 사용가능합니다.');
			return false;
		} else if(!addrCheck.test(address)) {
			alert('올바른 주소가 아닙니다.');
			return false;
		} else if(!pwCheck.test(pw1)) {
			alert("6~12자의 숫자 , 영어와 숫자만 사용 가능합니다.");
			return false;
		} else {
			return true;
		}
	}
</script>
</body>
</html>