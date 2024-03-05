<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  request.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pw = request.getParameter("pw");
  String repw = request.getParameter("repw");
  
  String name = request.getParameter("name");
  
  String year = request.getParameter("year");
  String month = request.getParameter("month");
  String day = request.getParameter("day");
  
  String gender = request.getParameter("gender");
  String mail = request.getParameter("mail");
  
  String region = request.getParameter("region");
  String phonenum = request.getParameter("phonenum");
  String rephonenum = request.getParameter("rephonenum");

  out.println("<ul>");
  out.println("<li>아이디:" + id + "</li>");
  out.println("<li>비밀번호:" + pw + "</li>");
  out.println("<li>이름:" + name + "</li>");
  out.println("<li>생년월일:" + year + "년" + month + "월" + day + "일" + "</li>");
  out.println("<li>성별:" + gender + "</li>");
  out.println("<li>이메일:" + mail + "</li>");
  out.println("<li>휴대전화:" + region + " " + phonenum + "</li>");
  out.println("</ul>");
%>
</body>
</html>