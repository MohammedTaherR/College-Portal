package studCrud;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class student_details {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_details window = new student_details();
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
	public student_details() {
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
		
		JLabel lblNewLabel = new JLabel("WELCOME STUDENT");
		lblNewLabel.setFont(new Font("VALORANT", Font.PLAIN, 18));
		lblNewLabel.setBounds(136, 11, 197, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.setBounds(151, 58, 150, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exam Schedule");
		btnNewButton_1.setBounds(151, 92, 150, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Event Schedule");
		btnNewButton_2.setBounds(151, 126, 150, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Result");
		btnNewButton_3.setBounds(151, 160, 150, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("back");
		btnNewButton_4.setBounds(0, 17, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				exam_schedule es = new exam_schedule();
				es.main(null);
				frame.dispose();
				
				
			}
		
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				event ev = new event();
				ev.main(null);
				frame.dispose();
				
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				student_update_info up = new student_update_info();
				up.main(null);
			frame.dispose();
			}
			
		});
		
		btnNewButton_4.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				student_professor_entry sp = new student_professor_entry();
				sp.main(null);
				frame.dispose();
			}
			
		});
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				result_check rc = new result_check();
				rc.main(null);
				frame.dispose();
				
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
