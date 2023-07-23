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
	ProdDTO prod = (ProdDTO)request.getAttribute("prod");
%>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h1 class="mb-3">상품정보 수정</h1>
        <hr>
        <form class="validation-form" method="post" action="./prodUpdate.be">
          <div class="row">
          <div class="col-md-6 mb-3">
              <label for="name">상품번호</label>
              <input type="text" class="form-control" id="prod_num" name="prod_num" placeholder="" value="<%=prod.getProd_num()%>" readonly>
            </div>
            <div class="col-md-6 mb-3">
              <label for="name">상품이름</label>
              <input type="text" class="form-control" id="prod_name" name="prod_name" placeholder="" value="<%=prod.getProd_name()%>" required>
            </div>
          </div>
		  <div class="mb-3">
			<label for="name">상품가격</label>
            <input type="text" class="form-control" id="prod_price" name="prod_price" placeholder="" value="<%=prod.getProd_price()%>" required>	
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
            <input type="text" class="form-control" id="prod_description" name="prod_description" placeholder="" value="<%=prod.getProd_description()%>">
          </div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">상품 수정</button>
        </form>
      </div>
    </div>
  </div>
</body>
</html>