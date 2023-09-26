package spring.service.test;
//JUnit을 사용한 단위테스트..
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.spring.service.domain.MemberVO;



public class MyBatisFrameworkJUnitTest1 {

	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		//2. SqlSession -- SqlSessionTemplate
		SqlSession session = factory.openSession();
		
//1.
		
//		MemberVO vo = new MemberVO("test123", "test1", "테스트", "서울");
//		int row=session.insert("MemberMapper.registerMember",vo);
//		System.out.println(row+" 명이 추가 성공!!");
//		
//		session.commit();
		
		
		//2.
//		MemberVO vo = new MemberVO("test123", "test12", "테스트", "서울");
//		int row=session.update("MemberMapper.updateMember",vo);
//		System.out.println(row+" 명이 수정 성공!!");
//		
//		session.commit();
		
		//3.
//		int row=session.delete("MemberMapper.deleteMember","test123");
//		System.out.println(row+" 명이 삭제 성공!!");
//		
//		session.commit();
		
		//4.
		MemberVO vo=session.selectOne("MemberMapper.getMember","test123");
		System.out.println(vo);
		
		System.out.println("===================");
		
		//5
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for(MemberVO member : list) {
			System.out.println(member);
		}
		
		
	}
}
