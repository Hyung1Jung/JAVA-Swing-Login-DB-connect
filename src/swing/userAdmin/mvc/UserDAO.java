package swing.userAdmin.mvc;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	ArrayList<UserDTO> a;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	Connection conn = null;
	Statement state = null;

	Scanner sc = new Scanner(System.in);

	void UserDAO() { // mysql연결 메소드 , 한 번만 쓰면 되니까 생성자와 동시에 초기화
		try {
			Class.forName(JDBC_DRIVER); // mysql에 연결, 외부에서 가져오는 것들은 모두 예외처리, 한 번만 쓰면 됨
		} catch (Exception e) {
		}
	}

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
}