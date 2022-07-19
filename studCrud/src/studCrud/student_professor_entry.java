package studCrud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class student_professor_entry {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_professor_entry window = new student_professor_entry();
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
	public student_professor_entry() {
		initialize();
		connect();
	}
	Connection con;
	PreparedStatement pat,pat1;
	ResultSet rs;
	
// To create Connection between Mysql DB and Java
	
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
		
		JLabel lblNewLabel = new JLabel("XYZ College of Engineering");
		lblNewLabel.setFont(new Font("VALORANT", Font.PLAIN, 16));
		lblNewLabel.setBounds(86, 58, 350, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JButton prof_btn = new JButton("Professor");
		prof_btn.setBounds(66, 151, 116, 23);
		frame.getContentPane().add(prof_btn);
		
		JButton stud_btn = new JButton("Student");
		stud_btn.setBounds(235, 151, 116, 23);
		frame.getContentPane().add(stud_btn);
		
		prof_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				professor_info pf= new professor_info();
				pf.main(null);
				frame.dispose();
				
			}
			
		});
		stud_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				student_info st = new student_info();
				st.main(null);
				frame.dispose();
				
			}
			
		});
		
	}
	
}
