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
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;

public class student_info {

	private JFrame frmStudentInfo;
	private JTextField idtf;
String name;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_info window = new student_info();
					window.frmStudentInfo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student_info() {
		initialize();
		connect();
	}
	
	Connection con;
	PreparedStatement pat,pat1;
	ResultSet rs;
	private JTable table;
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
	public void initialize() {
		frmStudentInfo = new JFrame();
		frmStudentInfo.setTitle("student info");
		frmStudentInfo.setBounds(100, 100, 450, 300);
		frmStudentInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInfo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(110, 98, 35, 23);
		frmStudentInfo.getContentPane().add(lblNewLabel);
		
		idtf = new JTextField();
		idtf.setBounds(155, 101, 126, 20);
		frmStudentInfo.getContentPane().add(idtf);
		idtf.setColumns(10);
		
		JButton submittf = new JButton("submit");
		submittf.setBounds(192, 151, 89, 23);
		frmStudentInfo.getContentPane().add(submittf);
		
		table = new JTable();
		table.setBounds(306, 228, 120, -107);
		frmStudentInfo.getContentPane().add(table);
		
		btnNewButton_1 = new JButton("back");
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frmStudentInfo.getContentPane().add(btnNewButton_1);
		

		
		
		submittf.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			
								try {
									String id=idtf.getText();	
									Statement stmt = con.createStatement();
									String sql= "select * from student_table where id='"+id+"'";
									ResultSet rs = stmt.executeQuery(sql);
									if(rs.next()) {
										student_details at = new student_details();
										at.main(null);	
									
										frmStudentInfo.dispose();
										
										
									}else {
										JOptionPane.showMessageDialog(null, "ID is invalid");
										idtf.setText(" ");
									}
								
		
//					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		
				
						
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_professor_entry sd = new student_professor_entry();
				sd.main(null);
				frmStudentInfo.dispose();
				
			}
			
		});
	}	

}
