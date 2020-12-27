import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class DecreptionOfFile extends JFrame implements ActionListener {
	JTextField textField;
	JButton btn1;

	public DecreptionOfFile() {

		setSize(700, 700);
		setVisible(true);
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter your key :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(523, 249, 108, 31);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(641, 252, 160, 25);
		getContentPane().add(textField);
		textField.setColumns(10);

		btn1 = new JButton("Decrypt");
		btn1.setBackground(Color.CYAN);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btn1.setBounds(589, 383, 187, 31);
		getContentPane().add(btn1);
		btn1.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Decreption of File");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(574, 114, 209, 31);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Forgot your key???..Press this button");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(437, 486, 270, 25);
		getContentPane().add(lblNewLabel_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String key = textField.getText();
		if (e.getSource() == btn1) {
			if (key != null) {
				try {
					int x = 0;
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cse",
							"SYS AS SYSDBA", "yourpassword");

					Statement smt = con.createStatement();
					ResultSet res = smt.executeQuery("select filenmae from FileName where key='" + key + "'");
					x++;
					if (res.next()) {

						String em = res.getString(1);

						EncrptionDemo encrypt = new EncrptionDemo();
						encrypt.encryptDecrypt("12345678", Cipher.DECRYPT_MODE, em,
								"C:\\Users\\username\\Desktop\\encrptText.txt");
						JOptionPane.showMessageDialog(btn1, "decreption mode on");
						copy CopyFile = new copy();
						CopyFile.copy(em);
						// System.out.print(em);
						int result = smt.executeUpdate(
								"delete from FileName where key='" + key + "' and filenmae='" + em + "' ");
						if (result > 0)
							JOptionPane.showMessageDialog(btn1, "Decrepted File successfully");

						con.close();

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		}

	}
}
