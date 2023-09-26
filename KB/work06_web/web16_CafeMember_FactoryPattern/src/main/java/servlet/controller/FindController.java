package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	/*
	 	MVC -- FindController 서블릿과 동일
	 	FrontController - 서블릿 안의 find() 함수와 동일
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
        String path = "find_fail.jsp";
        try {
        	MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
        	request.setAttribute("vo", rvo);
        	path = "find_ok.jsp";        	
        } catch (Exception e) {
        	
        }
        return new ModelAndView(path); // false -> forwarding 기본값
	}

}
