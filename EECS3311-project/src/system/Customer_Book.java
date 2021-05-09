package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Customer_Book {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	public JLabel checker;
	public JLabel checker_1;
	Customer_Book()
	{
		frame = new JFrame("CUSTOMER_BOOKING");
		pannel = new JPanel();
	}
	
	public void book(String s) {	
		//int spot;
		//int hrs;
		// mins;
		String current_user = s;
	pannel.setBackground(new Color(0, 255, 204));
	frame.setSize(500, 542);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(pannel);
	pannel.setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	back = new JButton("BACK");
	back.setFont(new Font("Tahoma", Font.BOLD,20));
	back.setForeground(new Color(0, 0, 0));
	back.setBackground(new Color(0, 51, 255));
	back.setBounds(163, 459, 152, 45);
	pannel.add(back);
	
	JLabel lblHours = new JLabel("Hour(s)");
	lblHours.setFont(new Font("Tahoma", Font.BOLD, 15));
	lblHours.setBounds(282, 264, 60, 32);
	pannel.add(lblHours);
	
	JLabel min = new JLabel("Mins");
	min.setFont(new Font("Tahoma", Font.BOLD, 15));
	min.setBounds(445, 264, 41, 32);
	pannel.add(min);
	
	JLabel lblNewLabel_1 = new JLabel("Minimum Booking Time = 30 mins");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	lblNewLabel_1.setBounds(102, 360, 314, 30);
	pannel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("Maximum Booking Time = 3 hours");
	lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	lblNewLabel_1_1.setBounds(102, 390, 314, 30);
	pannel.add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_1_2 = new JLabel("Price is 3 dollar for half-hour/30 min");
	lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	lblNewLabel_1_2.setBounds(102, 419, 314, 30);
	pannel.add(lblNewLabel_1_2);
	
	JLabel PS = new JLabel("Parking Spot 1");
	PS.setFont(new Font("Tahoma", Font.BOLD, 20));
	PS.setBounds(10, 203, 165, 32);
	pannel.add(PS);
	
	JLabel Top = new JLabel("Book A Parking Spot");
	Top.setFont(new Font("Times New Roman", Font.BOLD, 35));
	Top.setBounds(73, 61, 331, 45);
	pannel.add(Top);
	
	JLabel lblNewLabel = new JLabel("    Enter Vehicle number, Parking spot & time");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setBounds(10, 116, 466, 25);
	pannel.add(lblNewLabel);
	
	JLabel VN = new JLabel("Vehicle Number");
	VN.setFont(new Font("Tahoma", Font.BOLD, 19));
	VN.setBounds(10, 165, 165, 32);
	pannel.add(VN);
	
	JLabel TM = new JLabel("Time Needed");
	TM.setFont(new Font("Tahoma", Font.BOLD, 20));
	TM.setBounds(10, 264, 165, 32);
	pannel.add(TM);
	
	JLabel lblWelcome = new JLabel("Welcome");
	lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 37));
	lblWelcome.setBounds(163, 10, 152, 45);
	pannel.add(lblWelcome);
	
	JButton proceed = new JButton("Proceed");
	proceed.setFont(new Font("Tahoma", Font.BOLD, 25));
	proceed.setBounds(163, 305, 152, 57);
	pannel.add(proceed);
		
	JTextField Cvn = new JTextField();
	Cvn.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Cvn.setColumns(10);
	Cvn.setBounds(185, 165, 291, 30);
	pannel.add(Cvn);
	
	JTextField hr_1 = new JTextField();
	hr_1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				hr_1.setEditable(false);
				checker.setText("Enter a valid number(hrs)");
			}
			else
			{
				hr_1.setEditable(true);
				checker.setText("");
			}
		}
	});
	
	hr_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	hr_1.setColumns(10);
	hr_1.setBounds(185, 264, 96, 30);
	pannel.add(hr_1);
	
	JTextField min_1 = new JTextField();
	min_1.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				min_1.setEditable(false);
				checker.setText("Enter a valid number(mins)");
			}
			else
			{
				 min_1.setEditable(true);
				 checker.setText("");
			}
		}
		
	});
	
	min_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	min_1.setColumns(10);
	min_1.setBounds(345, 266, 90, 30);
	pannel.add(min_1);
	
	JTextField Cps = new JTextField();
	Cps.setToolTipText("Spot should be integer and must lie between 1 and 3000.");
	Cps.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Cps.setBounds(185, 205, 291, 30);
	pannel.add(Cps);
	Cps.setColumns(10);
	
	Cps.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				Cps.setEditable(false);
				checker_1.setText("Enter a valid number");
			}
			else
			{
				Cps.setEditable(true);
				checker_1.setText("");
			}
		}
	});
	
	checker = new JLabel("");
	checker.setForeground(Color.RED);
	checker.setFont(new Font("Tahoma", Font.BOLD, 15));
	checker.setBounds(185, 302, 240, 25);
	pannel.add(checker);
	
	checker_1 = new JLabel("");
	checker_1.setForeground(Color.RED);
	checker_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	checker_1.setBounds(185, 234, 240, 25);
	pannel.add(checker_1);
	
	//Button actions below
	
	proceed.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			Back_end be = new Back_end();
			if(Cps.getText().isBlank() == false && Cvn.getText().isBlank() == false && hr_1.getText().isBlank() == false && min_1.getText().isBlank() == false)
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
					frame.setVisible(false);
					Customer_Book_2 be2 = new Customer_Book_2();
					be2.book_2(current_user, Cvn.getText(), Integer.parseInt(Cps.getText()), Integer.parseInt(hr_1.getText()), Integer.parseInt(min_1.getText()));
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
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_ops o = new Customer_ops();
			o.options(current_user);
		}
	});
	
	}
}
