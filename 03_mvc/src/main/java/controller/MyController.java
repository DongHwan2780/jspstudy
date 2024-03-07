package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MyInterface;
import model.MyInterfaceImpl;

import java.io.IOException;

import common.ActionForward;

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  request.setCharacterEncoding("UTF-8");
	  
	  String requestURI = request.getRequestURI();
	  String contextPath = request.getContextPath();
	  String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());
	  
	  /*   MyInterface 타입의 MyInterfaceImpl 객체 생성   */
	  MyInterface myInterface = new MyInterfaceImpl();
	  
	  /*   메소드 호출 결과(뷰 경로 + 이동 방식(forward / redirect)) 저장 객체 -> forward 로 보낼때 필요  */
	  ActionForward af = null;
	  
	  /*   요청에 따른 메소드 호출   */
	  switch(urlMapping)
	  {
	  case "/getDate.do":
	    af = myInterface.getDate(request);
	    System.out.println(request.getAttribute("date"));
	    break;
	  case "/getTime.do":
	    af = myInterface.getTime(request);
	    System.out.println(request.getAttribute("time"));
	    break;
	  case "/getDateTime.do":
	    af = myInterface.getDateTime(request);
	    System.out.println(request.getAttribute("datetime"));
	    break;
	  }
	  
	  /*   어디로 어떻게 이동하는지 결정    */
	  if(af != null)
	  {
	    if(af.isRedirect())
	      response.sendRedirect(af.getView());
	    else
	      request.getRequestDispatcher(af.getView()).forward(request, response);
	  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
 