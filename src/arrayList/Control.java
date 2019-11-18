package arrayList;

import java.util.ArrayList;
import java.util.Scanner;


public class Control {
	//성적관리 설계에 관련된 클래스( 1. 모델링 클래스에 객체만들기(5개)  2.메소드 (입력, 출력, 계산))

	ArrayList<Sungjuk> ob = new ArrayList<Sungjuk>(5);
	Sungjuk oo = new Sungjuk(); 

	void put() {			
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		oo.setName(sc.nextLine());
		System.out.print("번호 : ");
		oo.setNumber(sc.nextInt());
		System.out.print("국어 점수 : ");
		oo.setKor(sc.nextInt());
		System.out.print("영어 점수 : ");
		oo.setEng(sc.nextInt());
		System.out.print("수학 점수 : ");
		oo.setMath(sc.nextInt()); 
		ob.add(oo);
		sum();
		avg();

	}


	void out() {
		System.out.println("이름 : " + oo.name);
		System.out.println("번호 : " + oo.number);
		System.out.println("점수 합 : " + oo.sum);
		System.out.println("점수 평균 : " + oo.avg);
	}
	
	void avg() {
		ob.get(oo.number - 1).avg = oo.sum / 3.0;
	
	}
	void sum() { //계산하기
		//ob.get(oo.number - 1).setSum(ob.get(oo.number - 1).getKor() + ob.get(oo.number - 1).getEng() + ob.get(oo.number - 1).getMath());
		//ob.get(oo.number -1).setSum(3);
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getKor();
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getEng();
		ob.get(oo.number -1).sum += ob.get(oo.number - 1).getMath();
}	
	void EvOut() {
		int n = ob.size();
		for(int i = 0; i < n; i++) {
			System.out.println("이름 : " + ob.get(i).getName());
			System.out.println("번호 : " + ob.get(i).number);
			System.out.println("점수 합 : " + ob.get(i).sum);
			System.out.println("점수 평균 : " + ob.get(i).avg);		
	}
}

	/*
	 1.회원정보 입력
	 2.회원정보 출력
	 */
	void menu() {
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1 : 회원정보입력  2 : 전체출력  3 : 검색출력   4 : 종료 ");
			System.out.print("번호 입력 : ");
			menu = sc.nextInt();
			switch(menu) {
			case 1 : 
				put();
				break;
			case 2 : 
				EvOut();
				break;
			case 3 : 
				System.out.print("몇 번 학생을 검색하시겠습니까? " );
				int n = sc.nextInt();
				ob.get(n - 1).out();
				//sum();
				break;
			case 4 : 
				System.out.print("종료" );
				return;
			default : 
				System.out.println("메뉴 선택 오류");
			}
		}while(menu != 5);
	}

}
//ob.get(oo.number - 1).


