package services;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

	private ResultSet rs;
	private Statement stmt = null;
	public Connection con;
	private String url = "jdbc:mysql://127.0.0.1:3306/?user=sejun?serverTimezone=UTC";
	private String user = "sejun";
	private String passwd = "12341234";		//MySQL에 저장한 root 계정의 비밀번호를 적어주면 된다.
	
	
	 
	public void connect() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("MySQL 서버 연동 성공");
		}
		catch(Exception e)
		{
			System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
		}
	}
	
	public void disconnect() {
	    try {
	      con.close();
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	  }
	
}