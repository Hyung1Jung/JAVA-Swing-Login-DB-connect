package arrayList;

import java.util.ArrayList;
import java.util.Scanner;


public class Control {
	//�������� ���迡 ���õ� Ŭ����( 1. �𵨸� Ŭ������ ��ü�����(5��)  2.�޼ҵ� (�Է�, ���, ���))

	ArrayList<Sungjuk> ob = new ArrayList<Sungjuk>(5);
	Sungjuk oo = new Sungjuk(); 

	void put() {			
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� : ");
		oo.setName(sc.nextLine());
		System.out.print("��ȣ : ");
		oo.setNumber(sc.nextInt());
		System.out.print("���� ���� : ");
		oo.setKor(sc.nextInt());
		System.out.print("���� ���� : ");
		oo.setEng(sc.nextInt());
		System.out.print("���� ���� : ");
		oo.setMath(sc.nextInt()); 
		ob.add(oo);
		sum();
		avg();

	}


	void out() {
		System.out.println("�̸� : " + oo.name);
		System.out.println("��ȣ : " + oo.number);
		System.out.println("���� �� : " + oo.sum);
		System.out.println("���� ��� : " + oo.avg);
	}
	
	void avg() {
		ob.get(oo.number - 1).avg = oo.sum / 3.0;
	
	}
	void sum() { //����ϱ�
		//ob.get(oo.number - 1).setSum(ob.get(oo.number - 1).getKor() + ob.get(oo.number - 1).getEng() + ob.get(oo.number - 1).getMath());
		//ob.get(oo.number -1).setSum(3);
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getKor();
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getEng();
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getMath();
}	
	void EvOut() {
		int n = ob.size();
		for(int i = 0; i < n; i++) {
			System.out.println("�̸� : " + ob.get(i).getName());
			System.out.println("��ȣ : " + ob.get(i).number);
			System.out.println("���� �� : " + ob.get(i).sum);
			System.out.println("���� ��� : " + ob.get(i).avg);		
	}
}

	/*
	 1.ȸ������ �Է�
	 2.ȸ������ ���
	 */
	void menu() {
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1 : ȸ�������Է�  2 : ��ü���  3 : �˻����   4 : ���� ");
			System.out.print("��ȣ �Է� : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1 : 
				put();
				break;
			case 2 : 
				EvOut();
				break;
			case 3 : 
				System.out.print("�� �� �л��� �˻��Ͻðڽ��ϱ�? " );
				int n = sc.nextInt();
				ob.get(n - 1).out();
				//sum();
				break;
			case 4 : 
				System.out.print("����" );
				return;
			default : 
				System.out.println("�޴� ���� ����");
			}
		}while(menu != 5);
	}

}
//ob.get(oo.number - 1).


