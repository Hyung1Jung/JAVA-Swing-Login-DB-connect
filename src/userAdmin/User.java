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

	// 회원가입에 대한 메소드
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("아이디를 입력하세요 : "); // 아이디
		s = sc.next();
		jungbok();
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

		try {
			n++;
			String data = "";
			f = new FileOutputStream("D:\\Junghyungil\\Test\\allData.txt", true);
			data = "회원아이디 : " + mb.get(in).getId() + " 이름 : " + mb.get(in).getName() + "  회원번호 : "
					+ (mb.get(in).getUn() + n) + "  성별 : " + mb.get(in).getSe() + "  휴대폰 번호 : " + mb.get(in).getPh()
					+ "\n";
			in++;
			f.write(data.getBytes());
		} catch (Exception e) {
			System.out.println(e + " == 파일쓰기 실패");
		} finally {
			try {
				f.close();
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
	// 중복을 확인하기 위한 메소드
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
					System.out.println("중복된 아이디 입니다.");
					System.out.println("아이디를 입력하세요 : ");
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
		System.out.print("검색할 이름 입력 : ");
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

	// 메뉴를 위한 메소드
	void menu() {
		System.out.println("회원가입 프로그램");
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
				Out3();
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
