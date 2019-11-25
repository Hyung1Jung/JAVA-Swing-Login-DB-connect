package swingExam;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameExam {
	JButton btn = new JButton("Click");
	JFrame f = new JFrame("jframeExam");
	
	public JFrameExam() {
		f.add(btn);
		f.setSize(300, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);;
	}
	public static void main(String[] args) {
		new JFrameExam();
	
	}
	
}
