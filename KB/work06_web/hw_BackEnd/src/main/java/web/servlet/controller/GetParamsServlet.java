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


@WebServlet("/getParams")
public class GetParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetParamsServlet() {
       
    }  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");
		
		// 파라미터 처리하기
		String job = request.getParameter("job");	
		String pageNo = request.getParameter("pageNo");		
		String searchWord = request.getParameter("searchWord");
		
		// 서버 출력
		System.out.println("job : " + job);
		System.out.println("pageNo : " + pageNo);
		System.out.println("searchWord : " + searchWord);
		
		// 1. Map 객체에 값 3개를 저장
		Map<String, String> map = new HashMap<>();
		map.put("job", job);
		map.put("pageNo", pageNo);
		map.put("searchWord", searchWord);
		
		// 2. request 에 객체를 바인딩
		request.setAttribute("map", map);
		
		// 3. 페이지 네비게이션...getResult.jsp페이지로 이동
        request.getRequestDispatcher("getResult.jsp").forward(request, response);

	}

}
