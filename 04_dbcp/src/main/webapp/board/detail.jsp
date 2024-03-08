<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세화면</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  #contents{
    width:300px;
    height:150px;
    border: 1px solid black;
  }
</style>
</head>
<body>
  <%-- Post 쓰는 이유 == 주소값 변경 등의 편법 방지용 안전장치 --%>
  
  <div>게시글 번호 : ${board.board_no}</div>
  <div>제목 : ${board.title}</div>
  <hr>
  <div id="contents">내용 :  ${board.contents}</div> 
  <div>최종 수정일 : ${board.modified_at}</div>
  <div id="created">작성일 : ${board.created_at}</div>

  <div>
    <form id="frm-btn" method="POST">
      <input type="hidden" name="board_no" value="${board.board_no}">
      <button type="button" id="btn-edit">편집</button>
      <button type="button" id="btn-remove">삭제</button>
    </form>
  </div>

  <script>
  const frmBtn = $('#frm-btn');
  const btnEdit = $('#btn-edit');
  const btnRemove = $('#btn-remove');
  
  btnEdit.on('click', (evt)=>{
    frmBtn.attr('action', '${contextPath}/board/edit.brd');
    frmBtn.submit();
  })
  
  btnRemove.on('click', (evt)=>{
    if(confirm('게시글을 삭제할까요?')){
      frmBtn.attr('action', '${contextPath}/board/remove.brd');
      frmBtn.submit();
    }
  })
  
  </script>
</body>
</html>