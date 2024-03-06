<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%-- 
    <c:if>
    1. else 개념이 없는 if 문 태그이다.
    2. 형식
      <c:if test="조건식">
        실행문
      </c:if>
   --%>
   
  <c:set var="age" value="<%=(int)(Math.random()*100 + 1)%>"/>
  <c:if test="${age >= 20}">
    <div>${age}살은 성인입니다.</div>
  </c:if>
  <c:if test="${age < 20}">
    <div>${age}살은 미성년자입니다.</div>
  </c:if>

  <c:set var="score" value="<%=(int)(Math.random()*101)%>"/>
  <c:if test="${score ge 90 }">
    <div>${score}점은 A등급입니다.</div>
  </c:if>
  <c:if test="${score ge 80 and score lt 90}">
    <div>${score}점은 B등급입니다.</div>
  </c:if>
  <c:if test="${score ge 70 and score lt 80}">
    <div>${score}점은 C등급입니다.</div>
  </c:if>
  <c:if test="${score ge 60 and score lt 70}">
    <div>${score}점은 D등급입니다.</div>
  </c:if>
  <c:if test="${score ge 50 and score lt 60}">
    <div>${score}점은 E등급입니다.</div>
  </c:if>
  <c:if test="${score lt 50 }">
    <div>${score}점은 F등급입니다.</div>
  </c:if>

</body>
</html>