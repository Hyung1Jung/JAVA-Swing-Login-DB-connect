package fileExam;

import java.io.*;

public class fileExam03 {
	public static void main(String[] args) {
		FileInputStream f = null;
		
		try {
			f = new FileInputStream("D:\\Junghyungil\\examFolder\\test.txt");
			System.out.println("availabe = " + f.available());
			byte b[] = new byte[f.available()]; // ����Ʈ ��
			
			while(f.read(b) != -1) {}
			String data = new String(b);
			System.out.println(data);
		}catch(FileNotFoundException e) {
			System.out.println(e + "���� ���� ����");
		}catch(IOException e) {
			System.out.println(e + "���� �б� ����");
		}finally {
			try {
				f.close();
			}catch(Exception e) {
				System.out.println(e + "close ����");
			}
		}
	}
}
