package web.servlet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import web.servlet.dto.ParameterDto;

@WebServlet("/postParams")
public class PostParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PostParamsServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // need with POST
		response.setContentType("text/html; charset=utf-8");
		
		// 파라미터 처리하기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String hobby[] = request.getParameterValues("hobby");
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");

		// 서버 출력
		System.out.println("name : " + name);
		System.out.println("email : " + email);
		System.out.println("gender : " + gender);
		System.out.println("hobby : " + Arrays.toString(hobby));
		System.out.println("favorite : " + favorite);
		System.out.println("desc : " + desc);
		
		// 1.ParrameterDto 객체 생성
		ParameterDto parameterDto = new ParameterDto(name, email, gender, hobby, favorite, desc);

		// 2. request 에 바인딩
		request.setAttribute("parameterDto",  parameterDto);
		
		// 3. 페이지 네비게이션...postResult.jsp 페이지로 이동
		request.getRequestDispatcher("postResult.jsp").forward(request, response);
		
		

	}

}
