package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.service.MyProductService;

@Controller
public class MyProductController {

	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("/myProduct.do")
	public ModelAndView insert(MyProduct vo) throws Exception{
		myProductService.addProduct(vo);
		return new ModelAndView("insert_result","vo",vo);
	}
	
	@RequestMapping("/myProductSearch.do")
	public ModelAndView find(String command, String word) throws Exception{
		List<MyProduct> list = null;
		String viewName = "";
		if(command.equals("findProductByName")) {
			list = myProductService.findProductByName(word);
			viewName = "find_result";
		}else if(command.equals("findProductByMaker")) {
			list = myProductService.findProductByMaker(word);
			viewName = "find_result";
		}else if(command.equals("findProducts")) {
			list = myProductService.findProducts();
			viewName = "find_result";
		}
		
		return new ModelAndView(viewName,"list",list);
	}
}
