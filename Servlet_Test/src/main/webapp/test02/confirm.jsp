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
    int answer = Integer.parseInt(request.getParameter("answer"));
    
    out.println("<script>alert('" + answer  +"');</script>");
  %>
</body>
</html>