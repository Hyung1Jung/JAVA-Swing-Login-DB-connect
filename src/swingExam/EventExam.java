package swingExam;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventExam implements ActionListener {
	JButton btn1 = new JButton("click!");
	JButton btn2 = new JButton("click!");
	JFrame f = new JFrame("jFrameExam");

	public EventExam() {
		f.add(btn1);
		f.add(btn2);
		f.setLayout(new FlowLayout());
		f.setSize(400, 300);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

		btn1.addActionListener(this);
	}

	public static void main(String[] args) {
		new EventExam();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str = arg0.getActionCommand();
		if (arg0.getSource() == btn1) {
			System.out.println("Hello");
		}
	}
}