import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

//import form.SecondPage;
import oracle.net.aso.e;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends JFrame implements ActionListener {
	JButton btn, btn1, btn2;

	JTextArea textField;

	String object, Email;

	// TODO Auto-generated method stub
	public MainActivity(String email) {
		Email = email;
		setVisible(true);
		setSize(1261, 656);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Welcome to File Security System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		// lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(526, 118, 471, 50);
		getContentPane().add(lblNewLabel);

		JLabel L1 = new JLabel("File to upload");
		L1.setBackground(new Color(0, 0, 0));
		L1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		L1.setBounds(482, 317, 125, 46);
		getContentPane().add(L1);

		this.btn = new JButton("Encrypt");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btn.setBackground(Color.GREEN);
		this.btn.setBounds(628, 497, 234, 38);
		this.getContentPane().add(btn);
		this.btn.addActionListener(this);

		btn1 = new JButton("Browse");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn1.setBackground(new Color(0, 191, 255));
		btn1.setBounds(929, 329, 112, 29);
		getContentPane().add(btn1);
		btn1.addActionListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(617, 265, 258, 154);
		getContentPane().add(scrollPane);

		textField = new JTextArea();
		scrollPane.setViewportView(textField);
		JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	}

	/*
	* 
	*/
	private void JScrollPane(JTextArea textField2, int verticalScrollbarAlways, int horizontalScrollbarAlways) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			String s = textField.getText();
			if (s != "no file is choosen" || object != null) {// s!=null
				JOptionPane.showMessageDialog(btn, "encrypting");

				try {
					int x = 0;
					EncrptionDemo encrypt = new EncrptionDemo();
					encrypt.encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, object,
							"C:\\Users\\username\\Desktop\\encrptText.txt");

					copy CopyFile = new copy();
					CopyFile.copy(object);

					SendEmail email = new SendEmail();
					String key = email.sendMail(Email);

					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:cse",
							"SYS AS SYSDBA", "yourpassword");

					Statement smt = con.createStatement();

					PreparedStatement ps = con.prepareStatement("insert into FileName values(?,?)");
					ps.setString(1, key);
					ps.setString(2, object);
					ResultSet rs = ps.executeQuery();
					x++;
					if (x > 0)
						JOptionPane.showMessageDialog(btn, "secret key is sent to your email");

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		} else {
			JOptionPane.showMessageDialog(btn1, "opening!!please wait..");

			try {
				BrowseFile obj = new BrowseFile();
				object = obj.BrowseFile();
				textField.setText(obj.sb.toString());
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}

	}
}
