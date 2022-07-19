package studCrud;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class result_check {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					result_check window = new result_check();
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
	public result_check() {
		initialize();
		connect();
		
	}
	Connection con;
	PreparedStatement pat,pat1;
	ResultSet rs;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	
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
		
		JLabel ID = new JLabel("ID");
		ID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ID.setBounds(88, 70, 49, 14);
		frame.getContentPane().add(ID);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(147, 67, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBounds(297, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(51, 131, 309, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String id =textField.getText();
					//create state to execute query
		Statement st=con.createStatement();
		String sql= "select * from student_table where id='"+id+"'";
		//Result set to get records from Database
		ResultSet rs = st.executeQuery(sql);
		String sum="";
		if(rs.next()){ 
			do{
				sum=rs.getString(7);
				textField_1.setText("Your Result - "+sum);

			}while(rs.next());
		}
		else{
			System.out.println("Record Not Found...");
		}
			
		} catch (SQLException e2) {
			
					e2.printStackTrace();
			}
			}
					
				
			
			
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_details sd = new student_details();
				sd.main(null);
				frame.dispose();
				
			}
			
		});
	}

}
