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
<link rel="stylesheet" href="<%=workDir%>/CSS/basket.css">
</head>
<body>
<%@ include file="/com/yju/2wda/team5/view/fruit/header.jsp" %>
<h2>구매내역</h2>
<hr>
<%
	PurchaseDTO purchase;
	ArrayList<PurchaseDTO> purchaseList;
	
	purchaseList = (ArrayList<PurchaseDTO>)request.getAttribute("purchaseList");
%>
<table class="table">
  <thead>
    <tr>
      <th scope="col" class="table-secondary">구매날짜</th>
      <th scope="col" class="table-secondary">상품이미지</th>
      <th scope="col" class="table-secondary">상품명</th>
      <th scope="col" class="table-secondary">판매가</th>
      <th scope="col" class="table-secondary">수량</th>
      <th scope="col" class="table-secondary">결제상태</th>
    </tr>
  </thead>
  <tbody>
<%
	for(int i=0; i<purchaseList.size(); i++) {
		purchase = purchaseList.get(i);
%>
    <tr>
      <th><%=purchase.getPurchase_date()%></th>
      <td>
      	<div class="img">
      		<img src="<%=imgDir%>/<%=purchase.getPurchase_sm_image()%>" class="img-thumbnail" alt="">
      	</div>
      </td>
      <td><%=purchase.getPurchase_name()%></td>
      <td><%=purchase.getPurchase_price()%>원</td>
      <td><%=purchase.getPurchase_count()%></td>
      <td><%=purchase.getPurchase_state()%></td>
    </tr>
<%
	}
%>
  </tbody>
</table>
</body>
</html>