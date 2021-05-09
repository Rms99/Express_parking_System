package system;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Main_GUI {
		
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton customer;
	private static JButton admin;
	private static JButton poa;
	private static JLabel Select;
	private static JLabel display;
	private static JLabel lblTorontoExpressParking;

	public static void main(String[] args) {
		frame = new JFrame("HOME-PAGE");
		pannel = new JPanel();
		showframe();
	}
	public static void showframe()
	{
		
		
		pannel.setBackground(new Color(0, 255, 204));
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		
		
		display = new JLabel("WELCOME TO ");
		display.setFont(new Font("Tahoma", Font.BOLD, 25));
		display.setBackground(new Color(0, 255, 153));
		display.setBounds(144, 10, 200, 43);
		pannel.add(display);
		
		Select = new JLabel("Select customer for booking a spot");
		Select.setForeground(Color.RED);
		Select.setFont(new Font("Tahoma", Font.BOLD, 17));
		Select.setBackground(Color.RED);
		Select.setBounds(90, 90, 302, 43);
		pannel.add(Select);
		
		
		customer = new JButton("Customer");
		customer.setFont(new Font("Tahoma", Font.BOLD, 30));
		customer.setForeground(new Color(0, 0, 0));
		//customer.setBackground(new Color(0, 51, 255));
		customer.setBounds(144, 131, 200, 100);
		pannel.add(customer);
		
		customer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Customer_login c = new Customer_login();
				c.login();
			}
		});
		
		admin = new JButton("Administrator");
		admin.setFont(new Font("Tahoma", Font.BOLD, 20));
		admin.setForeground(new Color(0, 0, 0));
		//admin.setBackground(new Color(0, 51, 255));
		admin.setBounds(144, 241, 200, 100);
		pannel.add(admin);
	admin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_login ad = new Admin_login();
				ad.ad_login();
			}
		});
		
		poa = new JButton("Parking Officer");
		poa.setFont(new Font("Tahoma", Font.BOLD, 20));
		poa.setForeground(new Color(0, 0, 0));
		poa.setBounds(144, 351, 200, 100);
		pannel.add(poa);
		
		lblTorontoExpressParking = new JLabel("TORONTO EXPRESS PARKING APP");
		lblTorontoExpressParking.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTorontoExpressParking.setBackground(new Color(0, 255, 153));
		lblTorontoExpressParking.setBounds(36, 55, 428, 43);
		pannel.add(lblTorontoExpressParking);
    poa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Officer_login ad = new Officer_login();
				ad.ofc_login();
			}
		});
		
    	frame.setResizable(false);
		frame.setVisible(true);
	}
}
