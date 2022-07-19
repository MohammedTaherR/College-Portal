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
import java.awt.Font;

public class mark_uploaded {

	private JFrame frame;
	private JTextField mathstxt;
	private JTextField daatxt;
	private JTextField dbmstxt;
	private JTextField ostxt;
	private JTextField setxt;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mark_uploaded window = new mark_uploaded();
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
	public mark_uploaded() {
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
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(10, 11, 108, 23);
		frame.getContentPane().add(back_btn);
		
		JLabel lblNewLabel = new JLabel("Maths");
		lblNewLabel.setBounds(29, 98, 67, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DAA");
		lblNewLabel_1.setBounds(29, 132, 67, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DBMS");
		lblNewLabel_2.setBounds(29, 166, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("OS");
		lblNewLabel_3.setBounds(29, 191, 49, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SE");
		lblNewLabel_4.setBounds(29, 216, 49, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		mathstxt = new JTextField();
		mathstxt.setBounds(106, 107, 96, 20);
		frame.getContentPane().add(mathstxt);
		mathstxt.setColumns(10);
		
		daatxt = new JTextField();
		daatxt.setBounds(106, 132, 96, 20);
		frame.getContentPane().add(daatxt);
		daatxt.setColumns(10);
		
		dbmstxt = new JTextField();
		dbmstxt.setBounds(106, 163, 96, 20);
		frame.getContentPane().add(dbmstxt);
		dbmstxt.setColumns(10);
		
		ostxt = new JTextField();
		ostxt.setBounds(106, 188, 96, 20);
		frame.getContentPane().add(ostxt);
		ostxt.setColumns(10);
		
		setxt = new JTextField();
		setxt.setBounds(106, 213, 96, 20);
		frame.getContentPane().add(setxt);
		setxt.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(273, 229, 108, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(29, 64, 49, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 61, 96, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_details sp = new student_details();
				sp.main(null);
				frame.dispose();
				
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			String id= textField_5.getText();
			int maths=Integer.parseInt(mathstxt.getText());
			int daa=Integer.parseInt(daatxt.getText());
			int os=Integer.parseInt(ostxt.getText());
			int se=Integer.parseInt(setxt.getText());
	
			int dbms=Integer.parseInt(dbmstxt.getText());
			
				if(maths>50 && os>50 && daa>50 &&se>50 && dbms>50 ) {
					try {
						String pass = "pass";
						String sql = "update student_table set marks='"+pass+"' where id='"+id+"'";
						
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
					
				}else {
					try {
					String fail = "fail";
					String sql = "update student_table set marks='"+fail+"'where id='"+id+"'";
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
				
				
				
				
//				
//				
//				
				
				
			}
			
		});
	}

}
