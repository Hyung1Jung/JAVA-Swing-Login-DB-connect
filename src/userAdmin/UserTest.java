package userAdmin;

import java.io.*;

class MemberShip {
	// 변수 생성
	String id, name, se; // 아이디, 이름 , 성별
	int pw, jumin, ph, un; // 회원번호, 패스워드, 주민번호, 폰번호

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public int getJumin() {
		return jumin;
	}

	public void setJumin(int jumin) {
		this.jumin = jumin;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public int getUn() {
		return un;
	}

	public void setUn(int Un) {
		this.un = un;
	}

}

public class UserTest {
	// 성적프로그램 실행을 위한 main
	public static void main(String[] args) {
		User u = new User();
		u.menu();

	}
}