package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory 까지 받아오는 기능을 설정
public class FactoryService {
	private static SqlSessionFactory factory=null;
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
