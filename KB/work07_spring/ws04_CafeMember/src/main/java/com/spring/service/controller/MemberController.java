package com.spring.service.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.domain.MemberVO;
import com.spring.service.user.MemberDAO;
import com.spring.service.user.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping("/memberfind.do")
	public ModelAndView find(String id) throws Exception{
		MemberVO vo = memberService.getMember(id);
		return new ModelAndView("find_ok","vo",vo);
	}
	
	@RequestMapping("/register.do")
	public ModelAndView register(MemberVO vo) throws Exception{
		memberService.registerMember(vo);
		return new ModelAndView("register_result","vo",vo);
	}
	
	@RequestMapping("/showAll.do")
	public ModelAndView showAll() throws Exception{
		List<MemberVO> list = memberService.showAllMember();
		return new ModelAndView("allView","list",list);
	}
	
	
	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO vo) throws Exception{
		memberService.updateMember(vo);
		return new ModelAndView("update_result","vo",vo);
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(MemberVO o, HttpSession httpSession) throws Exception{
		MemberVO vo = memberService.idExist(o);
		if(vo!=null) {
			httpSession.setAttribute("vo", vo);
		}
		return new ModelAndView("login_result","vo",vo);
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession httpSession) throws Exception{		
		httpSession.invalidate();
		
		return new ModelAndView("logout");
		
	}
}
