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
  
  <div>
    <button onclick="window.location.reload()">새로고침</button>
  </div>  
  <div>
    <label for="answer"><%=a%> X <%=b%></label>
    <input type="text" id="answer" name="answer">
    <button type="submit" onclick="func()">계산</button>
  </div>

  <script>
    function func()
    {
    	var i = <%=a%> * <%=b%>;
    	var cmp = document.getElementById('answer').value;
  	  if(i == cmp)
  		  alert("정답");
  	  else
  		  alert("오답");
    }
  </script>
</body>
</html>