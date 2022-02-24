package admin;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Medicine extends JFrame {

//	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicine frame = new Medicine();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Medicine() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
		getContentPane().setForeground(new Color(0, 51, 102));
		getContentPane().setBackground(new Color(176, 224, 230));
		setBounds(100, 100, 818, 591);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PatientID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(52, 97, 95, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Medicine_Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(41, 243, 141, 32);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(212, 244, 167, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(212, 99, 167, 33);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  Quantity");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(52, 323, 130, 32);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("   Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(54, 400, 72, 32);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(new Color(0, 51, 255));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home1().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(663, 475, 111, 45);
		getContentPane().add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(212, 323, 167, 33);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setBounds(212, 400, 167, 33);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image med = new ImageIcon(home1.class.getResource("med1.jpg")).getImage().getScaledInstance(250, 180,
				Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(med));
		lblNewLabel_4.setBounds(520, 232, 274, 212);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image med1 = new ImageIcon(home1.class.getResource("med2.jpg")).getImage().getScaledInstance(250, 180,
				Image.SCALE_SMOOTH);
		lblNewLabel_5.setIcon(new ImageIcon(med1));
		lblNewLabel_5.setBounds(520, 10, 274, 212);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.setBackground(new Color(0, 51, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int patientID = Integer.parseInt(textField_1.getText());
					String medicine = textField.getText();
					int quantity = Integer.parseInt(textField_2.getText());
					int price = Integer.parseInt(textField_3.getText());
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into medicine values("+patientID+",'"+medicine+"',"+quantity+","+price+")");
					JOptionPane.showMessageDialog(null," Record Successfully added");
					setVisible(false);
					new Medicine().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter data in correct format");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(495, 475, 111, 45);
		getContentPane().add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(212, 170, 167, 33);
		getContentPane().add(textField_4);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPatientName.setBounds(24, 171, 123, 32);
		getContentPane().add(lblPatientName);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int patientID = Integer.parseInt(textField_1.getText());
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from patient where PID="+patientID);
					if(rs.next())
					{
						textField_4.setText(rs.getString(2));	
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Patient ID does not exist");				
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(408, 103, 85, 26);
		getContentPane().add(btnNewButton_2);
	}
}
