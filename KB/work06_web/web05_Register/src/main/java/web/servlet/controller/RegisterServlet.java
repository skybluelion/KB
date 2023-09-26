package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리... 양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2. 폼값 받아서
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		//3. Member 객체 생성
		Member dto = new Member(name, age, address);
		
		//4. 비지니스 로직 호출 했다 치고
		
		//5. dto 객체를 Attribute에 바인딩
		request.setAttribute("dto", dto);
		
		//6. 결과페이지로 바로 이동
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	}

}
