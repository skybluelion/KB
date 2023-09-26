package spring.service.model;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember()  throws Exception;
	MemberVO login(MemberVO vo) throws Exception;
}
