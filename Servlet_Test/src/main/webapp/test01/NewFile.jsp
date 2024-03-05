<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
  
</style>

</head>
<body>
<% String contextPath = request.getContextPath(); %>
  <form method="POST"
      action="<%=contextPath%>/test01/confirm.jsp">
   <div>아이디</div>
    <input type="text" id="id" name="id">@naver.com
    <div>비밀번호</div>
    <input type="password" id="pw" name="pw">
   <div>비밀번호 재확인</div>
    <input type="password" id="repw" name="repw">
    <div>이름</div>
    <input type="text" id="name" name="name">
    <div>생년월일</div>
     <input type="text" id="year" name="year" placeholder="년(4자)">
     <select name="month">
        <% for(int m = 1; m <= 12; m++) { %>
          <option value="<%=m%>"><%=m%>월</option>
        <% } %>
      </select>
      <input type="text" id="day" name="day" placeholder="일">
    <div>성별</div>
    <select name="gender">
      <option value="성별없음" selected>성별</option>
      <option value="남자">남</option>
      <option value="여자">녀</option>
    </select>
    <div>본인 확인 이메일(선택)</div>
    <input type="text" id="mail" name="mail" placeholder="선택입력">
    <div>휴대전화</div>
    <select name="region">
      <option value="+81">미국 +81</option>
      <option value="+82" selected>대한민국 +82</option>
      <option value="+83" >일본 +83</option>
    </select>
    <div>
    <input type="text" id="phonenum" name="phonenum" placeholder="전화번호 입력">
    <button>인증번호 받기</button>
    </div>
    <input type="text" id="rephonenum" name="rephonenum" placeholder="인증번호 입력하세요" disabled>
    <div>
      <button type="submit">가입하기</button>
    </div>
    
  </form>
</body>
</html>