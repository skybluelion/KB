package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//결과페이지 이름과 동시에 페이지 이동 방법까지도 ...
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response);
	
}
