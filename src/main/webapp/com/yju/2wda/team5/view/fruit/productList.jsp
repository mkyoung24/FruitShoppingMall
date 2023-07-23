<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mky20_mvc_fruit.model.fruit.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="<%=workDir%>/CSS/adminMember.css">
</head>
<body>
<%@ include file="/com/yju/2wda/team5/view/fruit/header.jsp" %>
<h2>상품 관리</h2>
<hr>
<%
	ProdDTO prod;
	ArrayList<ProdDTO> prodList;
	
	prodList = (ArrayList<ProdDTO>)request.getAttribute("prodList");
%>

<table class="table">
  <thead>
    <tr>
      <th scope="col" class="table-secondary">상품번호</th>
      <th scope="col" class="table-secondary">상품명</th>
      <th scope="col" class="table-secondary">상품가격</th>
      <th scope="col" class="table-secondary">상품종류</th>
      <th scope="col" class="table-secondary">상품설명</th>
      <th scope="col" class="table-secondary">상품이미지</th>
      <th scope="col" class="table-secondary">상품썸네일이미지</th>
      <th scope="col" class="table-secondary">상품 수정</th>
      <th scope="col" class="table-secondary">상품 삭제</th>
    </tr>
  </thead>
  <tbody>
<%
	for(int i=0; i<prodList.size(); i++) {
		prod = prodList.get(i);
%>
    <tr>
      <td><%=prod.getProd_num()%></td>
      <td><%=prod.getProd_name()%></td>
      <td><%=prod.getProd_price()%></td>
      <td><%=prod.getProd_kind()%></td>
      <td><%=prod.getProd_description()%></td>
      <td><%=prod.getProd_image()%></td>
      <td><%=prod.getProd_sm_image()%></td>
      <td><a href="./productGetList.be?prod_num=<%=prod.getProd_num()%>">UPDATE</a></td>
      <td><a href="./productDelete.be?prod_num=<%=prod.getProd_num()%>">DELETE</a></td>
    </tr>
<%
	}
%>
  </tbody>
</table>
</body>
</html>