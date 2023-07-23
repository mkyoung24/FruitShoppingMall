<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기말 쇼핑몰 프로젝트</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link rel="stylesheet" href="<%=workDir%>/CSS/main.css">
</head>
<body>
<%@ include file="/com/yju/2wda/team5/view/fruit/header.jsp" %>
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
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<%=imgDir%>/과일배경1.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>과일 효능</h5>
        <p>피로 해소,노화방지에 포도,사과,자몽,키위,파인애플,매실,살구,자두,딸기,레몬,감귤류</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="<%=imgDir%>/과일배경2.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>과일 효능</h5>
        <p>심혈관계보호에 바나나,수박,석류,호두,아보카도,망고,멜론,참외,귤,토마토,키위</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="<%=imgDir%>/과일배경3.jpg" class="d-block w-100" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>과일 효능</h5>
        <p>감기에는 감,귤,금귤,키위,레몬,딸기,유자,모과</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</body>
</html>