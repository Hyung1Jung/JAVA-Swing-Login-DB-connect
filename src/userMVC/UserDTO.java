package userMVC;

import java.io.*;

public class UserDTO {
	// ���� ����
	String id, name, se; // ���̵�, �̸� , ����
	int pw, jumin, ph, un; // ��й�ȣ, �ֹι�ȣ, ����ȣ, ȸ����ȣ

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

	public void setUn(int un) {
		this.un = un;
	}

	public int getUn() {
		return un;
	}

	 void setSex(String string) {
		// TODO Auto-generated method stub
		
	}

}
