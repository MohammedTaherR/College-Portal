package studCrud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class professor_info {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professor_info window = new professor_info();
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
	public professor_info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Professor");
		lblNewLabel.setFont(new Font("VALORANT", Font.PLAIN, 15));
		lblNewLabel.setBounds(136, 11, 192, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton marks_btn = new JButton("Enter Marks");
		marks_btn.setBounds(138, 84, 166, 26);
		frame.getContentPane().add(marks_btn);
		
		JButton saup_btn = new JButton("Salary Update");
		saup_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salary_update su = new salary_update();
				su.main(null);
				frame.dispose();
			}
		});
		saup_btn.setBounds(138, 121, 166, 26);
		frame.getContentPane().add(saup_btn);
		
		JButton staffM_btn = new JButton("Staff Meetings");
		staffM_btn.setBounds(136, 158, 166, 26);
		frame.getContentPane().add(staffM_btn);
		
		
		JButton upinfo_btn = new JButton("Update Info");
		upinfo_btn.setBounds(136, 194, 168, 26);
		frame.getContentPane().add(upinfo_btn);
		
		JButton back_btn = new JButton("back");
		back_btn.setBounds(10, 17, 82, 23);
		frame.getContentPane().add(back_btn);
		
		JButton btnNewButton = new JButton("Enter Student Details");
		btnNewButton.setBounds(136, 48, 168, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				enter_student_details ed = new enter_student_details();
				ed.main(null);
				frame.dispose();
				
			}
			
		});
		
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_professor_entry sp = new student_professor_entry();
				sp.main(null);
				frame.dispose();
				
			}
			
		});
		
		staffM_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				staff_meeting sm = new staff_meeting();
				sm.main(null);
				frame.dispose();
				
			}
			
		});
		
		marks_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mark_uploaded mu = new mark_uploaded();
				mu.main(null);
				frame.dispose();
				}
			
		});
		
		upinfo_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				professor_update_info ui = new professor_update_info();
				ui.main(null);
				frame.dispose();
				
			}
			
		});
		
		
		
	}
}
