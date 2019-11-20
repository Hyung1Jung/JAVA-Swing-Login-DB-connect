package dbExam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExam01 {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

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

// mysql.com ���� Connector/J���� �ٿ�ް� ����Ǯ�� mysql.bin���� project - properties�� �ܺο����߰��� mysql.bin���� �߰�
// jdk - lib���� �߰�