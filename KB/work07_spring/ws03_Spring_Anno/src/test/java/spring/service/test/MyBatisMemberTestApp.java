package spring.service.test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberService;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws Exception{
		
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/beans/memberservice.xml"	 }
																				);														
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		
		MemberVO vo = new MemberVO("test123", "test1", "테스트", "서울");
		

		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.MemberService.getMember(id) Test
		vo = memberService.getMember("test123");
		System.out.println(":: 1. get(SELECT)  ? "+vo);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.MemberService.showAllMember() Test
		System.out.println(":: 2. all Member(SELECT)  ? ");
		List<MemberVO> list = memberService.showAllMember();
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
					
		//3.MemberService.idExist(id) Test
		vo = memberService.getMember("test123");
		System.out.println(":: 3. idExist(SELECT)  ? ::"+vo);
	}

}




