package spring.service.test;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;



public class MyBatisMemberTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		///==> SqlMapConfig.xml : MyBATIS Framework 의 핵심 환경설정화일 (MetaData)
		//==> mybatis-userservice-mapping.xml : SQL 를 갖는 설정화일 (MetaData) 
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>   SqlSession  객체 생성
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		// showAllMember
		System.out.println(":: 1.. showAllMember(SELECT)  ? ");
		List<MemberVO> list = session.selectList("memberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//==> Test 용 UserVO instance 생성
		MemberVO member = new MemberVO("sky12", "sky12", "주몽2", "여의도");
		
		//registerMember
//		Object obj = session.insert("memberMapper.registerMember", member);
//		session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능.
//		//iBatis와 다르게 insert문의 리턴타입은 insert된 row수를 반환한다.
//		System.out.println(":: 2. registerMember(INSERT)  result ? "+obj); //1
//		System.out.println("\n");
		
		//updateUser
		member.setName("킬복순");
		int updateResult = session.update("memberMapper.updateMember", member);
		session.commit(); //이부분 반드시 해줘야 한다.
		System.out.println(":: 3. updateMember(UPDATE) result ? "+updateResult);//1
		System.out.println("\n");
		
		
		//getMember
		MemberVO member01 = (MemberVO)session.selectOne("memberMapper.getMember", "킬복순");
		System.out.println(":: 4. get(SELECT)  ? "+member01.toString());
		System.out.println("\n");
		
		//idExist
		String existResult = session.selectOne("memberMapper.idExist", "sky12");
		System.out.println(":: 4. idExist(SELECT)  ? name : "+ existResult);
		System.out.println("\n");
		
		
//		//login
		member.setId("sky12");
		member.setPassword("sky12");
		String name = (String)session.selectOne("memberMapper.login", member);
		System.out.println("::  login  ? "+name);
		
		//delete
		int deleteResult = session.delete("memberMapper.deleteMember", member.getId());
		session.commit(); //이 부분 반드시 해줘야 한다.
		System.out.println(":: 5. deleteMember(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
	}//end of main
}//end of class



