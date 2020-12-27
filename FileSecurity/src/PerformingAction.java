import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerformingAction extends JFrame implements ActionListener {

	JButton btnNewButton, btnNewButton_1;
	String Email;

	public PerformingAction(String email) {

		getContentPane().setBackground(Color.PINK);
		getContentPane().setLayout(null);
		setVisible(true);
		setSize(700, 723);

		JLabel lblNewLabel = new JLabel("Action to be performed");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(590, 202, 348, 35);
		getContentPane().add(lblNewLabel);

		btnNewButton = new JButton("Encryption");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setBounds(506, 368, 183, 35);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(this);

		btnNewButton_1 = new JButton("Decryption");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBackground(new Color(255, 140, 0));
		btnNewButton_1.setBounds(743, 368, 173, 35);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		Email = email;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewButton) {
			MainActivity encryption = new MainActivity(Email);

		} else {
			DecreptionOfFile drcryption = new DecreptionOfFile();

		}
	}

}
