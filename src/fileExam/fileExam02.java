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
		String data = "�츮 �������ؼ� ���� �� ������ ����";
		byte b[] = data.getBytes();
		f.write(b);
		f.write(65);
		
		}catch(Exception e) {
			System.out.println(e + " == ���Ͼ��� ����");
		}finally {
			try {
				f.close();	
			}catch(Exception e) {
				System.out.println(e + " == close ����");
			}
		}
	}

}
