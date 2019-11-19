package userAdmin;

import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;

public class User {

	int in = 0;
	int n = 0;

	ArrayList<MemberShip> mb = new ArrayList<MemberShip>();

	Scanner sc = new Scanner(System.in);

	// ȸ�����Կ� ���� �޼ҵ�
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("���̵� �Է��ϼ��� : "); // ���̵�
		String s = sc.next();
		for (int i = 0; i < mb.size(); i++) {
			if (mb.get(i).getId().equals(s)) {
				System.out.println("�ߺ��� ���̵� �Է�");
				System.out.print("���̵� �Է��ϼ��� : ");
				s = sc.next();
			}
		}
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
		FileOutputStream f2 = null;
		try {
			n++;
			String data = "";
			f = new FileOutputStream("D:\\Junghyungil\\Test\\allData.txt", true);
			f2 = new FileOutputStream("D:\\Junghyungil\\Test\\soloData\\" + mb.get(in).getId() + ".txt");
			data = "ȸ�����̵� : " + mb.get(in).getId() + " �̸� : " + mb.get(in).getName() + " ȸ����ȣ : "
					+ (mb.get(in).getUn() + n) + " ���� : " + mb.get(in).getSe() + " �޴��� ��ȣ : " + mb.get(in).getPh()
					+ "\n";

			in++;
			f.write(data.getBytes());
			f2.write(data.getBytes());
		} catch (Exception e) {
			System.out.println(e + " == ���Ͼ��� ����");
		} finally {
			try {
				f.close();
				f2.close();
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

	// �˻�2 - ���� ������ �˻��� �����ϰ� �����ص� ȸ���� �����ʹ� ��� ���������� �����ϸ� arraylist�� �ʱ�ȭ�Ǽ� �ٽ� ������Ҷ���
	// �˻��Ҷ� ã���� ���Ѵ�
	void Out2() {
		String data = "";
		System.out.print("�˻��� ȸ���� �̸��� �Է��Ͻÿ� : ");
		String s = sc.next();
		for (int i = 0; i < mb.size(); i++) {
			if (s.equals(mb.get(i).getId())) {
				data = "ȸ�����̵� : " + mb.get(i).getId() + " �̸� : " + mb.get(i).getName() + " ȸ����ȣ : " + mb.get(i).getUn()
						+ n + " ���� : " + mb.get(i).getSe() + " �޴��� ��ȣ : " + mb.get(i).getPh() + "\n";
			}
		}
		FileOutputStream f = null;
		try {
			f = new FileOutputStream("D:\\Junghyungil\\Test\\searchData2.txt");
			f.write(data.getBytes());
			Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\searchData2.txt"));
		} catch (Exception e) {
			System.out.println("�˻� ����");
		} finally {
			try {
				f.close();
			} catch (Exception e) {
			}
		}
	}

	//
	void Out() { 
		String data = "";

		System.out.println("�˻��� ȸ���� �̸��� �Է��Ͻÿ� : ");
		String s = sc.next();

		FileInputStream f_read = null;
		FileOutputStream f_write = null;
		try {
			f_read = new FileInputStream("D:\\Junghyungil\\Test\\soloData\\" + s + ".txt");
			f_write = new FileOutputStream("D:\\Junghyungil\\Test\\searchData.txt");
			byte[] b = new byte[f_read.available()];
			while (f_read.read(b) != -1) {
			}
			f_write.write(b);
			Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\searchData.txt"));
		} catch (Exception e) {
			System.out.println(s + "��� Id�� ���� ȸ���� �����ϴ�.");
		} finally {
			try {
				f_read.close();
				f_write.close();
			} catch (Exception e) {
			}
		}
	}

	// �޴��� ���� �޼ҵ�
	void menu() {
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
				Out();
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