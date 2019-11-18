package fileExam;

import java.io.*;

public class fileExam03 {
	public static void main(String[] args) {
		FileInputStream f = null;
		
		try {
			f = new FileInputStream("D:\\Junghyungil\\examFolder\\test.txt");
			System.out.println("availabe = " + f.available());
			byte b[] = new byte[f.available()]; // 바이트 수
			
			while(f.read(b) != -1) {}
			String data = new String(b);
			System.out.println(data);
		}catch(FileNotFoundException e) {
			System.out.println(e + "파일 생성 실패");
		}catch(IOException e) {
			System.out.println(e + "파일 읽기 실패");
		}finally {
			try {
				f.close();
			}catch(Exception e) {
				System.out.println(e + "close 실패");
			}
		}
	}
}
