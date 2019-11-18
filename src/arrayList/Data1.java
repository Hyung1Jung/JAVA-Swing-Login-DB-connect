package arrayList;

import java.util.ArrayList;

//이름, 번호, 국영수 총점, 평균
//모델링 클래스
class Sungjuk{ // 이름, 번호, 국영수 값은 setter가 필요함
	String name;
	int number, kor, eng, math, sum = 0;
	double avg;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	
	void out() {
		System.out.println("이름 : " + name);
		System.out.println("번호 : " + number);
		System.out.println("점수 합 : " + sum);
		System.out.println("점수 평균 : " + avg);
	}
	void EvOut() {
		for(int i = 0; i < 5; i++) {
			System.out.println("이름 : " + name);
			System.out.println("번호 : " + number);
			System.out.println("점수 합 : " + sum);
			System.out.println("점수 평균 : " + avg);		
		}
	}
}

public class Data1 {

	public static void main(String[] args) {
		Control c = new Control();	
		c.menu();

		System.out.println();
		
		
	}



}
