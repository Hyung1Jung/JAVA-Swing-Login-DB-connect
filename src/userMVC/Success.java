package userMVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Success extends JFrame implements ActionListener {

	JLabel f = new JLabel("가입이 완료되었습니다.");
	JButton btn1 = new JButton("완료");
	
	JPanel p = new JPanel();

	public Success() {

		p.add(f);
		p.add(btn1);
		setBounds(700, 290, 250, 100);
		
		dispose();
		
		btn1.setBounds(200, 100, 100, 100);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(p);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
