package co.micol.student.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DateSource {	// 싱글톤 class 패턴
	private static DateSource dateSource = new DateSource(); // 자신을 객체로 만들고
//	private Connection conn;	// 자신을 객체로 만들고, 인스턴스 값을 돌려 줄 거
	private DateSource() {};	// 외부에서 생성하지 못하도록
	
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public static DateSource getInstance() {
		return dateSource;
		
	}
	
	public Connection getConnection() {
		dbconfiguration();
		try {
			
			Class.forName(driver); // 내 app 과 연결
			conn = DriverManager.getConnection(url, user, password); // 연결 터널 만듦
			System.out.println("DB 연결성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패");
		}
		return conn;
	}
	private void dbconfiguration() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}
}
