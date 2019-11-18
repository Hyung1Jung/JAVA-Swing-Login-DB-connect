package arrayList;

import java.util.Scanner;

//성적관리 class(M) : 이름, 변수, 국/영/수  총,평
//성적관리 class(c) : M.class 객체 5 <-- 입력하기, 출력하기, 계산하기
public class M {
	String name;
	public int kor, eng, math, sum;
	double avg;
	Object ar[] = new Object[5];

	
	/*
	public M(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	
	}
	*/
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {  // 국어
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) { // 영어
		this.eng = eng;
	}
	
	public int getMath() { // 수학
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		setName(sc.next());
		System.out.print("국어 점수 : ");
		setKor(sc.nextInt());
		System.out.print("영어 점수 : ");
		setEng(sc.nextInt());
		System.out.print("수학 점수 : ");
		setMath(sc.nextInt());
	}
	
	public void sum() {
		sum = kor + math + eng;
	}
	public void avg() {
		avg = sum / 3.0;
	}
	
	

}
