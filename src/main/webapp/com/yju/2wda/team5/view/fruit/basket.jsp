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
<%
	BasketDTO basket;
	ArrayList<BasketDTO> basketList;
	
	basketList = (ArrayList<BasketDTO>)request.getAttribute("basketList");
%>
<h2>장바구니</h2>
<hr>
<table class="table">
  <thead>
    <tr>
      <th scope="col" class="table-secondary">상품이미지</th>
      <th scope="col" class="table-secondary">상품명</th>
      <th scope="col" class="table-secondary">판매가</th>
      <th scope="col" class="table-secondary">수량</th>
      <th scope="col" class="table-secondary">합계</th>
      <th scope="col" class="table-secondary">선택</th>
    </tr>
  </thead>
  <tbody>
<%
	int sum = 0;
	for(int i=0; i<basketList.size(); i++) {
		basket = basketList.get(i);
%>
    <tr>
      <td>
      	<div class="img">
      		<img src="<%=imgDir%>/<%=basket.getShop_sm_image()%>" class="img-thumbnail" alt="">
      	</div>
      </td>
      <td><%=basket.getShop_name()%></td>
      <td><%=basket.getShop_price()%>원</td>
      <td><%=basket.getShop_amount()%></td>
      <td><%=basket.getShop_total_price()%>원</td>
<%
		sum += basket.getShop_total_price();
%>
      <td>
      	<a href="./deleteBasketForID.be?id=<%=basket.getShop_id()%>&num=<%=basket.getShop_num()%>" class="btn-close" aria-label="Close" ></a>
      </td>
    </tr>
<%
	}
%>
    <tr>
      <th></th>
      <td colspan="3">총 금액</td>
      <td colspan="3"><%=sum%>원</td>
    </tr>
  </tbody>
</table>
<br>
		<div class="btns">
			<button type="button" onclick="check()" class="btn btn-secondary">주문</button>
			<a href="./deleteBasketList.be?id=<%=session.getAttribute("userID")%>" class="btn2">삭제</a>
		</div>

</body>

<script type="text/javascript">
	function check() {
		var sum = '<%=sum%>';
		var id = '<%=(String)session.getAttribute("userID")%>';
		if(sum === '0') {
			alert('장바구니가 비어있습니다.');
		} else {
			location.href = "./purchase.be?id="+id + "&sum=" +sum;
		}
	}
</script>
</html>