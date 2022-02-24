package admin;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {

	private JFrame frame;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 51, 102));
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 906, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblusername = new JLabel("USER ID");
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblusername.setBounds(206, 113, 86, 29);
		frame.getContentPane().add(lblusername);

		JLabel lblpassword = new JLabel("PASSWORD");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpassword.setBounds(206, 200, 136, 33);
		frame.getContentPane().add(lblpassword);

		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtusername.setBounds(326, 109, 260, 44);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);

		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpassword.setBounds(326, 198, 260, 44);
		frame.getContentPane().add(txtpassword);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = txtpassword.getText();
				String username = txtusername.getText();
				if (password.contains("admin@123") && username.contains("dbms_admin")) {
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.setVisible(false);
							new home1().setVisible(true);
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "Invalid login", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtpassword.setText(null);
					txtusername.setText(null);
				}
			}
		});
		btnNewButton.setBounds(61, 304, 117, 44);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtusername.setText(null);
				txtpassword.setText(null);
			}
		});
		btnNewButton_1.setBounds(258, 304, 117, 44);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login Systems",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setBounds(444, 304, 126, 44);
		frame.getContentPane().add(btnNewButton_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(34, 272, 557, 9);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(34, 69, 562, 13);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image login = new ImageIcon(home1.class.getResource("hms.jfif")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(login));
		lblNewLabel_1.setBounds(21, 69, 175, 212);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("LOGIN DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(234, 30, 229, 29);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(200, 200, 653, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
