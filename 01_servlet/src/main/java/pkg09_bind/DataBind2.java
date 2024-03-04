package pkg09_bind;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class DataBind2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
     * 데이터 저장 영역
     * 
     * 1 -> 3 순으로 데이터 저장 기간이 점점 짧아짐
     * 1. ServletContext      : 컨텍스트 종료(어플리케이션 실행 종료) 전까지 데이터를 유지
     * 2. HttpSession         : 세션 종료(웹 브라우저 종료) 전까지 데이터를 유지
     * 3. HttpServletRequest  : 요청 종료(응답) 전까지 데이터를 유지
     * 
     * */
    
    /*
     * 데이터 처리 메소드
     * 
     * 1. setAttribute            : Object 타입의 값을 저장
     * 2. getAttribute            : Object 타입의 값을 반환(캐스팅이 필요할 수 있음)
     * 3. removeAttribute(속성)   : 제거
     * */
    
    // HttpSession에 데이터 저장하기
	  HttpSession hs = request.getSession();
    hs.setAttribute("b", "로그인정보");
    
    // 세션 유지시간 설정하기 (디폴트 30분)
    hs.setMaxInactiveInterval(60 * 60); // 초 단위
    
    /*
     * web.xml 파일을 이용한 세션 유지시간 설정하기(30분)
     * 
     * <web-app xmlns=" version=">
     * <session-config>
     *  <session-timeout>30</session-timeout>
     * </session-config>
     * </web-app>
     * */
    
    // 세션 정보 삭제하기
    //hs.invalidate();
        
    // 데이터 확인 페이지로 이동하기
    response.sendRedirect("/servlet/dataConfirm");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
