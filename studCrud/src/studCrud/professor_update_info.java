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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class professor_update_info {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professor_update_info window = new professor_update_info();
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
	public professor_update_info() {
		initialize();
		connect();
	}
	Connection con;
	PreparedStatement pat,pat1;
	ResultSet rs;
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
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(back_btn);
		
		JLabel lblNewLabel = new JLabel("Phone Number");
		lblNewLabel.setBounds(69, 103, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 100, 96, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(69, 134, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 131, 96, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setBounds(183, 181, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(69, 78, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setBounds(183, 69, 96, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
	
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				professor_info sp = new professor_info();
				sp.main(null);
				frame.dispose();
				
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String phone = textField_1.getText();
				String address = textField_2.getText();
				String id = textField_3.getText();
				
				
try {

	String sql = "update professor_table set address='"+address+"',phone='"+phone+"' where id='"+id+"'";
	//System.out.println(id);
	Statement pst = con.prepareStatement(sql);
	pst.execute(sql);
	JOptionPane.showMessageDialog(null, "Updated");
	successfull_add cd = new successfull_add();
	cd.main(null);
	frame.dispose();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}		
				
		
				
			}
			
		});
		
		
	}
}
