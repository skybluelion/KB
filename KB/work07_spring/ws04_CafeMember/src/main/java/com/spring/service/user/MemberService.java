package com.spring.service.user;

import java.util.List;

import com.spring.service.domain.MemberVO;

public interface MemberService {
	
	int registerMember(MemberVO vo) throws Exception;
	int updateMember(MemberVO vo) throws Exception;
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember()  throws Exception;
	
	MemberVO idExist(MemberVO vo) throws Exception;
}
