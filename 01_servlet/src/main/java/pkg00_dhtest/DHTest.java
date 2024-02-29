package pkg00_dhtest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DHTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  
	  int colorNum = Integer.parseInt(request.getParameter("color"));
	  String color[] = {"red", "orange", "yellow", "green", "blue", "darkblue", "purple"};
	  //String text = request.getParameter("text");
	  
	  //out.println(text);
	  
    out.println("<html>");
    out.println(" <body>");
    out.println(" <div>");
    out.println(" <h3 style=\"color:" + color[colorNum] + "\">복습할겸 만들어보는 무지개 놀이</h3>");
    out.println(" </div>");
    out.println(" </body>");
    out.println("</html>");
	 

    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
