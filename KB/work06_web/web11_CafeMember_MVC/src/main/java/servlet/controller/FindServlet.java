package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성
		/*
		 	1. 양방향 한글처리
		 	2. 폼값을 받는다.
		 	3. 폼값을 가지고 VO객체 생성 / 폼값 안받는 경우 생략
		 	4. DAO 리턴 받아서 비지니스 로직 호출
		 	5. Attribute 바인딩 / 반환 값 없을 땐 생략됨
		 	6. 페이지 네비게이션
		 */
		//1. 양방향 한글처리
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        //2. 폼값 받아서
        String id = request.getParameter("id");
        
        //3. DAO리턴 받고 비지니스 로직 호출... 반환값있다.
        //4. 반환값을 바인딩
        try {
        	MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
        	request.setAttribute("vo", rvo);
        } catch (Exception e) {
        	
        }
        
        //5. 페이지 이동... find_ok.jsp / find_fail.jsp 생략
        request.getRequestDispatcher("find_ok.jsp").forward(request, response);

	}
}
