package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	  클라이언트의 요청을 처리
	  get --> doGet() 호출
	  post --> doPost() 호출
	  
	  get --> doPost() 호출 :: Error Status Code 405 
	  요청방식과 servlet code가 안맞음
	 */
    public FormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");// 한글 깨지지 않게 바꿈
		
		PrintWriter out = response.getWriter();
		out.println("<h2>Get방식 요청입니다.</h2>");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		out.println("<li>"+id+"</li>");
		out.println("<li>"+name+"</li>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식의 요청은 여기서 로직을 작성한다...
		
		//한글처리(요청시, 응답시 따로따로)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");// 한글 깨지지 않게 바꿈
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		String gender = request.getParameter("gender");
		String[] techs = request.getParameterValues("tech");
		
		//받은 값을 브라우저로 출력
//		out.println("<h2>폼값에 입력된 정보들입니다.</h2>");
//		out.println("<li>아이디 : "+id+"</li>");
//		out.println("<li>비밀번호 : "+password+"</li>");
//		out.println("<li>성별 : "+gender+"</li>");
//		
//		out.println("<b> 사용기술입니다.</b><br>");
//		String tech = "";
//		for (String t : techs) tech += t+" ";
//		out.println(tech);
//		
//		out.close();
		//받은 값을 브라우저로 출력2
		StringBuffer sb = new StringBuffer();
		sb.append("<h2>ID : ").append(id).append("</h2>");
		sb.append("<h2>password : ").append(password).append("</h2>");
		sb.append("<h2>gender : ").append(gender).append("</h2>");
		StringBuffer sb2 = new StringBuffer();
		for (String t : techs) {
			sb2.append(t).append(", ");
		}
		sb2.setLength(sb2.length()-2);
		
		sb.append("<h2>Tech : ").append(sb2).append("</h2>");
		
		out.append(sb);
	}

}
