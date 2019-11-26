package userMVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Login extends JFrame implements ActionListener {
			

			JLabel f = new JLabel("환영합니다.");
			
			JPanel p = new JPanel();

			public Login() {

				p.add(f);
				setBounds(230, 260, 1015, 690);
				
				dispose();
				
				
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				add(p);

			}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}