package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;
import spring.service.hello.Hello;

public class DaoTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );

		//2. Container 로 부터 dao 의 name 을 갖는 instance return 받기  
		MemberDAO dao = (MemberDAO)factory.getBean("dao");
		
		//3. 빈의 메소드를 호출... 사용
		dao.register("길복순", "여의도");
		dao.delete("1234");
	}
	
}//end of class