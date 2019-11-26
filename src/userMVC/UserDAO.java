package userMVC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dbExam.DbExam02Test;

import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	String arr[] = new String[1];
	int in = 0;
	int n = 0;
	boolean b;

	ArrayList<UserDTO> a;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? �����ͺ��̽� �̸�, cmd���� use �����ͺ��̽��� �ϰ� ����

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	String s1;
	String s2;
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

	// ȸ�����Կ� ���� �޼ҵ�
	void put() {
		int n = 1;
		System.out.print("���̵� �Է��ϼ��� : "); // ���̵�
		arr[0] = sc.next();
		System.out.print("��й�ȣ�� �Է��ϼ��� : "); // ��й�ȣ
		String n6 = sc.next();
		System.out.println("��ȣ�� �Է��ϼ��� : ");
		String n3 = sc.next();
		System.out.print("�̸��� �Է��ϼ��� : "); // �̸�
		String n2 = sc.next();
		System.out.print("������ �Է��ϼ���(��/��) : "); // ����
		String n4 = sc.next();
		System.out.print("�޴�����ȣ�� �Է��ϼ��� : "); // �޴�����ȣ
		String n5 = sc.next();
		System.out.print("�ֹε�Ϲ�ȣ ���ڸ��� �Է��ϼ��� : ");// �ֹε�Ϲ�ȣ
		String n7 = sc.next();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		Insert(arr[0], n2, n3, n4, n5, n6, n7);
		Db();
	}

	ArrayList<UserDTO> Db() { // �𵨸��� ��ü�� ���� �ֱ����� ArrayList ����
		ArrayList<UserDTO> bookVal = new ArrayList<UserDTO>();
		try {
			DbConnect();
			state = conn.createStatement(); // state ����
			String s = "select * from userpro;";
			// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234,
			// 941010);";
			// state.executeUpdate(s); // ���̺� �� �ֱ�
			ResultSet aa = state.executeQuery(s);
			while (aa.next()) {
				UserDTO m = new UserDTO(); // �𵨸��� ��ü
				m.setId(aa.getString("id"));
				m.setName(aa.getString("name"));
				m.setUn(aa.getInt("no"));
				m.setPw(aa.getInt("pw"));
				m.setSe(aa.getString("sex"));
				m.setPh(aa.getInt("ph"));
				m.setJumin(aa.getInt("Jumin"));

				bookVal.add(m);
			}
			aa.close();

		} catch (Exception e) {
		} finally {
			Close();
		}
		a = bookVal;
		return bookVal;
	}
	
	/*
	 * void Insert(String n1, int n2, int n3, String n4, String n5, int n6, int n7)
	 * { try { DbConnect(); state = conn.createStatement(); String input =
	 * String.format("Insert into userpro value('%s','%d','%d','%s','%s','%d','%d')"
	 * , n1, n2, n3, n4, n5, n6, n7); state.executeUpdate(input); } catch (Exception
	 * e) { } finally { Close(); } }
	 */

	void Insert(String n1, String n2, String n3, String n4, String n5, String n6, String n7) {
		try {
			DbConnect();
			state = conn.createStatement();
			String input = String.format("Insert into userpro value('%s','%s','%s','%s','%s','%s','%s')", n1, n2, n3,
					n4, n5, n6, n7);
			state.executeUpdate(input);
		} catch (Exception e) {
		} finally {
			Close();
		}
	}


	int Jungbok(String s1) {
		try {
			DbConnect();
			state = conn.createStatement(); // state ����
			String s = String.format("select id from userpro where id = '%s';", s1); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);
			if(aa.next()) {
				n = 1;
			}else {
				n = 0;
			}
				
			aa.close();
		} catch (Exception e) {
		} finally {
			Close();
		}
		return n;
	}
	// �˻�
	/*
	 * void Out() { System.out.println("�˻��� Id�� �Է� : "); String s = sc.next();
	 * 
	 * for(MemberShip m : a) { if(s.equals(m.getId())){ System.out.println(); } } }
	 */


	String Out4(String s) {
		try {
			DbConnect();

			state = conn.createStatement(); // state ����
			String input = String.format("select * from userpro where id = '%s';", s); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(input);

			if (aa.next()) {
				s1 = aa.getString("id");
				s2 = aa.getString("pw");
			}
			aa.close();
		} catch (Exception e) {
		} finally {
			Close();
		}
		return s1;
	}


	// ȸ������
	void remove() {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ Id�� �Է� : ");
		String s = sc.next();

		try {
			DbConnect();

			state = conn.createStatement(); // state ����
			String input = String.format("delete from userpro where id = '%s';", s); // ��� ���̺� ����
			System.out.println("�ش�Ǵ� ȸ�������� �����Ǿ����ϴ�.");
			state.executeUpdate(input);
			state.close();
		} catch (Exception e) {
		} finally {
			Close();
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
				//Out3();
				break;
			case 3:
				//print();
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
