package studCrud;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class student_update_info {

	private JFrame frame;
	private JTextField dobtxt;
	private JTextField agetxt;
	private JTextField phonetxt;
	private JTextField addresstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_update_info window = new student_update_info();
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
	public student_update_info() {
		initialize();
		connect();
	}
	Connection con;
	PreparedStatement pat,pat1;
	ResultSet rs;
	public String id;
	private JTextField textField;
	private JTextField Nametxt;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/Your_Database_Name","Your_Database_Root","Enter_Your_Database_Password");
			
		}catch(ClassNotFoundException ex) {

		}catch(SQLException ex) {

		}
	}


	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(36, 65, 49, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Of Birth");
		lblNewLabel_1.setBounds(36, 102, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		dobtxt = new JTextField();
		dobtxt.setBounds(145, 99, 96, 20);
		frame.getContentPane().add(dobtxt);
		dobtxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(36, 140, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		agetxt = new JTextField();
		agetxt.setBounds(145, 137, 96, 20);
		frame.getContentPane().add(agetxt);
		agetxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setBounds(36, 179, 99, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(145, 176, 96, 20);
		frame.getContentPane().add(phonetxt);
		phonetxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(36, 214, 49, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		addresstxt = new JTextField();
		addresstxt.setBounds(145, 211, 96, 20);
		frame.getContentPane().add(addresstxt);
		addresstxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(287, 210, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(36, 40, 49, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(145, 37, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(145, 62, 96, 20);
		frame.getContentPane().add(Nametxt);
		Nametxt.setColumns(10);
		
	
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_details sd =  new student_details();
				sd.main(null);
				frame.dispose();
			}
			
		});
		btnNewButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			
				String id =  textField.getText();
				String name = Nametxt.getText();
				String dob = dobtxt.getText();
				String age = agetxt.getText();
				String phone = phonetxt.getText();
				String address = addresstxt.getText();
				
try {

	String sql = "update student_table set name='"+name+"' ,dob = '"+dob+"',age='"+age+"' ,phone='"+phone+"',address='"+address+"' where id='"+id+"'";
	//System.out.println(id);
	Statement pst = con.prepareStatement(sql);
	pst.execute(sql);
	JOptionPane.showMessageDialog(null, "Updated");
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}				
		
			}
			
		});
	}
}
