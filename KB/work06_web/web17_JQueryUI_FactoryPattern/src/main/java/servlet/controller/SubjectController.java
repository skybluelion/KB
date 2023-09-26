package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("handleRequest... 진입...");
		
		//DB 갔다가 왔다 치고...
		String result = "Algorithm  |  JAVA  |  Back-End  |  Front-End  |  Framework  |  AI";
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
