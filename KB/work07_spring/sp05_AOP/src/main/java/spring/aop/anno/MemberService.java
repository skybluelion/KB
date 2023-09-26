package spring.aop.anno;

/*
	Core Concern만으로 작성된 클래스... Target
 */
public class MemberService {
	
	public void register(String id) {
		System.out.println("register...logic... 회원등록 성공");
	}
	public void findMember(String id) {
		System.out.println("findMember...logic... 회원검색 성공");
	}
}
