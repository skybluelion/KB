package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 DB 연결한 후 데이터를 추가, 삭제, 수정, 반환하는 작업을 하기 위해서는
 1. 드라이버를 메모리(DBConnectTest1.java가 실행되는 메모리)에 로딩
 	Class.forName("드라이버명")
 2. DB 연결
 
 3. CRUD 작업
 */
public class DBConnectTest2 {

	public static void main(String[] args) {
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. Driver Loading... is Ok.");
			
			//2. DB 연결 ... Connection 반환
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kb_db","1234");
			System.out.println("2. DB Connecting... is Ok.");
			
			//3. PreparedStatement 객체 생성... 이 때 인자값으로 쿼리문 입력
			// delete... 333 삭제
//			String query = "DELETE custom WHERE id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("3. PreparedStatement Creating... is Ok.");
//			ps.setInt(1, 333);
			
			// update... 111 주소 뉴욕
//			String query = "UPDATE custom SET address=? WHERE id = 111";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("3. PreparedStatement Creating... is Ok.");
//			ps.setString(1,  "뉴욕");
			
			// select
			String query = "SELECT id, name, address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			
			//4. 쿼리문 실행
//			System.out.println(ps.executeUpdate()+" ROW DELETE !!!");
//			System.out.println(ps.executeUpdate()+" ROW UPDATE !!!");
			
			//select
			ResultSet rs = ps.executeQuery();
			while(rs.next()) { // row데이터가 있을 때까지 실행
				System.out.println(rs.getInt(1)+"\t"
								  +rs.getString(2)+"\t"
								  +rs.getString(3)); // 정확도를 위해 id,name 등이 아닌 index를 넣음
			}
			System.out.println("SELECT !!!");
			
			
			
		} catch (ClassNotFoundException e) {
//			e.printStackTrace(); // 자취를 쫓아가면서 추적해주기 때문에 유용하지만, 보안 문제 때문에 현재는 잘 쓰이지 않음
			System.out.println("1. Driver Loading... Fail...");
		} catch (SQLException e) {
			System.out.println("2. DB Connect... Fail...");
		} 
		
	}

}
