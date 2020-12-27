import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationUser extends JFrame implements ActionListener {
	private JTextField tf;
	private JPasswordField tf_1;
	JButton btn;

	public RegistrationUser() {
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(1519, 726);

		JLabel L = new JLabel("Registration For File Security System");
		L.setFont(new Font("Tahoma", Font.BOLD, 22));
		L.setForeground(new Color(0, 128, 0));
		L.setBounds(550, 58, 424, 28);
		getContentPane().add(L);

		JLabel L1 = new JLabel("Email-Id :");
		L1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		L1.setForeground(new Color(0, 0, 0));
		L1.setBounds(621, 215, 76, 19);
		getContentPane().add(L1);

		tf = new JTextField();
		tf.setBounds(756, 213, 162, 28);
		getContentPane().add(tf);
		tf.setColumns(10);

		JLabel L2 = new JLabel("Password :");
		L2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		L2.setBounds(621, 270, 76, 19);
		getContentPane().add(L2);

		tf_1 = new JPasswordField();
		tf_1.setBounds(756, 268, 162, 28);
		getContentPane().add(tf_1);
		tf_1.setColumns(10);

		btn = new JButton("Submit");
		btn.setBackground(new Color(30, 144, 255));
		btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn.setBounds(674, 412, 135, 28);
		getContentPane().add(btn);
		btn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String email = tf.getText();
		char[] s = tf_1.getPassword();
		String password = new String(s);

		if (!email.isEmpty() && !password.isEmpty()) {
			int x = 0;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cse", "SYS AS SYSDBA",
						"Void_Null89");
				Statement smt = con.createStatement();
				PreparedStatement psmt = con.prepareStatement("insert into file_security values(?,?)");
				psmt.setString(1, email);
				psmt.setString(2, password);
				ResultSet rs = psmt.executeQuery();
				x++;
				if (x > 0) {
					JOptionPane.showMessageDialog(btn, "welcome new user");
					PerformingAction action = new PerformingAction(email);
					// FirstPage firstpage = new FirstPage();
				}

			} catch (SQLException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(btn, "fill the above info..");

		}

	}
}
