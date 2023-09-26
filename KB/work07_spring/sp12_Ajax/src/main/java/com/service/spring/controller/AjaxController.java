package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {

	@RequestMapping("/") //http:127.0.0.1:8899/spring
	public String index() {
		System.out.println(" context path... request.../");
		return "redirect:index.jsp"; //redirect는 확장자까지 작성해야함
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("synchro... request...");
		model.addAttribute("info", "와~ 동기통신이다...");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("asynch... request...");
		model.addAttribute("person", new Person("James","Texas"));
		return "JsonView";//비동기통신은 별도의 결과페이지가 없다. . InternalResourceViewResolver 방식 x
	}
	
}
