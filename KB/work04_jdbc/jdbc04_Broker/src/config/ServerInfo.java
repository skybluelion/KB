package config;

public interface ServerInfo {
//필드가 없고 무조건 상수로 인식되어져 있기 때문에, public static final이 생략되어 있음
	String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String USER = "kb_db";
	String PASS = "1234";
	
}
