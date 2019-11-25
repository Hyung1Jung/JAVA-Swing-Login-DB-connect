package swingExam;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelExam extends JFrame {
	// JTextField file = new JTextField (" ");
	JLabel file = new JLabel("hihi");
	JButton save = new JButton("Save");
	JButton west = new JButton("West");
	JButton center = new JButton("Center");
	JPanel p = new JPanel();

	public PanelExam() {
		p.setLayout(new FlowLayout());
		p.add(file);
		p.add(save);
		super.setLayout(new BorderLayout());
		super.add(p, "North");
		super.add(west, "West");
		super.add(center, "Center");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new PanelExam();
	}

}
