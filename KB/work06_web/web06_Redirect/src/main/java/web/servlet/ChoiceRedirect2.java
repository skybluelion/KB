package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect2")
public class ChoiceRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		   폼값 받아서...
		   1) 에러가 발생하는 경우(선택안한 경우)... 에러페이지(html 정적인 문서)로 연결--> redirect
		   2) 에러가 발생하지 않는 경우... 결과페이지(jsp) 연결 --> forward
		 */
		String city = request.getParameter("city");
		if(city!=null)
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		else
			response.sendRedirect("./error/error2.html");
	}

}
