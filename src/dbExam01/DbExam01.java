package dbExam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExam01 {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	public DbExam01() {
		Connection conn = null;
		Statement state = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);
			if(conn == null)
				System.out.println("d");
			state = conn.createStatement();
			String s = "select * from userpro;";
			ResultSet aa = state.executeQuery(s);
			
			if(aa.next()) {
				String s1 = aa.getString("id");
				String s2 = aa.getString("name");
				int n1 = aa.getInt("no");
				
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(n1);
			}

			aa.close();
			state.close();
		} catch (Exception e) {
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ex1) {
			}
		}
	}

	public static void main(String[] args) {
		DbExam01 d = new DbExam01();
	}
}

// mysql.com 가서 Connector/J에서 다운받고 압축풀고 mysql.bin파일 project - properties에 외부에서추가로 mysql.bin파일 추가
// jdk - lib에도 추가