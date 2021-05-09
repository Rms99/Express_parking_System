package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class Admin_main {

	private static JFrame frame;
	private static JPanel pannel;
	JButton back;
	Admin_main()
	{
		frame = new JFrame("ADMIN_MAIN_PAGE");
		pannel = new JPanel();
		admin_mp();
	}
	public void admin_mp() {
		pannel.setBackground(new Color(255, 153, 153));
		frame.setSize(418, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		
		 back = new JButton("BACK");
		 back.setFont(new Font("Tahoma", Font.BOLD,20));
			back.setForeground(new Color(0, 0, 0));
			back.setBackground(UIManager.getColor("Button.background"));
			back.setBounds(132, 291, 177, 45);
			pannel.add(back);
			
			JButton manage = new JButton("Manage PEO");
			manage.setFont(new Font("Tahoma", Font.BOLD, 20));
			manage.setBounds(132, 74, 177, 64);
			pannel.add(manage);
			
			JButton pay = new JButton("Pay Status");
			pay.setFont(new Font("Tahoma", Font.BOLD, 20));
			pay.setBounds(132, 196, 177, 64);
			pannel.add(pay);
			
			JLabel lblNewLabel = new JLabel("Manage Parking Officer's");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel.setBounds(68, 30, 322, 34);
			pannel.add(lblNewLabel);
			
			JLabel lblPaymentStatusUpdate = new JLabel("Payment Status Update");
			lblPaymentStatusUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblPaymentStatusUpdate.setBounds(68, 153, 296, 34);
			pannel.add(lblPaymentStatusUpdate);
			
			
		//button actions	
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_login al = new Admin_login();
				al.ad_login();
			}
		});
		
		manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_mpeo am = new Admin_mpeo();
				am.officer();
			}
		});
		
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_pay_status aps = new Admin_pay_status();
				aps.status();
			}
		});
	}
}
