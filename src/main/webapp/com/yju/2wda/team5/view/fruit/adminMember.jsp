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
<h2>회원 관리</h2>
<hr>
<%
	MemberDTO member;
	ArrayList<MemberDTO> memberList;
	
	memberList = (ArrayList<MemberDTO>)request.getAttribute("memberList");
%>

<table class="table">
  <thead>
    <tr>
      <th scope="col" class="table-secondary">회원이름</th>
      <th scope="col" class="table-secondary">회원아이디</th>
      <th scope="col" class="table-secondary">회원비밀번호</th>
      <th scope="col" class="table-secondary">회원번호</th>
      <th scope="col" class="table-secondary">회원주소</th>
      <th scope="col" class="table-secondary">회원전화번호</th>
      <th scope="col" class="table-secondary">회원등급</th>
      <th scope="col" class="table-secondary">회원등급 수정</th>
    </tr>
  </thead>
  <tbody>
<%
	for(int i=0; i<memberList.size(); i++) {
		member = memberList.get(i);
		String admin;
		if(member.getMem_class() == 900) {
			admin = "관리자";
		} else {
			admin = "일반회원";
		}
%>
    <tr>
      <td><%=member.getMem_name()%></td>
      <td><%=member.getMem_id()%></td>
      <td><%=member.getMem_pw()%></td>
      <td><%=member.getMem_num()%></td>
      <td><%=member.getMem_address()%></td>
      <td><%=member.getMem_phone()%></td>
      <td><%=admin%></td>
      <td><a href="./memberClassUpdate.be?id=<%=member.getMem_id()%>&admin=<%=member.getMem_class()%>">UPDATE</a></td>
    </tr>
<%
	}
%>
  </tbody>
</table>
</body>
</html>