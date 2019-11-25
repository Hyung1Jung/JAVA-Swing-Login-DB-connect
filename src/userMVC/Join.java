package userMVC;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Success;

class Join extends JFrame implements ActionListener {
		JButton btn1 = new JButton("가입");
		
		public Join() {
			
			JPanel panel = new JPanel();
			
			setBounds(1240, 260, 300, 690);
			JLabel id = new JLabel("ID 입력 : ");
			JTextField idTf = new JTextField(12);
			JLabel pw = new JLabel("비밀번호 입력 : ");
			JTextField pwTf = new JTextField(12);
			JLabel name = new JLabel("이름 입력 : ");
			JTextField nameTf = new JTextField(12);
			JLabel sex = new JLabel("성별 입력 : ");
			JTextField sexTf = new JTextField(12);
			JLabel ph = new JLabel("폰번호 입력 : ");
			JTextField phTf = new JTextField(12);
			JLabel jumin = new JLabel("주민번호 입력 : ");
			JTextField juminTf = new JTextField(12);

			panel.setLayout(null);
			

			panel.add(id);
			panel.add(idTf);
			panel.add(pw);
			panel.add(pwTf);
			panel.add(name);
			panel.add(nameTf);
			panel.add(sex);
			panel.add(sexTf);
			panel.add(ph);
			panel.add(phTf);
			panel.add(jumin);
			panel.add(juminTf);
			panel.add(btn1);
			btn1.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent arg0) {
	                new Success();
	            }
			});
			

			setVisible(true);
			
			id.setBounds(20, 20, 100, 100);
			idTf.setBounds(73, 55, 120, 20);
			
			pw.setBounds(20, 60, 100, 100);
			pwTf.setBounds(115, 100, 120, 20);
			
			name.setBounds(20, 100, 100, 100);
			nameTf.setBounds(90, 140, 120, 20);
			
			sex.setBounds(20, 140, 100, 100);
			sexTf.setBounds(90, 180, 120, 20);
			
			ph.setBounds(20, 180, 100, 100);
			phTf.setBounds(110, 220, 120, 20);
			
			jumin.setBounds(20, 220, 100, 100);
			juminTf.setBounds(120, 260, 120, 20);
			
			btn1.setBounds(80, 400, 100, 50);
			btn1.addActionListener(this);
			
			add(panel);
	
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}