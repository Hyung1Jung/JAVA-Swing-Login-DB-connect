package fileExam;

import java.io.*;
import java.io.FileOutputStream;
import java.util.*;


public class fileExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream f = null;
		try {
	
		f = new FileOutputStream("D:\\Junghyungil\\examFolder\\test.txt");
		// f = new FileOutputStream("D:\\Junghyungil\\examFolder\\test.txt", true);
		String data = "우리 열심히해서 빨리 밥 먹으로 가요";
		byte b[] = data.getBytes();
		f.write(b);
		f.write(65);
		
		}catch(Exception e) {
			System.out.println(e + " == 파일쓰기 실패");
		}finally {
			try {
				f.close();	
			}catch(Exception e) {
				System.out.println(e + " == close 실패");
			}
		}
	}

}
