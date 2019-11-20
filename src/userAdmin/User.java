package userAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;

public class User {
	String s;
	int in = 0;
	int n = 0;

	ArrayList<MemberShip> mb = new ArrayList<MemberShip>();

	Scanner sc = new Scanner(System.in);

	// ȸ�����Կ� ���� �޼ҵ�
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("���̵� �Է��ϼ��� : "); // ���̵�
		s = sc.next();
		jungbok();
		mb2.setId(s);
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
		FileOutputStream f = null;

		try {
			n++;
			String data = "";
			f = new FileOutputStream("D:\\Junghyungil\\Test\\allData.txt", true);
			data = "ȸ�����̵� : " + mb.get(in).getId() + " �̸� : " + mb.get(in).getName() + "  ȸ����ȣ : "
					+ (mb.get(in).getUn() + n) + "  ���� : " + mb.get(in).getSe() + "  �޴��� ��ȣ : " + mb.get(in).getPh()
					+ "\n";
			in++;
			f.write(data.getBytes());
		} catch (Exception e) {
			System.out.println(e + " == ���Ͼ��� ����");
		} finally {
			try {
				f.close();
			} catch (Exception e) {
				System.out.println(e + " == close ����");
			}
		}
	}

	// ��ü���
	void print() {
		try {
			Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\allData.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// �ߺ��� Ȯ���ϱ� ���� �޼ҵ�
	void jungbok() {
		FileReader fr = null;
		BufferedReader br = null;
		String data;
		File f = new File("D:\\Junghyungil\\Test\\allData.txt");
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while ((data = br.readLine()) != null) {
				while(!s.contains(data)) {
					System.out.println("�ߺ��� ���̵� �Դϴ�.");
					System.out.println("���̵� �Է��ϼ��� : ");
					s = sc.next();
					break;
			
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				fr.close();
				br.close();
			} catch (Exception e) {
			}
		}
	}

	void Out3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� �̸� �Է� : ");
		String s = sc.next();
		FileOutputStream f_write = null;
		FileReader fr = null;
		BufferedReader br = null;
		String data = null;

		File f = new File("D:\\Junghyungil\\Test\\allData.txt");
		try {
			f_write = new FileOutputStream("D:\\Junghyungil\\Test\\searchData.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while ((data = br.readLine()) != null) {
				if (data.contains(s)) {
					f_write.write(data.getBytes());
					Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\searchData.txt"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				fr.close();
				br.close();
			} catch (Exception e) {
			}
		}

	}

	// �޴��� ���� �޼ҵ�
	void menu() {
		System.out.println("ȸ������ ���α׷�");
		int menu = 0;
		do {
			System.out.println("1:ȸ�� ����    2:�˻����     3:��ü���     4:���� ");
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
				System.out.print("����");
				return;
			default:
				System.out.println("�޴� ���� ����");
			}
		} while (menu != 5);
	}

}
