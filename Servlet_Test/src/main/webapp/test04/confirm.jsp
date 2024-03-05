<%@page import="java.io.File"%>
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
  out.println("<script>alert('" + session.getAttribute("uploadName")+ " 파일이 생성되었습니다."  +"');</script>");
%>
  
</body>
</html>