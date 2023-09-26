package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	/*
	 	MVC -- FindController 서블릿과 동일
	 	FrontController - 서블릿 안의 find() 함수와 동일
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        MemberVO pvo = new MemberVO(id, password, name, address);
        String path = "index.jsp";
        try{
        	MemberDAOImpl.getInstance().registerMember(pvo);
        	path = "front.do?command=showAll";
        }catch (Exception e) {
        	
        }
        return new ModelAndView(path,true); //redirect
	}

}
