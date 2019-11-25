package userMVC;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Login;

class Main2 extends JFrame implements ActionListener {

	Login login;
	Join join;

	JButton btn1 = new JButton("Login");
	JButton btn2 = new JButton("Join");
	
	Connection conn = null;
	Statement state = null;
	
	public Main2() {
		JPanel panel = new JPanel();

		setBounds(230, 260, 1015, 690);

		JLabel Id = new JLabel("ID 입력 : ");
		Id.setFont(new Font("맑은고딕", Font.BOLD, 28));
		Id.setForeground(Color.black);
		JTextField tf = new JTextField(10);
		tf.setFont(new Font("맑은고딕", Font.BOLD, 28));

		JLabel pw = new JLabel("pw 입력 : ");
		pw.setFont(new Font("맑은고딕", Font.BOLD, 27));
		pw.setForeground(Color.black);
		JTextField tf2 = new JTextField(10);
		tf2.setFont(new Font("맑은고딕", Font.BOLD, 28));

		panel.setLayout(null);

		btn1.setBounds(420, 530, 100, 60);
		btn1.addActionListener(this);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String id = tf.getText().trim();
				String pw = tf2.getText().trim();
				
			if(id.length()==0 || pw.length()==0) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
				return;
			}
			if(id.equals("test") && pw.equals("test1")) {
				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				}
		});

		btn2.setBounds(520, 530, 100, 60);
		btn2.addActionListener(this);
		btn2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		new Join();
	}

	});

	panel.add(btn1);panel.add(btn2);panel.add(Id);panel.add(tf);panel.add(pw);panel.add(tf2);

	setVisible(true);

	Id.setBounds(385,300,250,200);tf.setBounds(510,380,160,35);pw.setBounds(385,350,250,200);tf2.setBounds(510,435,160,35);

	add(panel);}

	public static void main(String[] args) {
		new Main2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}