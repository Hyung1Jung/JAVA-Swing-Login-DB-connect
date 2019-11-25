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

public class Method {
	String[] arr = new String[1];
	UserDAO userDAO = new UserDAO();
	ArrayList<UserDTO> a;
	Connection conn = null;
	Statement state = null;
	Scanner sc = new Scanner(System.in);
	String s2;
	
	void put() {
		System.out.print("���̵� �Է��ϼ��� : "); // ���̵�
		String s1 = sc.next();
		Jungbok();
		System.out.print("��й�ȣ�� �Է��ϼ��� : "); // ��й�ȣ
		int n1 = sc.nextInt();
		System.out.print("�̸��� �Է��ϼ��� : "); // �̸�
		String s2 = sc.next();
		System.out.print("������ �Է��ϼ��� : "); // �̸�
		String s3 = sc.next();
		System.out.print("�޴�����ȣ�� �Է��ϼ��� : "); // �޴�����ȣ
		int n2 = sc.nextInt();
		System.out.print("�ֹε�Ϲ�ȣ ���ڸ��� �Է��ϼ��� : ");// �ֹε�Ϲ�ȣ
		int n3 = sc.nextInt();
		System.out.println("������ �Ϸ�Ǿ����ϴ�!");
		Insert(s1, n1, s2, s3, n2, n3);
		arr[0] = s1;
		Db();
	}

	ArrayList<UserDTO> Db() { // �𵨸��� ��ü�� ���� �ֱ����� ArrayList ����
		ArrayList<UserDTO> userDTO = new ArrayList<UserDTO>();
		try {
			userDAO.DbConnect();
			state = conn.createStatement(); // state ����
			String s = "select * from user;";
			// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234,
			// 941010);";
			// state.executeUpdate(s); // ���̺� �� �ֱ�
			ResultSet aa = state.executeQuery(s);
			while (aa.next()) {
				UserDTO m = new UserDTO(); // �𵨸��� ��ü
				m.setId(aa.getString("id"));
				m.setPw(aa.getInt("pw"));
				m.setName(aa.getString("name"));
				m.setSex(aa.getString("sex"));
				m.setPh(aa.getInt("ph"));
				m.setJumin(aa.getInt("jumin"));
				
			    userDTO.add(m);
			}
			aa.close();

		} catch (Exception e) {
		} finally {
			userDAO.Close();
		}
		a =  userDTO;
		return userDTO;
	}

	void Insert(String s1, int n1, String s2, String s3, int n2, int n3) {
		try {
			userDAO.DbConnect();
			state = conn.createStatement();
			String input = String.format("Insert into user value('%s','%d','%s','%s','%d','%d')", arr[0], n1, s2, s3, n2, n3);
			state.executeUpdate(input);
		} catch (Exception e) {
		} finally {
			userDAO.Close();
		}
	}

	// �ߺ��� Ȯ���ϱ� ���� �޼ҵ�
	void Jungbok() {
		try {
			userDAO.DbConnect();
			state = conn.createStatement(); // state ����
			String s = String.format("select id from user where id = '%s';", s2); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				// String z = aa.getString("id");
				System.out.println("�ߺ�");
				System.out.println("�ٽ� �Է� �ϼ��� : ");
				s2 = sc.next();
				// break;
			}
			aa.close();
		} catch (Exception e) {
		} finally {
			userDAO.Close();
		}

	}

	// �˻�
	void Out3() {
		System.out.println("�˻��� Id�� �Է� : ");
		String s = sc.next();
		try {
			userDAO.DbConnect();

			state = conn.createStatement(); // state ����
			String input = String.format("select * from user where id = '%s';", s); // ��� ���̺� ����
			ResultSet aa = state.executeQuery(input);

			if (aa.next()) {
				System.out.print("id : " + aa.getString("id"));
				System.out.print("  pw : " + aa.getInt("pw"));
				System.out.print("  name : " + aa.getString("name"));
				System.out.print("  sex : " + aa.getString("sex"));
				System.out.print("  ph : " + aa.getInt("ph"));
				System.out.print("  jumin : " + aa.getInt("jumin"));
			}
			aa.close();
		} catch (Exception e) {
		} finally {
			userDAO.Close();
		}
	}

	// ��ü ���
	void print() {
		Db();
		for (UserDTO s : a) {
			System.out.print("id : " + s.getId());
			System.out.print("  pw : " + s.getPw());
			System.out.print("  name : " + s.getName());
			System.out.print("  sex : " + s.getSex());
			System.out.print("  ph : " + s.getPh());;
			System.out.print("  jumin : " + s.getJumin());
			System.out.println();
		}
	}

	// ȸ������
	void remove() {

		Scanner sc = new Scanner(System.in);
		System.out.println("������ Id�� �Է� : ");
		String s = sc.next();

		try {
			userDAO.DbConnect();

			state = conn.createStatement(); // state ����
			String input = String.format("delete from user where id = '%s';", s); // ��� ���̺� ����
			System.out.println("�ش�Ǵ� ȸ�������� �����Ǿ����ϴ�.");
			state.executeUpdate(input);
			state.close();
		} catch (Exception e) {
		} finally {
			userDAO.Close();
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

