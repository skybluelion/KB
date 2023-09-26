package com.service.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	//name 폼에 입력된 것을 받아온다
	//addr 폼에 입력된 것을 받아온다
	@RequestMapping("/form.do")
	public ModelAndView form(String name,String addr) {
		/*
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		*/
		
		return new ModelAndView("/WEB-INF/views/form_result.jsp","info",name+"님이 사는 곳은 "+addr+"!!");
	}
}
