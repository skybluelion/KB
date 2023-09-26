package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 양방향 한글처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        /*
         2. 폼값을 받는다.
		 3. 폼값을 가지고 VO객체 생성
		 4. DAO 리턴 받아서 비지니스 로직 호출 반환값 있음
		 5. session 받아와서 session에 바인딩 ... (req, session, context)
		 6. 페이지 네비게이션
         */
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String path = "index.html";
        
        try {
			MemberVO rvo = MemberDAOImpl.getInstance().login(id, password);
			HttpSession session=request.getSession();
			if(rvo!=null) { //null인 경우 바인딩 진행 안하도록...
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID : "+session.getId());
				
			}
			path = "login_result.jsp";
		} catch (Exception e) {
			path = "login_fail.jsp";
			System.out.println(e);
		}
        request.getRequestDispatcher("login_result.jsp").forward(request, response);
	}

}
