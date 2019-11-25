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
		System.out.print("아이디를 입력하세요 : "); // 아이디
		String s1 = sc.next();
		Jungbok();
		System.out.print("비밀번호를 입력하세요 : "); // 비밀번호
		int n1 = sc.nextInt();
		System.out.print("이름을 입력하세요 : "); // 이름
		String s2 = sc.next();
		System.out.print("성별을 입력하세요 : "); // 이름
		String s3 = sc.next();
		System.out.print("휴대폰번호를 입력하세요 : "); // 휴대폰번호
		int n2 = sc.nextInt();
		System.out.print("주민등록번호 앞자리를 입력하세요 : ");// 주민등록번호
		int n3 = sc.nextInt();
		System.out.println("가입이 완료되었습니다!");
		Insert(s1, n1, s2, s3, n2, n3);
		arr[0] = s1;
		Db();
	}

	ArrayList<UserDTO> Db() { // 모델링한 객체의 값을 넣기위해 ArrayList 생성
		ArrayList<UserDTO> userDTO = new ArrayList<UserDTO>();
		try {
			userDAO.DbConnect();
			state = conn.createStatement(); // state 연결
			String s = "select * from user;";
			// "insert into book value('hyungil', 'Junghyungil', 1 , 'm', 01088658860, 1234,
			// 941010);";
			// state.executeUpdate(s); // 테이블에 값 넣기
			ResultSet aa = state.executeQuery(s);
			while (aa.next()) {
				UserDTO m = new UserDTO(); // 모델링한 객체
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

	// 중복을 확인하기 위한 메소드
	void Jungbok() {
		try {
			userDAO.DbConnect();
			state = conn.createStatement(); // state 연결
			String s = String.format("select id from user where id = '%s';", s2); // 출력 테이블 대입
			ResultSet aa = state.executeQuery(s);

			while (aa.next()) {
				// String z = aa.getString("id");
				System.out.println("중복");
				System.out.println("다시 입력 하세요 : ");
				s2 = sc.next();
				// break;
			}
			aa.close();
		} catch (Exception e) {
		} finally {
			userDAO.Close();
		}

	}

	// 검색
	void Out3() {
		System.out.println("검색할 Id를 입력 : ");
		String s = sc.next();
		try {
			userDAO.DbConnect();

			state = conn.createStatement(); // state 연결
			String input = String.format("select * from user where id = '%s';", s); // 출력 테이블 대입
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

	// 전체 출력
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

	// 회원삭제
	void remove() {

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 Id를 입력 : ");
		String s = sc.next();

		try {
			userDAO.DbConnect();

			state = conn.createStatement(); // state 연결
			String input = String.format("delete from user where id = '%s';", s); // 출력 테이블 대입
			System.out.println("해당되는 회원정보가 삭제되었습니다.");
			state.executeUpdate(input);
			state.close();
		} catch (Exception e) {
		} finally {
			userDAO.Close();
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

