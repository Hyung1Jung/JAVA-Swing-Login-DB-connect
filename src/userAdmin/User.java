package userAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	String arr[] = new String[1];
	//arr[0] = "";
	int in = 0;
	int n = 0;
	
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	ArrayList<MemberShip> mb = new ArrayList<MemberShip>();

	Scanner sc = new Scanner(System.in);

	// ȸ�����Կ� ���� �޼ҵ�
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("���̵� �Է��ϼ��� : "); // ���̵�
		arr[0] = sc.next();
		Jungbok();
		mb2.setId(arr[0]);
		System.out.print("��й�ȣ�� �Է��ϼ��� : "); // ��й�ȣ
		mb2.setPw(sc.nextInt());
		System.out.print("�̸��� �Է��ϼ��� : "); // �̸�
		mb2.setName(sc.next());
		System.out.print("������ �Է��ϼ���(��/��) : "); // ����
		mb2.setSe(sc.next());
		System.out.print("�޴�����ȣ�� �Է��ϼ��� : "); // �޴�����ȣ
		mb2.setPh(sc.nextInt());
		System.out.print("�ֹε�Ϲ�ȣ ���ڸ��� �Է��ϼ��� : ");// �ֹε�Ϲ�ȣ
		mb2.setJumin(sc.nextInt());
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		mb2.setUn(n++);
		mb.add(mb2);
		Db();
		
	}

	void Db() { // �����ͺ��̽�ȭ
		Connection conn = null;
		Statement state = null;
		String n1 = mb.get(in).getId();
		String n2 = mb.get(in).getName();
		int n3 = (mb.get(in).getUn() + n);
		String n4 = mb.get(in).getSe();
		int n5 = mb.get(in).getPh();
		int n6 = mb.get(in).getPw();
		int n7 = mb.get(in).getJumin();
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state ����
			String input = String.format("Insert into userpro value('%s','%s','%d','%s','%d','%d','%d')", n1, n2, n3,
					n4, n5, n6, n7);
			in++;
			state.executeUpdate(input); // ���̺� �� �ֱ�
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
	

	// ��ü���
	void print() {
		Connection conn = null;
		Statement state = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state ����
			String s = "select * from userpro;"; // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				String s1 = aa.getString("id");
				String s2 = aa.getString("name");
				int n1 = aa.getInt("no");
				String s3 = aa.getString("sex");
				int n2 = aa.getInt("ph");
				int n3 = aa.getInt("pw");
				int n4 = aa.getInt("jumin");

				System.out.print("|" + "Id : " + s1 + " |");
				System.out.print("name : " + s2 + " |");
				System.out.print("no : " + n1 + " |");
				System.out.print("sex : " + s3 + " |");
				System.out.print("ph : " + n2 + " |");
				System.out.print("pw : " + n3 + " |");
				System.out.println("Jumin : " + n4 + "|");
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

	// �ߺ��� Ȯ���ϱ� ���� �޼ҵ�
	void Jungbok() {
		
		Connection conn = null;
		Statement state = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state ����
			String s = String.format("select id from userpro where id = '%s';",arr[0]); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);
	
			
			while(aa.next()) {
				//String z = aa.getString("id");
				System.out.println("�ߺ�");
				System.out.println("�ٽ��Է� : ");
				arr[0] = sc.next();
				break;
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

	// �˻�
	void Out3() {
		Connection conn = null;
		Statement state = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("�˻��� Id�� �Է� : ");
		String s = sc.next();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state ����
			String input = String.format("select * from userpro where id = '%s';", s); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(input);

			if (aa.next()) {
				String s1 = aa.getString("id");
				String s2 = aa.getString("name");
				int n1 = aa.getInt("no");
				String s3 = aa.getString("sex");
				int n2 = aa.getInt("ph");
				int n3 = aa.getInt("pw");
				int n4 = aa.getInt("jumin");

				System.out.print("|" + "Id : " + s1 + " |");
				System.out.print("name : " + s2 + " |");
				System.out.print("no : " + n1 + " |");
				System.out.print("sex : " + s3 + " |");
				System.out.print("ph : " + n2 + " |");
				System.out.print("pw : " + n3 + " |");
				System.out.println("Jumin : " + n4 + "|");
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

	//ȸ������
	void remove() {
		Connection conn = null;
		Statement state = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("������ Id�� �Է� : ");
		String s = sc.next();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state ����
			String input = String.format("delete from userpro where id = '%s';", s); // ��� ���̺� ����
			System.out.println("�ش�Ǵ� ȸ�������� �����Ǿ����ϴ�.");
			
			state.executeUpdate(input);

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

	// �޴��� ���� �޼ҵ�
	void menu() {
		System.out.println("ȸ������ ���α׷�");
		int menu = 0;
		do {
			System.out.println("1:ȸ�� ����    2:�˻����     3:��ü���     4:����    5: ���� ");
			System.out.print("��ȣ �Է� : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				put();
				break;
			case 2:
				Out3();
				break;
			case 3:
				print();
				break;
			case 4:
				remove();
				break;
			case 5:
				System.out.print("����");
				return;
			default:
				System.out.println("�޴� ���� ����");
			}
		} while (menu != 6);
	}


}
