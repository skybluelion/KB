package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;
import jdbc.exception.RecordNotFoundException;

public interface MemberDAO {
	//공통
	Connection getConnect() throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;

	//비지니스 로직 템플릿
	void insertMember(Member vo) throws SQLException;
	void deleteMember(int id) throws SQLException, RecordNotFoundException;
	void updateMember(Member vo) throws SQLException, RecordNotFoundException;

	Member getMember(int id) throws SQLException, RecordNotFoundException;
	ArrayList<Member> getMember() throws SQLException,RecordNotFoundException;
	
	//이름이 같은 사람
	ArrayList<Member> getMember(String name) throws SQLException;

}
