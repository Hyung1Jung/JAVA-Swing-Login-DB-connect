package fileExam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileExam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream f_read = null;
		FileOutputStream f_write = null;
		try {
			f_read = new FileInputStream("D:\\Junghyungil\\examFolder\\test.txt");
			f_write = new FileOutputStream("D:\\Junghyungil\\examFolder\\test2.txt");

			byte[] b = new byte[f_read.available()];
			while(f_read.read(b)!=-1) {}
			f_write.write(b);
		}catch(IOException e) {
			System.out.println(e + "파일 오류");
		}finally {
			try {
				f_read.close();
				f_write.close();
			}catch(Exception e) {
				System.out.println(e + "close 실패");
			}
		}

	}

}
