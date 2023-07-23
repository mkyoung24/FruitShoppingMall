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
</head>
<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 class="mb-3">상품등록 페이지</h1>
        <hr>
        <form class="validation-form" method="post" action="./prodUpload.be" enctype="multipart/form-data" name="prodForm" onsubmit="return prod()">
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">상품이름</label>
              <input type="text" class="form-control" id="prod_name" name="prod_name" placeholder="" value="" required>
            </div>
          </div>
		  <div class="mb-3">
			<label for="name">상품가격</label>
            <input type="text" class="form-control" id="prod_price" name="prod_price" placeholder="" value="" required>	
		  </div>
		  <div class="mb-3">
			<label for="name">상품종류</label>
            <select class="form-control" name="prod_kind">
  				<option value="컵과일">컵과일</option>
  				<option value="과일도시락">과일도시락</option>
			</select>	
		  </div>
          <div class="mb-3">
            <label for="email">상품설명</label>
            <input type="text" class="form-control" id="prod_description" name="prod_description" placeholder="" >
          </div>
          <div class="mb-3">
            <label for="email">파일명</label>
            <input type="file" class="form-control-file" name="file1" placeholder="" >
          </div>
          <button class="btn btn-primary btn-lg btn-block" type="submit" >상품업로드</button>
        </form>
      </div>
    </div>
  </div>
<script>
function prod() {
	var pf = document.prodForm;
	var name = pf.prod_name.value;
	var price = pf.prod_price.value;
	var des = pf.prod_description.value;
	var file = pf.file1.value;
	
	var priceCheck = /^[0-9+]*$/;
	var nameCheck = /^[ㄱ-ㅎ|가-힣|0-9|a-z|A-Z|\s]+$/;
	var desCheck = /^[ㄱ-ㅎ|가-힣|0-9|\s]+$/;
	
	if(!nameCheck.test(name)) {
		alert('올바른 상품명이 아닙니다.');
		return false;
	} else if(!priceCheck.test(price)) {
		alert('가격에 숫자만 기입할수 있습니다.');
		return false;
	} else if(!desCheck.test(des)) {
		alert('올바른 상품설명이 아닙니다.');
		return false;
	} else if(!file) {
		alert('파일을 업로드 해주세요');
		return false;
	} else {
		return true;
	}
}
</script>
</body>
</html>