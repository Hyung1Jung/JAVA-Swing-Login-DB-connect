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

	// 회원가입에 대한 메소드
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("아이디를 입력하세요 : "); // 아이디
		String s = sc.next();
		for (int i = 0; i < mb.size(); i++) {
			if (mb.get(i).getId().equals(s)) {
				System.out.println("중복된 아이디 입력");
				System.out.print("아이디를 입력하세요 : ");
				s = sc.next();
			}
		}
		mb2.setId(s);
		System.out.print("비밀번호를 입력하세요 : "); // 비밀번호
		mb2.setPw(sc.nextInt());
		System.out.print("이름을 입력하세요 : "); // 이름
		mb2.setName(sc.next());
		System.out.print("성별을 입력하세요(남/여) : "); // 성별
		mb2.setSe(sc.next());
		System.out.print("휴대폰번호를 입력하세요 : "); // 휴대폰번호
		mb2.setPh(sc.nextInt());
		System.out.print("주민등록번호 앞자리를 입력하세요 : ");// 주민등록번호
		mb2.setJumin(sc.nextInt());
		System.out.println("가입이 완료되었습니다!");
		mb2.setUn(n++);
		mb.add(mb2);
		Db();

	}

	void Db() { // 데이터베이스화
		FileOutputStream f = null;
		FileOutputStream f2 = null;
		try {
			n++;
			String data = "";
			f = new FileOutputStream("D:\\Junghyungil\\Test\\allData.txt", true);
			f2 = new FileOutputStream("D:\\Junghyungil\\Test\\soloData\\" + mb.get(in).getId() + ".txt");
			data = "회원아이디 : " + mb.get(in).getId() + " 이름 : " + mb.get(in).getName() + " 회원번호 : "
					+ (mb.get(in).getUn() + n) + " 성별 : " + mb.get(in).getSe() + " 휴대폰 번호 : " + mb.get(in).getPh()
					+ "\n";

			in++;
			f.write(data.getBytes());
			f2.write(data.getBytes());
		} catch (Exception e) {
			System.out.println(e + " == 파일쓰기 실패");
		} finally {
			try {
				f.close();
				f2.close();
			} catch (Exception e) {
				System.out.println(e + " == close 실패");
			}
		}
	}

	// 전체출력
	void print() {
		try {
			Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\allData.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 검색2 - 종료 전에는 검색이 가능하고 종료해도 회원들 데이터는 계속 남아있지만 종료하면 arraylist가 초기화되서 다시 재실행할때는
	// 검색할때 찾지를 못한다
	void Out2() {
		String data = "";
		System.out.print("검색할 회원의 이름을 입력하시오 : ");
		String s = sc.next();
		for (int i = 0; i < mb.size(); i++) {
			if (s.equals(mb.get(i).getId())) {
				data = "회원아이디 : " + mb.get(i).getId() + " 이름 : " + mb.get(i).getName() + " 회원번호 : " + mb.get(i).getUn()
						+ n + " 성별 : " + mb.get(i).getSe() + " 휴대폰 번호 : " + mb.get(i).getPh() + "\n";
			}
		}
		FileOutputStream f = null;
		try {
			f = new FileOutputStream("D:\\Junghyungil\\Test\\searchData2.txt");
			f.write(data.getBytes());
			Desktop.getDesktop().open(new File("D:\\Junghyungil\\Test\\searchData2.txt"));
		} catch (Exception e) {
			System.out.println("검색 실패");
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

		System.out.println("검색할 회원의 이름을 입력하시오 : ");
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
			System.out.println(s + "라는 Id를 가진 회원은 없습니다.");
		} finally {
			try {
				f_read.close();
				f_write.close();
			} catch (Exception e) {
			}
		}
	}

	// 메뉴를 위한 메소드
	void menu() {
		int menu = 0;
		do {
			System.out.println("1:회원 가입    2:검색출력     3:전체출력     4:종료 ");
			System.out.print("번호 입력 : ");
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
				System.out.print("종료");
				return;
			default:
				System.out.println("메뉴 선택 오류");
			}
		} while (menu != 5);
	}

}