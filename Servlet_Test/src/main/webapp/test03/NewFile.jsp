<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% String contextPath = request.getContextPath(); %>
  
  <form method="POST"
      action="<%=contextPath%>/test03/confirm.jsp">
    
  <div>
    <select name="date-time">
        <option value="0">현재날짜</option>
        <option value="1">현재시간</option>
    </select>
    <button type="submit">요청하기</button>
  </div>
  </form>
    
</body>
</html>