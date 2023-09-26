package spring.service.dao;
//비지니스 로직 Template
public interface MemberDAO {
	void register(String name, String addr);
	void delete(String id);
}
