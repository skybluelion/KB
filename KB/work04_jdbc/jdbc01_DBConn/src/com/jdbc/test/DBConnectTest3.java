package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 DB 연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
 1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩
 	Class.forName("드라이버명")
 2. DB 연결
 
 3. CRUD 작업
 
 ========================================================
 
 DB연결 프로그램에 서버정보에 관련된 실제값이 하드코딩 되어져있다.
 드라이버 FQCN
 서버주소, 계정이름, 비밀번호
 ㅣ
 ㅣ
 Meta Data 화 : 의미를 가진 데이터를 이용함. 즉, 프로그램과 값들을 분리 -> 파일(xml,properties)로 분리
 ::
 1. 드라이버 로딩
 2. DB연결--------------connection
 3. preparedstatement--preparedstatement
 4. 쿼리문 실행	----------ResultSet
 -----------------------------------
 5. 자원반환...close();
	열린 순서 반대로 닫는다.
	반드시 닫아야 한다.... try ~ finally
	ResultSet
	PreparedStatement
	Connection
 
 
 
 */
public class DBConnectTest3 {
	
	public DBConnectTest3() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			//1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME); // 하드 코딩 : 실제값이 써있는 것.
			System.out.println("1. Driver Loading... is Ok.");
			
			//2. DB 연결 ... Connection 반환
			conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
			System.out.println("2. DB Connecting... is Ok.");
			
			//3. PreparedStatement 객체 생성...
			String query = "SELECT id, name, address FROM custom";  // 모듈화, 메타데이터화
			ps = conn.prepareStatement(query);
			
			//4. 쿼리문 실행
			rs = ps.executeQuery();
			while(rs.next()) { // row데이터가 있을 때까지 실행
				System.out.println(rs.getInt(1)+"\t"
								  +rs.getString(2)+"\t"
								  +rs.getString(3)); // 정확도를 위해 id,name 등이 아닌 index를 넣음
			}//while
			System.out.println("SELECT is Ok.");
		}finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}//생성자

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectTest3();
	}//main
}//class