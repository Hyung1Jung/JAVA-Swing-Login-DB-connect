package dbExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DbExam02 {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";
	Connection conn = null;
	Statement state = null;

	/*
	 * void SqlConnect() { try { Class.forName(JDBC_DRIVER); } catch (Exception e) {
	 * } }
	 */
	void DbConnect() { // db연결 메소드
		try {
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD); // db연결, 작업마다 open
		} catch (Exception e) {
		}
	}

	void Close() { // 닫기 연결 메소드
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
			ArrayList<DbExam02Test> bookVal = new ArrayList<DbExam02Test>(); // 모델링한 객체의 값을 넣기위해 ArrayList 생성
			try {
				// Insert();
				DbConnect();
				state = conn.createStatement(); // state 연결
				String s = "select * from book;";
				// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234, 941010);";
				// state.executeUpdate(s); // 테이블에 값 넣기
				ResultSet aa = state.executeQuery(s);
				while (aa.next()) {
					DbExam02Test m = new DbExam02Test(); // 모델링한 객체
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
			Class.forName(JDBC_DRIVER); // mysql에 연결, 외부에서 가져오는 것들은 모두 예외처리, 한 번만 쓰면 됨
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
 mysql.com 가서 Connector/J에서 다운받고 압축풀고 mysql.bin파일 project - properties에 외부에서추가로 mysql.bin파일 추가 jdk - lib에도 추가
*/