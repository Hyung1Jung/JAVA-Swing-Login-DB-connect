package dbExam;

import java.util.ArrayList;
import java.util.Scanner;

public class DbExam02Test02 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbExam02 d = new DbExam02();
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<DbExam02Test> s = d.Db();
		
		System.out.println("filed information input");
		System.out.print("no 입력 : ");
		int n = sc.nextInt();
		System.out.print("name 입력 : ");
		String ss = sc.next();
		
		d.Insert(n, ss);
		
		for(int i = 0; i < s.size(); i++) {
			System.out.print("no : " +  s.get(i).getNo());
			System.out.print("  name : " + s.get(i).getName());
			System.out.println();
			
	}
	}
		
}
