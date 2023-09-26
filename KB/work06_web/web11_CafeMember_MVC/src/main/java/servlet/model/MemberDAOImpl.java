package servlet.model;
//DriverManager 방식이 아닌 
//DataSource 방식을 사용
/*
 	DataSource 방식
 	JNDI 서비스를 이용해서
 	1. DataSource를 찾아오고
 	2. DataSource의 getConnection() 함수를 이용해서 Connection을 Rent해온다.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO{
	private DataSource ds;
	
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl(){
		
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource Lookup...success");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup...fail");
		}
		
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {		
		System.out.println("DB connection Rent...");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=  getConnection();
			String query = "INSERT INTO member VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getAddress());
			
			System.out.println(ps.executeUpdate()+"row INSERT ok.");
		}finally{
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<MemberVO> list = new ArrayList<>();
        try {
            conn = getConnection();
            String query = "SELECT id, password, name, address FROM member";
            ps = conn.prepareStatement(query);
            System.out.println("PreparedStatement....showAllMember()..");

            rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new MemberVO(
                        rs.getString("id"), 
                        rs.getString("password"), 
                        rs.getString("name"), 
                        rs.getString("address")));
            }
        }finally {
            closeAll(rs, ps, conn);
        }
        return list;
    }

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MemberVO vo = null;
        try{
            conn = getConnection();
            //
            String query = "SELECT id, password, name, address FROM member WHERE id=?";
            ps = conn.prepareStatement(query);
            System.out.println("PreparedStatement....findByIdMember()..");

            ps.setString(1,id);
            rs = ps.executeQuery();

            if(rs.next()) {
                vo =  new MemberVO(id, 
                                   rs.getString("password"), 
                                   rs.getString("name"),
                                   rs.getString("address"));
            }
        }finally{
            closeAll(rs, ps, conn);
        }
        return vo;
    }
	@Override
	public MemberVO login(String id, String pass) throws SQLException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    MemberVO vo = null;
	    try {
            conn = getConnection();
            String query = "SELECT id, password, name, address FROM member WHERE id =? AND password=?";
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if(rs.next()) {
            	vo = new MemberVO(id,
            					pass,
            					rs.getString("name"),
            					rs.getString("address"));
            }
            
		} finally {
            closeAll(rs, ps, conn); //다시 Pool로 반환
		}
		return vo;
	} 	


}

















