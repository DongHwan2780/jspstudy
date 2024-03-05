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
  
  <% int a = (int)(Math.random() * 8 + 2);  %>
  <% int b = (int)(Math.random() * 9 + 1);  %>
    
  <form method="POST"
      action="<%=contextPath%>/test02/confirm.jsp">
  <div>
    <button onclick="window.location.reload()">새로고침</button>
  </div>  
  <div>
    <label for="answer"><%=a%> X <%=b%></label>
    <input type="text" id="answer" name="answer">
    <button type="submit">계산</button>
  </div>
  </form>
</body>
</html>