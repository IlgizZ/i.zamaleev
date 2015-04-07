import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Window extends JFrame implements ActionListener {

	public Window() {
		initComponents();
	}

	private JFrame viewForm;

	JFileChooser filechooser = new JFileChooser();
	String filename;
	String filename1;

	private void initComponents() {
		viewForm = new JFrame("Arhivator from ITIS");
		viewForm.setSize(500, 150);
		viewForm.setVisible(true);
		viewForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField jTextField = new JTextField();

		JButton button = new JButton();
		button.setVisible(true);
		button.setLocation(12, 12);
		button.setSize(165, 50);
		button.setText("Архивировать");
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				jButtonMouseClicked(evt);
			}

			private void jButtonMouseClicked(MouseEvent evt) {
				filechooser.showOpenDialog(null);
				File f = filechooser.getSelectedFile();
				filename = f.getAbsolutePath();
				jTextField.setText(filename);
			}

		});

		JButton button1 = new JButton();
		button1.setVisible(true);
		button1.setLocation(300, 12);
		button1.setSize(165, 50);
		button1.setText("Разархивировать");
		button1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				try {
					jButton1MouseClicked(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Ilgiz must do this magic method;
			}
		});

		viewForm.getContentPane().add(button);
		viewForm.getContentPane().add(button1);
		viewForm.getContentPane().add(new JLabel());

	}

	public void actionPerformed(ActionEvent action) {
	}
	
	private void jButton1MouseClicked(MouseEvent evt) throws IOException {
        JOptionPane.showMessageDialog(rootPane, "The Decoded String is "+"pq.decode()");
        
    }

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window();
			}
		});
	}
}