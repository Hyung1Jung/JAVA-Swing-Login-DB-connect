package userMVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Login extends JFrame implements ActionListener {
		public Login() {
			JLabel Id = new JLabel("ID ют╥б : ");

			
			setBounds(230, 260, 1015, 690);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}