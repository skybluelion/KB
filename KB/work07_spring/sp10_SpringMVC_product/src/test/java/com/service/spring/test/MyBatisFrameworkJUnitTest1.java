package com.service.spring.test;
//JUnit을 사용한 단위테스트..
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;


public class MyBatisFrameworkJUnitTest1 {

	@Test
	public void unit() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
	
		//2. SqlSession -- SqlSessionTemplate
		SqlSession session = factory.openSession();
		
		//3. 쿼리문 실행
		MyProduct vo = new MyProduct("파워 세탁기", "삼성", 800000);
		session.insert("MyProductMapper.addProduct", vo);
		session.commit();
		System.out.println("==============1.addProduct ==============");
		
		System.out.println("==============2.findProducts ==============");
		List<MyProduct> list = session.selectList("MyProductMapper.findProducts");
		for (MyProduct product : list) 
			System.out.println(product);
		
		
		System.out.println("\n========3. findProductByName ==============");
		List<MyProduct> list2 = session.selectList("MyProductMapper.findProductByName","세탁기");
		for(MyProduct product : list2)
		System.out.println(product);
	
		System.out.println("\n========3. findProductByMaker ==============");
		List<MyProduct> list3 = session.selectList("MyProductMapper.findProductByMaker","대우");
		for(MyProduct product : list3)
		System.out.println(product);
		
		
	}
}
