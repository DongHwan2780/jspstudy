<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
    
    int num = Integer.parseInt(request.getParameter("date-time"));
    %>
    
    <% if(num == 0){ %>
      <% out.println("<script>alert('" + "요청결과는" + DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()) + " 입니다."  +"');</script>");%>
    <%} else { %>
      <% out.println("<script>alert('" + "요청결과는" + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()) + " 입니다."  +"');</script>");%>
    <%} %> 
       
</body>
</html>