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
	private final String DB_URl = "jdbc:mysql://localhost/db01"; // ?? 데이터베이스 이름, cmd에서 use 데이터베이스명 하고 같음

	private final String USER_NAME = "root";
	private final String PASSWORD = "a88658860@";

	ArrayList<MemberShip> mb = new ArrayList<MemberShip>();

	Scanner sc = new Scanner(System.in);

	// 회원가입에 대한 메소드
	void put() {
		int n = 1;
		MemberShip mb2 = new MemberShip();
		System.out.print("아이디를 입력하세요 : "); // 아이디
		arr[0] = sc.next();
		Jungbok();
		mb2.setId(arr[0]);
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

			state = conn.createStatement(); // state 연결
			String input = String.format("Insert into userpro value('%s','%s','%d','%s','%d','%d','%d')", n1, n2, n3,
					n4, n5, n6, n7);
			in++;
			state.executeUpdate(input); // 테이블에 값 넣기
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
	

	// 전체출력
	void print() {
		Connection conn = null;
		Statement state = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state 연결
			String s = "select * from userpro;"; // 출력 테이블 대입
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

	// 중복을 확인하기 위한 메소드
	void Jungbok() {
		
		Connection conn = null;
		Statement state = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state 연결
			String s = String.format("select id from userpro where id = '%s';",arr[0]); // 출력 테이블 대입
			ResultSet aa = state.executeQuery(s);
	
			
			while(aa.next()) {
				//String z = aa.getString("id");
				System.out.println("중복");
				System.out.println("다시입력 : ");
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

	// 검색
	void Out3() {
		Connection conn = null;
		Statement state = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 Id를 입력 : ");
		String s = sc.next();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

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

	//회원삭제
	void remove() {
		Connection conn = null;
		Statement state = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 Id를 입력 : ");
		String s = sc.next();

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URl, USER_NAME, PASSWORD);

			state = conn.createStatement(); // state 연결
			String input = String.format("delete from userpro where id = '%s';", s); // 출력 테이블 대입
			System.out.println("해당되는 회원정보가 삭제되었습니다.");
			
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
