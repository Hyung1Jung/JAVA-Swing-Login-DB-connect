package userAdmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dbExam.DbExam02Test;

import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	String arr[] = new String[1];
	int in = 0;
	int n = 0;

	ArrayList<MemberShip> a;

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	Connection conn = null;
	Statement state = null;

	Scanner sc = new Scanner(System.in);

	void User() { // mysql연결 메소드 , 한 번만 쓰면 되니까 생성자와 동시에 초기화
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

	// 회원가입에 대한 메소드
	void put() {
		int n = 1;
		System.out.print("아이디를 입력하세요 : "); // 아이디
		arr[0] = sc.next();
		Jungbok();
		System.out.print("비밀번호를 입력하세요 : "); // 비밀번호
		int n6 = sc.nextInt();
		System.out.println("번호를 입력하세요 : ");
		int n3 = sc.nextInt();
		System.out.print("이름을 입력하세요 : "); // 이름
		String n2 = sc.next();
		System.out.print("성별을 입력하세요(남/여) : "); // 성별
		String n4 = sc.next();
		System.out.print("휴대폰번호를 입력하세요 : "); // 휴대폰번호
		int n5 = sc.nextInt();
		System.out.print("주민등록번호 앞자리를 입력하세요 : ");// 주민등록번호
		int n7 = sc.nextInt();
		System.out.println("가입이 완료되었습니다!");
		Insert(arr[0], n2, n3, n4, n5, n6, n7);
		Db();
	}

	ArrayList<MemberShip> Db() { // 모델링한 객체의 값을 넣기위해 ArrayList 생성
		ArrayList<MemberShip> bookVal = new ArrayList<MemberShip>();
		try {
			DbConnect();
			state = conn.createStatement(); // state 연결
			String s = "select * from userpro;";
			// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234,
			// 941010);";
			// state.executeUpdate(s); // 테이블에 값 넣기
			ResultSet aa = state.executeQuery(s);
			while (aa.next()) {
				MemberShip m = new MemberShip(); // 모델링한 객체
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

	void Insert(String n1, String n2, int n3, String n4, int n5, int n6, int n7) {
		try {
			DbConnect();
			state = conn.createStatement();
			String input = String.format("Insert into userpro value('%s','%s','%d','%s','%d','%d','%d')", n1, n2, n3,
					n4, n5, n6, n7);
			state.executeUpdate(input);
		} catch (Exception e) {
		} finally {
			Close();
		}
	}

	// 중복을 확인하기 위한 메소드
	void Jungbok() {
		try {
			DbConnect();
			state = conn.createStatement(); // state 연결
			String s = String.format("select id from userpro where id = '%s';", arr[0]); // 출력 테이블 대입
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				// String z = aa.getString("id");
				System.out.println("중복");
				System.out.println("다시 입력 하세요 : ");
				arr[0] = sc.next();
				// break;
			}
			aa.close();
		} catch (Exception e) {
		} finally {
			Close();
		}

	}

	// 검색
	/*
	void Out() {
		System.out.println("검색할 Id를 입력 : ");
		String s = sc.next();
		
		for(MemberShip m : a) {
			if(s.equals(m.getId())){
				System.out.println();
			}
		}
	}
	*/
	void Out3() {
		DbConnect();


		System.out.println("검색할 Id를 입력 : ");
		String s = sc.next();

		try {
			DbConnect();

			state = conn.createStatement(); // state 연결
			String input = String.format("select * from userpro where id = '%s';", s); // 출력 테이블 대입
			ResultSet aa = state.executeQuery(input);

			if (aa.next()) {
				String s1 = aa.getString("id");
				String s2 = aa.getString("name");
				int n1 = aa.getInt("no");
				String s3 = aa.getString("sex");
				int n2 = aa.getInt("ph");
				int n3 = aa.getInt("pw");
				int n4 = aa.getInt("jumin");

			}

			aa.close();
		} catch (Exception e) {
		} finally {
			Close();
		}
	}

	// 전체 출력
	void print() {
		Db();
		for (MemberShip s : a) {
			System.out.print("id : " + s.getId());
			System.out.print("  name : " + s.getName());
			System.out.print("  no : " + s.getUn());
			System.out.print("  sex : " + s.getSe());
			System.out.print("  ph : " + s.getPh());
			System.out.print("  pw : " + s.getPw());
			System.out.print("  jumin : " + s.getJumin());

			System.out.println();
		}
	}

	// 회원삭제
	void remove() {

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 Id를 입력 : ");
		String s = sc.next();

		try {
			DbConnect();

			state = conn.createStatement(); // state 연결
			String input = String.format("delete from userpro where id = '%s';", s); // 출력 테이블 대입
			System.out.println("해당되는 회원정보가 삭제되었습니다.");
			state.executeUpdate(input);
			state.close();
		} catch (Exception e) {
		} finally {
			Close();
		}
	}

	// 메뉴를 위한 메소드
	void menu() {
		System.out.println("회원가입 프로그램");
		int menu = 0;
		do {
			System.out.println("1:회원 가입    2:검색출력     3:전체출력     4:삭제    5: 종료 ");
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
				remove();
				break;
			case 5:
				System.out.print("종료");
				return;
			default:
				System.out.println("메뉴 선택 오류");
			}
		} while (menu != 6);
	}

}
