package userMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Entry extends JFrame implements ActionListener {
	JPanel panel = new JPanel();
	
	JButton btn1 = new JButton("����");
	
	public Entry() {
		
		JPanel panel = new JPanel();
		
		setBounds(1240, 260, 200, 200);
		JLabel id = new JLabel("�α��� �Ǿ����ϴ�.");
		
		panel.add(btn1);
		panel.add(id);
		
		
		add(panel);
		setVisible(true);
		panel.setLayout(null);
		
		id.setBounds(35, 10, 110, 60);
		btn1.setBounds(59, 60, 60, 40);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
			}
		});
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
