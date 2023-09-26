package com.service.spring.test;
//JUnit을 사용한 단위테스트..
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.Item;

public class MyBatisFrameworkJUnitTest1 {

	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		//2. SqlSession -- SqlSessionTemplate
		SqlSession session = factory.openSession();
		
		//3. 쿼리문 실행
		System.out.println("=====================");
		System.out.println("getItemList");
		List<Item> list=session.selectList("ns.sql.ItemMapper.getItemList");
		for (Item vo : list) {
			System.out.println(vo);
		}
		
		System.out.println("\n=====================\n");
		Item item = session.selectOne("ns.sql.ItemMapper.getItem",1111);
		System.out.println(item);
	}

}
