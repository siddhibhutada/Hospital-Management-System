package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Diagnosis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diagnosis frame = new Diagnosis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Diagnosis() {
		setBounds(100, 100, 906, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIAGNOSE RESULT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(340, 22, 355, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(266, 66, 204, 46);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Symptoms");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(266, 195, 135, 36);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fever");
		rdbtnNewRadioButton.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(531, 201, 103, 31);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Weakness");
		rdbtnNewRadioButton_1.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(531, 298, 103, 34);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Headache");
		rdbtnNewRadioButton_2.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_2.setBounds(668, 201, 103, 31);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("BodyAche");
		rdbtnNewRadioButton_3.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_3.setBounds(668, 247, 103, 36);
		contentPane.add(rdbtnNewRadioButton_3);
		
		textField = new JTextField();
//		int patientID = Integer.parseInt(textField.getText());
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(531, 79, 254, 36);
		
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Cold");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1_1.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1_1.setBounds(531, 247, 103, 36);
		contentPane.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_2 = new JRadioButton("Vomiting");
		rdbtnNewRadioButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1_2.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1_2.setBounds(668, 298, 103, 34);
		contentPane.add(rdbtnNewRadioButton_1_2);
		
		JRadioButton rdbtnNewRadioButton_1_3 = new JRadioButton("Nausea");
		rdbtnNewRadioButton_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1_3.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1_3.setBounds(531, 348, 103, 31);
		contentPane.add(rdbtnNewRadioButton_1_3);
		
		JRadioButton rdbtnNewRadioButton_1_3_1 = new JRadioButton("Cough");
		rdbtnNewRadioButton_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_1_3_1.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton_1_3_1.setBounds(668, 348, 103, 31);
		contentPane.add(rdbtnNewRadioButton_1_3_1);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String fever = " ";
				if(rdbtnNewRadioButton.isSelected()) {
					fever = "Fever";
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+fever+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Weakness = "Weakness";
				if(rdbtnNewRadioButton_1.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+Weakness+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String HeadAche = "HeadAche";
				if(rdbtnNewRadioButton_2.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+HeadAche+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Body = "BodyAche";
				if(rdbtnNewRadioButton_3.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+Body+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Cold = "Cold";
				if(rdbtnNewRadioButton_1_1.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+Cold+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Vomiting = "Vomiting";
				if(rdbtnNewRadioButton_1_2.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+Vomiting+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String nausea = "Nausea";
				if(rdbtnNewRadioButton_1_3.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+nausea+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		rdbtnNewRadioButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Cough = "Cough";
				if(rdbtnNewRadioButton_1_3_1.isSelected()) {
					try
					{
						int patientID = Integer.parseInt(textField.getText());
						
						Connection con = ConnectionProvider.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into symptoms values("+patientID+",'"+Cough+"')");
//						st.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, "Please enter data in correct format");
						//e1.printStackTrace();
					}
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(266, 132, 135, 31);
		contentPane.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea.setBounds(531, 137, 254, 36);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_4 = new JLabel("Diagonsis");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(266, 405, 151, 42);
		contentPane.add(lblNewLabel_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		textArea_1.setBounds(531, 405, 240, 53);
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					int patientID = Integer.parseInt(textField.getText());
					String diagnose = textArea_1.getText();
					
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into diagnosis values("+patientID+",'"+diagnose+"')");
					JOptionPane.showMessageDialog(null," Record Successfully added");
					setVisible(false);
					new Diagnosis().setVisible(true);
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Please enter data in correct format");
					//e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(387, 490, 103, 38);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				textField.setText(null);
				textArea_1.setText(null);
				rdbtnNewRadioButton_1_1.setSelected(false);
				rdbtnNewRadioButton_1_2.setSelected(false);
				rdbtnNewRadioButton_1_3.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1_3_1.setSelected(false);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(531, 490, 103, 38);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image dig = new ImageIcon(home1.class.getResource("diagnosis.jfif")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(dig));
		lblNewLabel_5.setBounds(23, 115, 204, 300);
		contentPane.add(lblNewLabel_5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home1().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(668, 490, 103, 38);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int patientID = Integer.parseInt(textField.getText());
				try {
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from patient where PID='" + patientID + "'");
					if (rs.next()) {
						textArea.setText(rs.getString(2));

					} else {
						JOptionPane.showMessageDialog(null, "Patient ID does not exist");

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(406, 82, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}

