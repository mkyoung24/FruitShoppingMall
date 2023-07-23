<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/globalData.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link rel="stylesheet" href="<%=workDir%>/CSS/register.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
	
%>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 class="mb-3">결제</h1>
        <hr>
        <form class="validation-form" method="" action="" name="checkForm">
          <div class="mb-3">
            <label for="name">이름</label>
            <input type="text" class="form-control" id="mem_name" name="mem_name" placeholder=""  required>
          </div>
          <div class="mb-3">
            <label for="phone">휴대폰 번호</label>
            <input type="text" class="form-control" id="mem_phone" name="mem_phone" placeholder="ex)010-xxxx-xxxx"  required>
          </div>
          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" id="mem_address" name="mem_address" placeholder="ex)서울특별시 강남구"  required>
          </div>
          <div class="mb-3">
            <label for="">결제 수단</label>
            <input type="radio" id="account" name="method" value="계좌이체">
            <label for="">계좌이체</label>
            <input type="radio" id="card" name="method" value="카드 결제">
            <label for="">카드 결제</label>
            <input type="radio" id="point" name="method" value="휴대폰 결제">
             <label for="">휴대폰 결제</label>
          </div>
          <div class="col-md-6 mb-3">
              <label for="name">총 결제 금액 : <%=request.getAttribute("sum")%></label>
           </div>
        </form>
     	<button type="button" onclick="check()" class="btn btn-primary btn-lg btn-block">결제하기</button>
          <div class="mb-4">
          </div>
      </div>
    </div>
  </div>
<script type="text/javascript"> 
function check() {
	var ch = document.checkForm;
	var name = ch.mem_name.value;
	var phone = ch.mem_phone.value;
	var adrr = ch.mem_address.value;
	var method = ch.method.value;
	let nameCheck = /^[가-힣]{2,4}$/;
	let phoneCheck = /^(01[016789])-([0-9]{3,4})-([0-9]{4})+$/;
	let adrrCheck = /^[ㄱ-ㅎ|가-힣|0-9|\s]+$/;
	var uid = '<%=(String)session.getAttribute("userID")%>';
	
	if(!nameCheck.test(name)) {
		alert('한글 이름 2~4자 이내로 입력하세요.');
	} else if(!phoneCheck.test(phone)) {
		alert('전화번호는 숫자와 - 만 사용가능합니다.')
	} else if(!adrrCheck.test(adrr)) {
		alert('주소 양식이 잘못되었습니다.');
	} else if(method=='') {
		alert('결제 수단을 선택하세요.');
	} else {
		location.href = "./purchaseComplete.be?id="+uid;
	}
}
</script>
</body>
</html>