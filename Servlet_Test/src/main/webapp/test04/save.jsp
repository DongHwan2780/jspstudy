<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
    request.setCharacterEncoding("UTF-8");
  
    String writer = request.getParameter("writer");
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    
    String uploadPath = application.getRealPath("upload");
    
    File uploadDir = new File(uploadPath);
    if(!uploadDir.exists()){
      uploadDir.mkdirs();
    }
        
    String uploadName = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()) + "-" + writer + "-" + title + ".txt";
    
    session.setAttribute("uploadName", uploadName);
    
    File uploadFile = new File(uploadDir, uploadName);
    BufferedWriter bw = new BufferedWriter(new FileWriter(uploadFile));
    
    bw.write(contents);
    bw.flush();
    bw.close(); 
    response.sendRedirect(request.getContextPath() + "/test04/confirm.jsp");
  %>
