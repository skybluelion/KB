package com.spring.service.user;

import java.util.List;

import com.spring.service.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO vo) throws Exception;
	int deleteMember(String id) throws Exception;
	int updateMember(MemberVO vo) throws Exception;
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember()  throws Exception;
	
	MemberVO idExist(MemberVO vo) throws Exception;

}
