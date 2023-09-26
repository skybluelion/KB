package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.UploadDataVO;

@Controller
public class FileUploadController {
	//FileUpload 코드 작성시 ... Controller 작성하기 이전에 반드시 먼저 작성해야하는 VO가 있다.
	@RequestMapping("fileupload.do")
	public String fileupload(UploadDataVO vo, HttpServletRequest request,Model model) throws Exception{
		
		MultipartFile mFile= vo.getUploadFile();
		System.out.println("MultipartFile.."+mFile);
		
		//1. MultipartFile의 주요기능..
		if(mFile.isEmpty()!=true) { //업로드된 파일이 있다면
			System.out.println("파일의 용량 : "+mFile.getSize());
			System.out.println("업로드한 파일명 : "+mFile.getOriginalFilename());
			System.out.println("mFile.getName : "+mFile.getName());
		}
		
		//2. 업로드한 파일을 Tomcat 경로에 저장...
		String root=request.getSession().getServletContext().getRealPath("/");// "/" contextPath return
		System.out.println("root :: "+root);
		
		String path = root+"upload\\";
		System.out.println("path :: " +path);
		
		//3. 업로드한 파일의 카피본을 해당 경로에 저장
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile); //이 때, Tomcat 서버로 이동, 저장됨
		
		model.addAttribute("uploadfile", mFile.getOriginalFilename());
		
		return "upload_result";
	}
	
	@RequestMapping("filedown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) {
		String root=request.getSession().getServletContext().getRealPath("/");// "/" contextPath return
		String path = root+"upload\\";
		
		//다운로드 코드 추가
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView",map);
		
	}
}
