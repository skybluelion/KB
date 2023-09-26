package spring.service.dao.impl;

import spring.service.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public void register(String name, String addr) {
		System.out.println(name+" 님 회원가입 성공!");
	}

	@Override
	public void delete(String id) {
		System.out.println(id+" 님 삭제 성공!");
		
	}

}
