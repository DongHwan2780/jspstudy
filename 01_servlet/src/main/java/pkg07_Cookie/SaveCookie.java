package pkg07_Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Servlet implementation class SaveCookie
 */
public class SaveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("name");
	  String email = request.getParameter("email");
	  
	  // 쿠키 만들기(쿠키 이름, 유지 시간, 저장 경로)
	  Cookie cookie1 = new Cookie("name", URLEncoder.encode(name, "UTF-8"));     // 쿠키 값은 String 타입. 공백 등 쿠키 값으로 사용할 수 없는 문자가 있어서 인코딩 후 저장
	  Cookie cookie2 = new Cookie("email", URLEncoder.encode(email, "UTF-8"));
	  
	  // 쿠키 유지 시간
	  cookie1.setMaxAge(60 * 60 * 24 * 15);  // 15일
	  
	  // cookie2.setMaxAge(60);    // 생략하면 세션 쿠키가 된다(브라우저를 닫으면 지워지는 쿠키)
	  
	  // 쿠키 저장 경로 (생략하면 ContextPath가 경로로 사용)
	  cookie1.setPath("/servlet"); // ContextPath, cookie1.setPath(request.getContextPath())
	  cookie2.setPath("/servlet/saveCookie"); // URLMapping, cookie2.setPath(request.getRequestURI())
	  
	  // 쿠키 저장 (응답)
	  response.addCookie(cookie1);
	  response.addCookie(cookie2);
	  
	  // ReadCookie servlet으로 이동하기
    response.sendRedirect(request.getContextPath() + "/readCookie");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
