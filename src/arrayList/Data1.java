package arrayList;

import java.util.ArrayList;

//�̸�, ��ȣ, ������ ����, ���
//�𵨸� Ŭ����
class Sungjuk{ // �̸�, ��ȣ, ������ ���� setter�� �ʿ���
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
		System.out.println("�̸� : " + name);
		System.out.println("��ȣ : " + number);
		System.out.println("���� �� : " + sum);
		System.out.println("���� ��� : " + avg);
	}
	void EvOut() {
		for(int i = 0; i < 5; i++) {
			System.out.println("�̸� : " + name);
			System.out.println("��ȣ : " + number);
			System.out.println("���� �� : " + sum);
			System.out.println("���� ��� : " + avg);		
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
