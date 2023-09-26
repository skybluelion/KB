package com.jbdc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

//비지니스로직 :: 디비 Access하는 로직... sql이 동작

public class CustomerDAO {
	public CustomerDAO() {
		System.out.println("DAO Creating...");
	}
	/////////// 공통적인 로직 ////////////////////
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASS);
		System.out.println("DB...Connection...is OK");
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	
	
	
	
	//DML, SELECT SQL이 각각의 기능에서 작동하도록 비지니스로직을 정의
	public void addCustomer(String ssn, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			String query = "INSERT INTO customer (ssn, name, address) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1,ssn);
			ps.setString(2,name);
			ps.setString(3,addr);
			
			int row = ps.executeUpdate();
			System.out.println(row+"row INSERT ok...");
		}finally {
			closeAll(conn, ps);
		}
		
	}
	public void removeCustomer(String ssn) throws SQLException{
		//DELETE
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			String query = "DELETE customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, ssn);

			
			int row = ps.executeUpdate();
			System.out.println(row+"row DELETE ok...");
		}finally {
			closeAll(conn, ps);
		}
	}
	public void updateCustomer(String ssn, String name, String addr) throws SQLException {
		//UPDATE SET
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE customer SET name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, name);  //순서 주의  쿼리의? 순서와 동일
			ps.setString(2, addr);
			ps.setString(3, ssn);
			int row = ps.executeUpdate();
			System.out.println(row+"row UPDATE ok...");
		} finally{
			closeAll(conn, ps);
		}
	}
	
	public void printAllCustomer() throws SQLException {
		//SELECT
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, name, address FROM customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ssn")+"\t"
								  +rs.getString("name")+"\t"
								  +rs.getString("address"));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
	}
}
