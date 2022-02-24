package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;

public class bill extends JFrame {

	private JPanel contentPane;
	private Image billimg = new ImageIcon(home1.class.getResource("bill.png")).getImage().getScaledInstance(180, 200,
			Image.SCALE_SMOOTH);
	private Image bil = new ImageIcon(home1.class.getResource("bill1.png")).getImage().getScaledInstance(250, 180,
			Image.SCALE_SMOOTH);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
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
	public bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 906, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new home1().setVisible(true);
			}
		});
		btnNewButton.setBounds(509, 516, 140, 43);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Bill Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(309, 145, 106, 19);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Patient Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(301, 213, 114, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Date (YYYYMMDD)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(259, 372, 195, 26);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(311, 438, 76, 34);
		contentPane.add(lblNewLabel_3);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea.setBounds(481, 205, 168, 36);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea_1.setBounds(481, 364, 168, 34);
		contentPane.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea_2.setBounds(481, 434, 168, 36);
		contentPane.add(textArea_2);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea_3.setBounds(481, 133, 168, 34);
		contentPane.add(textArea_3);

		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(334, 516, 134, 43);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int bid = Integer.parseInt(textArea_3.getText());
					int pid = Integer.parseInt(textArea.getText());
					int date =Integer.parseInt(textArea_1.getText());
					float amt = Float.parseFloat(textArea_2.getText());
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into bill values("+bid+","+pid+","+date+","+amt+")");
					JOptionPane.showMessageDialog(null, "Sucessfully Saved!");
					setVisible(false);
					new bill().setVisible(true);
				} catch (Exception et) {
					JOptionPane.showMessageDialog(null, "Error! Enter Correct Data");
					setVisible(false);
					new bill().setVisible(true);
				}
			}
		});

		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(630, 264, 242, 211);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(billimg));

		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(10, 30, 251, 197);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(bil));

		JLabel lblNewLabel_6 = new JLabel("BILL DETAILS");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(310, 47, 319, 34);
		contentPane.add(lblNewLabel_6);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea_4.setBounds(481, 284, 168, 36);
		contentPane.add(textArea_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(275, 292, 140, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int patientID = Integer.parseInt(textArea.getText());
				try
				{
					Connection con = ConnectionProvider.getCon();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from patient where PID="+patientID);
					if(rs.next())
					{
						textArea_4.setText(rs.getString(2));	
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(685, 205, 114, 35);
		contentPane.add(btnNewButton_2);
	}
}
