package swing.userAdmin.mvc;

public class UserDTO {
	String id, name, email, sex; // 아이디, 이름, 이메일, 성별
	int pw, ph, jumin; // 비밀번호, 폰번호

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public int getPh() {
		return ph;
	}

	public void setPh(int ph) {
		this.ph = ph;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getJumin() {
		return jumin;
	}

	public void setJumin(int jumin) {
		this.jumin = jumin;
	}

}
