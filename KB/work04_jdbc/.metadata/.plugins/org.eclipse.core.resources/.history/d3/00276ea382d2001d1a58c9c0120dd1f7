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
	//공통적인 기능의 Template
	Connection  getConnect()throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps)throws SQLException;
	void closeAll(Connection conn, PreparedStatement ps,ResultSet rs)throws SQLException;
	
	//Business Logic Template...
	void insertMember(Member dto)throws SQLException, DuplicateIDException;
	void deleteMember(int id)throws SQLException, RecordNotFoundException;
	void updateMember(Member dto)throws SQLException, RecordNotFoundException;
	
	Member getMember(int id)throws SQLException;
	ArrayList<Member> getMember()throws SQLException;
	ArrayList<Member> getMember(String name)throws SQLException;
	
	
	
}








