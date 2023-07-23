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
<link rel="stylesheet" href="<%=workDir%>/CSS/cupFruit.css">
</head>
<body>
<%@ include file="/com/yju/2wda/team5/view/fruit/header.jsp" %>
<%
	ProdDTO prod;
	ArrayList<ProdDTO> fruitList;
	FruitPageInfoVO fpiVO;
	
	fpiVO = (FruitPageInfoVO)session.getAttribute("fruitPageInfoVO");
	fruitList = (ArrayList<ProdDTO>)request.getAttribute("fruitList");
	
	int currentPageNo = fpiVO.getCurrentPageNo();
%>
<div class="display">
<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link" href="<%=fruitViewDir%>/main.jsp">Menu</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="./cupFruitList.be">컵과일</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="./fruitBoxList.be">과일 도시락</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">컵과일 제작</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">과일 도시락 제작</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">고객센터</a>
  </li>
</ul>
<hr>
<form class="d-flex" method="post" action="./cupFruitList.be">
   <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="keyword">
   <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<div class="prod">
<%
for(int i=0; i<fruitList.size(); i++) {
	prod = fruitList.get(i);
%>
	<div class="product">
		<div class="product_image">
			<a href="./prodList.be?prod_num=<%=prod.getProd_num()%>"><img src="<%=imgDir%>/<%=prod.getProd_sm_image()%>" class="img-thumbnail"alt=""></a>
		</div>
		<div class="product_name"><strong><%=prod.getProd_name()%></strong></div>
		<div class="product_price"><strong><%=prod.getProd_price()%>원</strong></div>
	</div>
<%
	}
%>
</div>

<div class="link">
<a href="./cupFruitList.be?currentPageNo=0&keyword=<%=request.getAttribute("keyword")%>">[FIRST]</a>
<%
	if(currentPageNo > 0) {
%>
	<a href="./cupFruitList.be?currentPageNo=<%=(currentPageNo-1)%>&keyword=<%=request.getAttribute("keyword")%>">[PRE]</a>
<%
	}else{
%>
	[PRE]
<%
	}

	for(int i = fpiVO.getStartPageNo(); i<fpiVO.getEndPageNo(); i++) {
		if(i == currentPageNo ) {

%>
			[<%=(i+1)%>]
<%
		}else{
%>
			<a href="./cupFruitList.be?currentPageNo=<%=i%>&keyword=<%=request.getAttribute("keyword")%>">[<%=(i+1)%>]</a>
<%
		}
	}
%>

<%
	if(currentPageNo < fpiVO.getPageCnt() - 1) {
%>
	<a href="./cupFruitList.be?currentPageNo=<%=(currentPageNo+1)%>&keyword=<%=request.getAttribute("keyword")%>">[NXT]</a>
<%
	} else {
%>
	[NXT]
<%
	}
%>
<a href="./cupFruitList.be?currentPageNo=<%=(fpiVO.getPageCnt()-1)%>&keyword=<%=request.getAttribute("keyword")%>">[END]</a>
</div>
</body>
</html>