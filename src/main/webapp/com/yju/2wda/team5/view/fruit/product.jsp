<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mky20_mvc_fruit.model.fruit.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<link rel="stylesheet" href="<%=workDir%>/CSS/product.css">
</head>
<body>
<%@ include file="/com/yju/2wda/team5/view/fruit/header.jsp" %>
<%
	ProdDTO prod = (ProdDTO)request.getAttribute("prod");
%>

<%
	if(session.getAttribute("loginState").equals("login")) {
%>
<div id="app">
	<div class="product_view">
		<h2><%=prod.getProd_name()%></h2>
		<table>
			<colgroup>
			<col style="width:200px;">
			<col>
			</colgroup>
			<tbody>
			<tr>
				<td>판매가</td>
				<td class="price" id="price">{{prod.price}}원</td>
			</tr>
			<tr>
				<td>상품종류</td>
				<td><%=prod.getProd_kind()%></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><%=prod.getProd_description()%></td>
			</tr>
			<tr>
				<td>수량</td>
				<td>
					<div class="length">
						<input v-model="prod.count" readonly>
						<a href="#a" v-on:click="prod.count += 1"></a>
						<a href="#a" v-on:click="minusCount"></a>
					</div>
				</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>무료배송</td>
			</tr>
			<tr>
				<td>결제금액</td>
				<td class="total">{{prod.price * prod.count}}원</td>
			</tr>
			</tbody>
		</table>
		<div class="img">
			<img src="<%=imgDir%>/<%=prod.getProd_image()%>" alt="">
		</div>
		<form method="" action="" name="list">
			<input type="hidden" name="id" v-model="prod.id">
			<input type="hidden" name="num" v-model="prod.num">
			<input type="hidden" name="count" v-model="prod.count">
			<input type="hidden" name="price" v-model="prod.price">
				<div class="btns">
					<button type="submit" class="btn btn-primary" v-on:click="basket">장바구니 담기</button>
					<button type="submit" class="btn btn-secondary" v-on:click="purchase">구매하기</button>
				</div>
		</form>
	</div>
</div>
<%
	} else {
%>
<div id="app">
	<div class="product_view">
		<h2><%=prod.getProd_name()%></h2>
		<table>
			<colgroup>
			<col style="width:200px;">
			<col>
			</colgroup>
			<tbody>
			<tr>
				<td>판매가</td>
				<td class="price" id="price">{{prod.price}}원</td>
			</tr>
			<tr>
				<td>상품종류</td>
				<td><%=prod.getProd_kind()%></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><%=prod.getProd_description()%></td>
			</tr>
			<tr>
				<td>수량</td>
				<td>
					<div class="length">
						<input v-model="prod.count" readonly>
						<a href="#a" v-on:click="prod.count += 1"></a>
						<a href="#a" v-on:click="minusCount"></a>
					</div>
				</td>
			</tr>
			<tr>
				<td>배송비</td>
				<td>무료배송</td>
			</tr>
			<tr>
				<td>결제금액</td>
				<td class="total">{{prod.price * prod.count}}원</td>
			</tr>
			</tbody>
		</table>
		<div class="img">
			<img src="<%=imgDir%>/<%=prod.getProd_image()%>" alt="">
		</div>
		<div class="btns">
			<a href="#" class="btn2" v-on:click="login">장바구니 담기</a>
			<a href="#" class="btn1" v-on:click="login">구매하기</a>
		</div>
		
<%
	}
%>
<script type="text/javascript">
	let webstore = new Vue({
		el: '#app',
		data: {
			prod: {
				id: '<%=session.getAttribute("userID")%>',
				num: '<%=prod.getProd_num()%>',
				price: '<%=prod.getProd_price()%>',
				count: 1,
			}
		},
		methods: {
			minusCount() {
		        if(this.prod.count > 1) {
		          this.prod.count -= 1;
		        } else {
		          this.prod.count = 1;
		        }
		        return this.prod.count;
		    },
		    login() {
		    	  alert('로그인을 하세요');
		    },
		    basket() {
		    	var bas = document.list;
		    	bas.action = "./insertBasket.be";
		    	bas.method = "post";
		    },
		    purchase() {
		    	var pur = document.list;
		    	pur.action = "./purchaseDir.be";
		    	pur.method = "post";
		    }
		    
		}
	});
</script>
</body>
</html>