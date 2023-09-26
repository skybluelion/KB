package spring.aop.prob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
	비즈니스 로직(Core concern)이 들어가 있는 Target
	핵심적인 로직들 사이에 부수적인 관심사(Cross Cutting Concern)가 산발적으로 있다.
	oop의 본질을 흐리고 있다.
	
	부수적인 관심사...log파일 출력기능...
 */
public class MemberService {
	
	private Log log = LogFactory.getLog(getClass());
	public void register(String id) {
		System.out.println("register...logic... 회원등록 성공");
		log.info(id+"register member info...");
	}
	public void findMember(String id) {
		System.out.println("findMember...logic... 회원검색 성공");
	}
}
