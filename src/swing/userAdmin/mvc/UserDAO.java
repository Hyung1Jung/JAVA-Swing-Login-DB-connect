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
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	Connection conn = null;
	Statement state = null;

	Scanner sc = new Scanner(System.in);

	void UserDAO() { // mysql���� �޼ҵ� , �� ���� ���� �Ǵϱ� �����ڿ� ���ÿ� �ʱ�ȭ
		try {
			Class.forName(JDBC_DRIVER); // mysql�� ����, �ܺο��� �������� �͵��� ��� ����ó��, �� ���� ���� ��
		} catch (Exception e) {
		}
	}

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
}