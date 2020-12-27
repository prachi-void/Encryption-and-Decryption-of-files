
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FirstPage extends JFrame implements ActionListener {

	JLabel l1, l2, l3, L1, l4;
	JTextField tf1;
	JButton btn1, btn2;
	JPasswordField p1;
	String s1;

	FirstPage() {
		getContentPane().setLayout(null);
		/*
		 * FOR BACKGROUND-IMAGE: getContentPane().setLayout(new BorderLayout());//
		 * JLabel label = new JLabel(new
		 * 
		 * ImageIcon("C:\\Users\\Prachi\\Desktop\\yet_to_come\\flag.jpg"));
		 * label.setFocusCycleRoot(true); setContentPane(label);
		 * 
		 * FlowLayout flowLayout = new FlowLayout();
		 * 
		 * getContentPane().setLayout(flowLayout); L1 = new JLabel();
		 */
		setVisible(true);
		setSize(1293, 800);
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setTitle("Simple form using java");

		l1 = new JLabel("File Security System");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		l2 = new JLabel("username");
		l3 = new JLabel("password");

		tf1 = new JTextField();
		p1 = new JPasswordField();

		btn1 = new JButton("Login");
		btn1.setBackground(new Color(154, 205, 50));

		btn1.addActionListener(this);

		btn2 = new JButton("Sign up");
		btn2.setBackground(Color.CYAN);
		btn2.setBounds(729, 499, 110, 21);
		getContentPane().add(btn2);
		btn2.addActionListener(this);

		JLabel lblNewLabel = new JLabel("new user!!sign up here");
		lblNewLabel.setBounds(520, 501, 199, 17);
		getContentPane().add(lblNewLabel);

		l1.setBounds(521, 152, 400, 30);
		l2.setBounds(445, 239, 200, 30);
		l3.setBounds(445, 296, 200, 40);
		tf1.setBounds(675, 240, 200, 30);
		p1.setBounds(675, 302, 200, 30);
		btn1.setBounds(514, 388, 200, 30);

		getContentPane().add(l1);
		getContentPane().add(l2);
		getContentPane().add(tf1);
		getContentPane().add(l3);
		getContentPane().add(p1);
		getContentPane().add(btn1);

	}

	private void SetSize(int i, int j) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {
			int x = 0;
			s1 = tf1.getText();

			char[] s2 = p1.getPassword();
			String s3 = new String(s2);

			if (!s3.isEmpty() && s1 != null) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cse",
							"SYS AS SYSDBA", "yourpassword");
					Statement smt = con.createStatement();

					ResultSet rs = smt.executeQuery(
							"Select * from file_security where username='" + s1 + "' and pswd='" + s3 + "'");
					// x++;
					if (rs.next()) {
						JOptionPane.showMessageDialog(btn1, "verified!!");

						PerformingAction action = new PerformingAction(s1);

					} else {
						JOptionPane.showMessageDialog(btn1, "fill correct information!!");
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}
			} else {
				JOptionPane.showMessageDialog(btn1, "something went wrong!!");
			}
		} else {

			tf1.setText("");
			p1.setText("");

		}
		if (e.getSource() == btn2) {

			RegistrationUser user = new RegistrationUser();

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new FirstPage();

	}
}
