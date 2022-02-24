package admin;

import java.awt.EventQueue;

import java.awt.BorderLayout; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import admin.ConnectionProvider;
import java.sql.*;
import javax.swing.JTextArea;

public class AddPatient extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient window = new AddPatient();
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
	public AddPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		//frame.getContentPane().setForeground(new Color(102, 255, 255));
		frame.setBounds(100, 100, 906, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home1().setVisible(true);
			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(565, 499, 155, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("    Patient ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(219, 27, 228, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("    Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(219, 94, 228, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("    Gender");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(219, 161, 228, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("    Age");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(219, 228, 228, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("    Blood Group");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(219, 362, 228, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("    Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(219, 295, 228, 40);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("    Mobile No");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(219, 429, 228, 40);
		frame.getContentPane().add(lblNewLabel_6);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea.setBounds(473, 34, 398, 31);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_1.setBounds(473, 99, 398, 32);
		frame.getContentPane().add(textArea_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F", "O"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(473, 165, 398, 31);
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_2.setBounds(473, 230, 398, 30);
		frame.getContentPane().add(textArea_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBox_1.setBounds(473, 358, 398, 29);
		frame.getContentPane().add(comboBox_1);
		
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_3.setBounds(473, 294, 398, 30);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_4.setBounds(473, 421, 389, 30);
		frame.getContentPane().add(textArea_4);
		
		JButton btnNewButton = new JButton("   Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int patientID = Integer.parseInt(textArea.getText());
					String name = textArea_1.getText();
					String gender1= (String) comboBox.getSelectedItem();
					char gender= gender1.charAt(0);
					int age = Integer.parseInt(textArea_2.getText());
					String blood_grp = (String) comboBox_1.getSelectedItem();
					//String blood_grp= ""+blood_grp1.charAt(0)+blood_grp1.charAt(1)+blood_grp1.charAt(2);
					String address = textArea_3.getText();
					String mobile_no = textArea_4.getText();
					
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into patient values("+patientID+",'"+name+"','"+gender+"',"+age+",'"+blood_grp+"','"+address+"','"+mobile_no+"')");
					JOptionPane.showMessageDialog(null," Record Successfully added");
					setVisible(false);
					new AddPatient().setVisible(true);
					st.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter data in correct format");
					//e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(300, 500, 155, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image addp = new ImageIcon(home1.class.getResource("add.png")).getImage().getScaledInstance(200, 200,
				Image.SCALE_SMOOTH);;
		lblNewLabel_7.setIcon(new ImageIcon(addp));
		lblNewLabel_7.setBounds(22, 77, 210, 325);
		frame.getContentPane().add(lblNewLabel_7);
		
		
//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
	}
}

