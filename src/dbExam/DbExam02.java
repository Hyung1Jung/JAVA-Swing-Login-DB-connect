package dbExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbExam02 {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";
	Connection conn = null;
	Statement state = null;

	/*
	 * void SqlConnect() { try { Class.forName(JDBC_DRIVER); } catch (Exception e) {
	 * } }
	 */
	void DbConnect() { // db���� �޼ҵ�
		try {
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD); // db����, �۾����� open
		} catch (Exception e) {
		}
	}

	void Close() { // �ݱ� ���� �޼ҵ�
		if (state != null) {
			try {
				state.close();
			} catch (Exception e) {
			}

			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {

				}
		}
	}
	
	ArrayList<DbExam02Test> Db() {
			ArrayList<DbExam02Test> bookVal = new ArrayList<DbExam02Test>(); // �𵨸��� ��ü�� ���� �ֱ����� ArrayList ����
			try {
				// Insert();
				DbConnect();
				state = conn.createStatement(); // state ����
				String s = "select * from book;";
				// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234, 941010);";
				// state.executeUpdate(s); // ���̺� �� �ֱ�
				ResultSet aa = state.executeQuery(s);
				while (aa.next()) {
					DbExam02Test m = new DbExam02Test(); // �𵨸��� ��ü
					m.setNo(aa.getInt("no"));
					m.setName(aa.getString("name"));
					bookVal.add(m);
				}
				aa.close();

			} catch (Exception e) {
			} finally {
				Close();
			}
			return bookVal;
	}
	
	public DbExam02() {
			try {
			Class.forName(JDBC_DRIVER); // mysql�� ����, �ܺο��� �������� �͵��� ��� ����ó��, �� ���� ���� ��
			}catch(Exception e) {
			}
	}
	

	
	void Insert(int n, String ss) {
		try {
			DbConnect();
			state = conn.createStatement();
			String s = String.format("insert into book value('%d', '%s');" , n , ss);
			state.executeUpdate(s);
		} catch (Exception e) {
		} finally {
			Close();
		}
	}
	
}

/*
 mysql.com ���� Connector/J���� �ٿ�ް� ����Ǯ�� mysql.bin���� project - properties�� �ܺο����߰��� mysql.bin���� �߰� jdk - lib���� �߰�
*/