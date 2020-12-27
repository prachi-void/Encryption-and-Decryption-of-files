import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BrowseFile extends JFrame {
	StringBuilder sb = new StringBuilder();
	JFileChooser file_chooser = new JFileChooser();

	public String BrowseFile() throws FileNotFoundException {
		getContentPane().setLayout(null);

		if (file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = file_chooser.getSelectedFile();
			Scanner input = new Scanner(file);

			while (input.hasNext()) {
				sb.append(input.nextLine());
				sb.append("\n");
			}
			input.close();
			return file.getAbsolutePath();
		} else {
			sb.append("no file has choosen");
		}
		return null;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws FileNotFoundException {
		// new BrowseFile();
	}
}
