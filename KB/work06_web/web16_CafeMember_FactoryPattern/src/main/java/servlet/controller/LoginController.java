package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	/*
	 	MVC -- FindController 서블릿과 동일
	 	FrontController - 서블릿 안의 find() 함수와 동일
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
        String password = request.getParameter("password");
        String path = "index.jsp";
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
        return new ModelAndView(path); // false -> forwarding 기본값
	}

}
