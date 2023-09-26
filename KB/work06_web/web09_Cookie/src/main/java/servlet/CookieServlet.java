package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿠키 생성
		Cookie c1 = new Cookie("id","KBStar");
		Cookie c2 = new Cookie("today","2023-04-19");
		
		//2. 
		c1.setMaxAge(24*60*60); //하루동안 브라우저에서 정보 보관 ex) 오늘 본 상품
		c2.setMaxAge(0); // 저장 x , 쿠키 사용 안함
		
		//3. 서버로 다시 보냄
		response.addCookie(c1);
		response.addCookie(c2);
		
		//4. 페이지 이동
		response.sendRedirect("getCookie.jsp"); //서버에서 만들어지고 브라우저로 갔다가 다시 서버로 이동하기 때문에 response redirect
	}

}
