<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link rel="stylesheet" href="<%=workDir%>/CSS/header.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
	if( session.isNew()){
		session.setAttribute("loginState", "logout");
		session.setAttribute("userID", null);
		session.setAttribute("userPW", null);
	}
%>

<%
	if(session.getAttribute("loginState").equals("login")) {
		if((int)session.getAttribute("class") == 900) {
%>
<div class="logo_area">
	<div class="logo_area1">
		<div class="logo_image">
			<a href="<%=fruitViewDir%>/main.jsp"><img src="<%=imgDir%>/과일로고.jpg" style = "width:72px; height:72px;"/></a>
		</div>
		<div class="logo_title">푸릇마켓</div>
	</div>
	<div class="logo_area2">
		<div><%=session.getAttribute("userID")%>관리자님 로그인중</div>
		<div class="logo_area6">
			<form method="post" action="./logout.be">
    			<input type="submit" class="btn btn-outline-success" value="로그아웃">
			</form>
		</div>
		<div class="logo_area3">
			<a href="./getMemberListDisplay.be">회원정보관리</a>
		</div>
		<div class="logo_area4">
			<a href="./productListDisplay.be">상품관리</a>
		</div>
		<div class="logo_area5">
			<a href="<%=fruitViewDir%>/productRegister.jsp">상품등록</a>
		</div>
		<div class="logo_area4">
			<a href="./basketListDisplay.be?id=<%=session.getAttribute("userID")%>">장바구니</a>
		</div>
		<div class="logo_area5">
			<a href="./purchaseListDisplay.be?id=<%=session.getAttribute("userID")%>">구매내역</a>
		</div>
	</div>
</div>
<%		
		} else {
%>
<div class="logo_area">
	<div class="logo_area1">
		<div class="logo_image">
			<a href="<%=fruitViewDir%>/main.jsp"><img src="<%=imgDir%>/과일로고.jpg" style = "width:72px; height:72px;"/></a>
		</div>
		<div class="logo_title">푸릇마켓</div>
	</div>
	<div class="logo_area2">
		<div><%=session.getAttribute("userID")%>회원님 로그인중</div>
		<div class="logo_area6">
			<form method="post" action="./logout.be">
    			<input type="submit" class="btn btn-outline-success" value="로그아웃">
			</form>
		</div>
		<div class="logo_area3">
			<a href="./getMember.be?id=<%=session.getAttribute("userID")%>">회원정보</a>
		</div>
		<div class="logo_area4">
			<a href="./basketListDisplay.be?id=<%=session.getAttribute("userID")%>">장바구니</a>
		</div>
		<div class="logo_area5">
			<a href="./purchaseListDisplay.be?id=<%=session.getAttribute("userID")%>">구매내역</a>
		</div>
	</div>
</div>
<% 
		}
	} else {		
%>
<div class="logo_area">
	<div class="logo_area1">
		<div class="logo_image">
			<a href="<%=fruitViewDir%>/main.jsp"><img src="<%=imgDir%>/과일로고.jpg" style = "width:72px; height:72px;"/></a>
		</div>
		<div class="logo_title">푸릇마켓</div>
	</div>
	<div class="logo_area2">
		<form method="post" action="./login.be">
			<label for="id" class="">아이디</label>
    		<input type="text" class="" id="mem_id" name="mem_id" placeholder="아이디" required>
    		<label for="passwd" class="">비밀번호</label>
    		<input type="password" class="" id="mem_pw" name="mem_pw" placeholder="비밀번호" required>
    		<input type="submit" class="btn btn-outline-success" value="로그인">
		</form>
		<div class="logo_area3">
			<button type="button" onClick="location.href='<%=fruitViewDir%>/register.jsp'" class="btn btn-outline-success">회원가입</button>
		</div>
	</div>
</div>

<%	
	
		if(session.getAttribute("loginState").equals("errorID")){
				out.print("<script>alert('아이디가 틀렸습니다.')</script>");
			}
			
			if(session.getAttribute("loginState").equals("errorPW")){
				out.print("<script>alert('비밀번호가 틀렸습니다.')</script>");
			}
			
		}
%>
<hr> 
</body>
</html>