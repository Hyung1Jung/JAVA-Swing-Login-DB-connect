package fileExam;

import java.io.File;
import java.util.*;


public class FireExam01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File f = new File("D:\\Junghyungil\\examFolder\\test.txt");
		if(f.exists()) {
			System.out.println("�����մϴ�.");
			if(f.isDirectory()) {
				System.out.println("***���� ����***");
				
				String[] data = f.list();
				for(String s : data)
					System.out.println(s);
			}else {
				System.out.println("***���� ����***");
				System.out.println("�����̸� : " + f.getName());
				System.out.println("���� ��� : " + f.getAbsolutePath());
				System.out.println("�б� ����  : "  + f.canRead());
				System.out.println("���� ���� : " + f.canWrite());
				System.out.println("���� ���� : " + f.length() + "Byte");
				
				long time = f.lastModified();
				Date lastModifier = new Date(time);
				System.out.println("���� ��¥ " + lastModifier);
				f.delete();
			}
		}else { 
			System.out.println("�����ϴ�.");
			f.mkdir();
		}
	
		}
	}


