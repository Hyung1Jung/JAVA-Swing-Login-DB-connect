package arrayList;

import java.util.Scanner;

//�������� class(M) : �̸�, ����, ��/��/��  ��,��
//�������� class(c) : M.class ��ü 5 <-- �Է��ϱ�, ����ϱ�, ����ϱ�
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
	
	public void setKor(int kor) {  // ����
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) { // ����
		this.eng = eng;
	}
	
	public int getMath() { // ����
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		setName(sc.next());
		System.out.print("���� ���� : ");
		setKor(sc.nextInt());
		System.out.print("���� ���� : ");
		setEng(sc.nextInt());
		System.out.print("���� ���� : ");
		setMath(sc.nextInt());
	}
	
	public void sum() {
		sum = kor + math + eng;
	}
	public void avg() {
		avg = sum / 3.0;
	}
	
	

}
