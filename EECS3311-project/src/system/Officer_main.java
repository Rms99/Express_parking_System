package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

public class Officer_main {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JLabel lblAdminLoginId;
	private JLabel lblNewLabel;
	private JLabel lblAdminLoginId_1;
	private JLabel lblAdminLoginId_2;
	private JLabel lblAdminLoginId_3;
	private JLabel lblAdminLoginId_4;
	
	Officer_main()
	{
		frame = new JFrame("Parking_Officer_command_page");
		pannel = new JPanel();
		ofc_main();
	}
	public void ofc_main()
	{
		pannel.setBackground(new Color(255, 255, 153));
		frame.setSize(461, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(UIManager.getColor("Button.background"));
		back.setBounds(16, 418, 115, 45);
		pannel.add(back);
		lblNewLabel = new JLabel("View / Add/ Remove a Spot");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(21, 22, 365, 60);
		pannel.add(lblNewLabel);
		
		lblAdminLoginId = new JLabel("Parking Spot");
		lblAdminLoginId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId.setBounds(10, 108, 206, 51);
		pannel.add(lblAdminLoginId);
		
		JTextField ID = new JTextField();
		ID.setBounds(188, 108, 250, 48);
		pannel.add(ID);
		ID.setColumns(10);
		
		JButton book = new JButton("ADD");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		book.setToolTipText("Click to add the parking spot.");
		book.setForeground(Color.BLACK);
		book.setFont(new Font("Tahoma", Font.BOLD, 25));
		book.setBackground(SystemColor.menu);
		book.setBounds(21, 356, 417, 51);
		pannel.add(book);
		
		JButton delete = new JButton("REMOVE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		delete.setToolTipText("click to remove a parking spot.");
		delete.setForeground(Color.BLACK);
		delete.setFont(new Font("Tahoma", Font.BOLD, 25));
		delete.setBackground(SystemColor.menu);
		delete.setBounds(21, 166, 417, 51);
		pannel.add(delete);
		
		JTextField Cps = new JTextField();
		Cps.setColumns(10);
		Cps.setBounds(188, 232, 250, 48);
		pannel.add(Cps);
		
		lblAdminLoginId_1 = new JLabel("Parking Spot");
		lblAdminLoginId_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId_1.setBounds(10, 229, 168, 51);
		pannel.add(lblAdminLoginId_1);
		
		JTextField hr_1 = new JTextField();
		hr_1.setColumns(10);
		hr_1.setBounds(188, 303, 49, 48);
		pannel.add(hr_1);
		
		lblAdminLoginId_2 = new JLabel("Time Needed");
		lblAdminLoginId_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId_2.setBounds(10, 300, 168, 51);
		pannel.add(lblAdminLoginId_2);
		
		lblAdminLoginId_3 = new JLabel("Hrs");
		lblAdminLoginId_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId_3.setBounds(247, 303, 55, 51);
		pannel.add(lblAdminLoginId_3);
		
		JTextField min_1 = new JTextField();
		min_1.setColumns(10);
		min_1.setBounds(312, 303, 49, 48);
		pannel.add(min_1);
		
		lblAdminLoginId_4 = new JLabel("Mins");
		lblAdminLoginId_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId_4.setBounds(383, 300, 66, 51);
		pannel.add(lblAdminLoginId_4);
		
		JButton btnViewBookings = new JButton("View Bookings");
		btnViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Officer_view ov = new Officer_view();
				ov.view();
			}
		});
		btnViewBookings.setToolTipText("Click to add the parking spot.");
		btnViewBookings.setForeground(Color.BLACK);
		btnViewBookings.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewBookings.setBackground(SystemColor.menu);
		btnViewBookings.setBounds(141, 418, 297, 45);
		pannel.add(btnViewBookings);
		frame.setResizable(false);
		//button actions
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back_end be = new Back_end();
				if(ID.getText().isEmpty() == true)
				{
					JOptionPane.showMessageDialog(null,"Empty Blank Submitted","Empty Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.o_booking_exists(ID.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` is already available.","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.o_time_exists(ID.getText()) == true)
				{
					JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` cannot be deleted now.","Time Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					Back_end_2 be2 = new Back_end_2();
					boolean a = be2.o_delete_booking(ID.getText());
					if(a == true)
					{
					JOptionPane.showMessageDialog(null,"Spot is now available for Booking.","success",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` is invalid","Error",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		book.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Back_end be = new Back_end();
				if(Cps.getText().isBlank() == false && hr_1.getText().isBlank() == false && min_1.getText().isBlank() == false)
				{
					int boom = Integer.parseInt(Cps.getText());
					if(boom<0 || boom>3000)
					{
						JOptionPane.showMessageDialog(null, "We, only have parking numbers from 1-3000.\n"
								+ Cps.getText() +" is not a valid spot.","Invalid parking number.",JOptionPane.INFORMATION_MESSAGE);
					}
				else if(be.spot_exists(Integer.parseInt(Cps.getText())) == true)
				{
					int temp = Integer.parseInt(hr_1.getText())*60 + Integer.parseInt(min_1.getText());
					if(temp >= 30 && temp <= 180)
					{
						int hr1 = Integer.parseInt(hr_1.getText());
						int min1 = Integer.parseInt(hr_1.getText());
						Calendar cl = Calendar.getInstance();
						cl.add(Calendar.HOUR, hr1);
						cl.add(Calendar.MINUTE, min1);
						String s = String.valueOf(cl.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl.get(Calendar.MINUTE));
						Back_end_2 be2 = new Back_end_2();
						be2.spot_add(Cps.getText(), s, "na", "cash", "na", "paid", "n/a", "manual");
						JOptionPane.showMessageDialog(null, "Spot is booked.","Succesfull",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Fill time again","Time Error",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Spot -> " + Cps.getText() +
							 "not available.","Spot not free.",JOptionPane.INFORMATION_MESSAGE);
				}
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Donot leave Vehicle number and parking spot empty.\n"
							 + "Fill zero in the spaces left blank." + "\nFill like this -> 1 hrs 0 mins or 0 hrs 30 mins.",
							 "Empty space error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//Main_GUI m = new Main_GUI();
				Officer_login ol = new Officer_login();
				ol.ofc_login();
			}
		});
		
	}
}
