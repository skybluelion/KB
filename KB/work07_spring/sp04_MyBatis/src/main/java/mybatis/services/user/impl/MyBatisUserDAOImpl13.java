package mybatis.services.user.impl;
/*
 	annotation 기반으로 작성
 	xml 설정문서에서 bean태그를 생략할 수 있다.
 */

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME="UserMapper10.";

//	public void setSqlSession(SqlSession sqlSession) {
//		this.sqlSession = sqlSession;
//	} 									@Autowired로 생략가능

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result=sqlSession.insert(MAPPER_NAME+"addUser",user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result=sqlSession.update(MAPPER_NAME+"updateUser",user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result=sqlSession.update(MAPPER_NAME+"removeUser",userId);
//		sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getUser",userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"getUserList",user);
	}

}
