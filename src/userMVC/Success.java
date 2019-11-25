package userMVC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Success extends JFrame implements ActionListener {

	JLabel f = new JLabel("가입이 완료되었습니다.");
	JPanel p = new JPanel();

	public Success() {

		p.add(f);;
		setBounds(700, 290, 250, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		add(p);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
