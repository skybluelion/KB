package web.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {
	// Common
	Connection getConnection() throws SQLException;

	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;

	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;

	// Business
	// 상품 추가
	int AddPrdouct(Product vo) throws SQLException;
	// 최근 추가된 자동 증가값 return
	int getCurrentId(PreparedStatement ps, Connection conn) throws SQLException;
	// 상품 전체 목록 검색
	ArrayList<Product> findAllProducts() throws SQLException;
}
