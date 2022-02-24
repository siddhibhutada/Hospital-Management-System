package admin;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Scrollbar;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import admin.ConnectionProvider;
import java.sql.*
;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;public class FullHistoryOfPatient {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullHistoryOfPatient window = new FullHistoryOfPatient();
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
	public FullHistoryOfPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 782, 516);
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBounds(389, 394, 98, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new home1().setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Patient ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(91, 44, 178, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textField_2 = new JTextArea();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(269, 205, 210, 40);
		frame.getContentPane().add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(269, 128, 216, 40);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(269, 289, 216, 40);
		frame.getContentPane().add(textField_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(269, 44, 216, 40);
		frame.getContentPane().add(textField);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int patientID = Integer.parseInt(textField.getText());
				try
				{
					Connection con = ConnectionProvider.getCon();
					Connection con1 = ConnectionProvider.getCon();
					Connection con2 = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					Statement st1=con1.createStatement();
					Statement st2=con2.createStatement();
					ResultSet rs = st.executeQuery("select * from patient where PID="+patientID);
					ResultSet rs1 = st1.executeQuery("select * from diagnosis where fkpid1="+patientID);
					ResultSet rs2 = st2.executeQuery("select * from medicine where fpid="+patientID);
					if(rs.next() && rs1.next() && rs2.next())
					{
						textField_1.setText(rs.getString(2));	
						textField_2.setText(rs1.getString(2));
						textField_3.setText(rs2.getString(2));
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
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(564, 42, 120, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientName.setBounds(91, 128, 178, 31);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiagnosis.setBounds(91, 205, 178, 31);
		frame.getContentPane().add(lblDiagnosis);
		
		JLabel lblPatientMedicine = new JLabel("Medicines");
		lblPatientMedicine.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPatientMedicine.setBounds(91, 289, 178, 31);
		frame.getContentPane().add(lblPatientMedicine);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image updp = new ImageIcon(home1.class.getResource("history.jfif")).getImage().getScaledInstance(180, 180,
				Image.SCALE_SMOOTH);;
		lblNewLabel_1.setIcon(new ImageIcon(updp));
		lblNewLabel_1.setBounds(539, 109, 186, 220);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
}

