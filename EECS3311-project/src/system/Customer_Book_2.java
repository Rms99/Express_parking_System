package system;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Customer_Book_2 {
	private static JFrame frame;
	private static JPanel pannel;
	Customer_Book_2()
	{
		frame = new JFrame("CUSTOMER_CHECKOUT_PAGE");
		pannel = new JPanel();
	//book_2();
	}
	
	public void book_2(String cus_email, String veh_num, int spot1, int hrs1, int mins1 ) {	
		
		String current_user = cus_email;
		String v_num = veh_num;
		int p1 = spot1;
		int hrs_1 = hrs1;
		int mins_1 = mins1;
	pannel.setBackground(new Color(0, 255, 204));
	frame.setSize(487, 545);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(pannel);
	pannel.setLayout(null);
	frame.setResizable(false);
	JLabel Top_label = new JLabel("Checkout Page");
	Top_label.setFont(new Font("Tahoma", Font.BOLD, 30));
	Top_label.setBounds(118, 0, 247, 40);
	pannel.add(Top_label);
	
	JLabel Top_label_2_1_1_1 = new JLabel("Mins");
	Top_label_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	Top_label_2_1_1_1.setBounds(407, 205, 47, 40);
	pannel.add(Top_label_2_1_1_1);
	
	JLabel Top_label_2_1_1_2 = new JLabel("Hrs");
	Top_label_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
	Top_label_2_1_1_2.setBounds(285, 315, 35, 40);
	pannel.add(Top_label_2_1_1_2);
	
	JLabel Top_label_2_1_1_1_1 = new JLabel("Mins");
	Top_label_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	Top_label_2_1_1_1_1.setBounds(407, 315, 47, 40);
	pannel.add(Top_label_2_1_1_1_1);
	frame.setVisible(true);
	
	JLabel Top_label_1 = new JLabel("Parking Spot 2");
	Top_label_1.setFont(new Font("Tahoma", Font.BOLD, 25));
	Top_label_1.setBounds(10, 160, 186, 40);
	pannel.add(Top_label_1);
	
	JLabel Top_label_2 = new JLabel("Parking Spot 3");
	Top_label_2.setFont(new Font("Tahoma", Font.BOLD, 25));
	Top_label_2.setBounds(10, 270, 186, 40);
	pannel.add(Top_label_2);
	
	JButton Back = new JButton("Back");
	Back.setFont(new Font("Tahoma", Font.BOLD, 20));
	Back.setBounds(10, 411, 210, 96);
	pannel.add(Back);
	
	JButton checkout = new JButton("Checkout");
	checkout.setFont(new Font("Tahoma", Font.BOLD, 20));
	checkout.setBounds(263, 411, 210, 96);
	pannel.add(checkout);
	
	JLabel Top_label_2_1 = new JLabel("Time Spot 2");
	Top_label_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
	Top_label_2_1.setBounds(10, 205, 186, 40);
	pannel.add(Top_label_2_1);
	
	JLabel Top_label_2_2 = new JLabel("Time Spot 3");
	Top_label_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
	Top_label_2_2.setBounds(10, 315, 186, 40);
	pannel.add(Top_label_2_2);
	
	JLabel Top_label_2_1_1 = new JLabel("Hrs");
	Top_label_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
	Top_label_2_1_1.setBounds(285, 205, 35, 40);
	pannel.add(Top_label_2_1_1);
	
	
	JLabel checker_2 = new JLabel("");
	checker_2.setForeground(Color.RED);
	checker_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
	checker_2.setBounds(240, 357, 233, 28);
	pannel.add(checker_2);
	
	JLabel checker_1 = new JLabel("");
	checker_1.setForeground(Color.RED);
	checker_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	checker_1.setBounds(228, 241, 233, 28);
	pannel.add(checker_1);
	
	
	JTextField spot_2 = new JTextField();
	spot_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	spot_2.setBounds(228, 160, 226, 36);
	pannel.add(spot_2);
	spot_2.setColumns(10);
	spot_2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				spot_2.setEditable(false);
				checker_1.setText("Enter a valid Spot number.");
			}
			else
			{
				spot_2.setEditable(true);
				checker_1.setText("");
			}
		}
	});
	
	JTextField spot_3 = new JTextField();
	spot_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	spot_3.setColumns(10);
	spot_3.setBounds(228, 270, 226, 36);
	pannel.add(spot_3);
	spot_3.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				spot_3.setEditable(false);
				checker_2.setText("Enter a valid Spot number.");
			}
			else
			{
				spot_3.setEditable(true);
				checker_2.setText("");
			}
		}
	});
	
	JTextField hr_2 = new JTextField();
	hr_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	hr_2.setColumns(10);
	hr_2.setBounds(228, 205, 47, 36);
	pannel.add(hr_2);
	hr_2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				hr_2.setEditable(false);
				checker_1.setText("Enter a valid Spot number.");
			}
			else
			{
				hr_2.setEditable(true);
				checker_1.setText("");
			}
		}
	});
	
	JTextField min_2 = new JTextField();
	min_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	min_2.setColumns(10);
	min_2.setBounds(350, 205, 47, 36);
	pannel.add(min_2);
	min_2.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				min_2.setEditable(false);
				checker_1.setText("Enter a valid Spot number.");
			}
			else
			{
				min_2.setEditable(true);
				checker_1.setText("");
			}
		}
	});
	
	JTextField hr_3 = new JTextField();
	hr_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	hr_3.setColumns(10);
	hr_3.setBounds(228, 315, 47, 36);
	pannel.add(hr_3);
	hr_3.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				hr_3.setEditable(false);
				checker_2.setText("Enter a valid Spot number.");
			}
			else
			{
				hr_3.setEditable(true);
				checker_2.setText("");
			}
		}
	});
	
	JTextField min_3 = new JTextField();
	min_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
	min_3.setColumns(10);
	min_3.setBounds(350, 315, 47, 36);
	pannel.add(min_3);
	
	min_3.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			char c = e.getKeyChar();
			if(Character.isLetter(c))
			{
				min_3.setEditable(false);
				checker_2.setText("Enter a valid Spot number.");
			}
			else
			{
				min_3.setEditable(true);
				checker_2.setText("");
			}
		}
	});
	
	JLabel lblKindlyFillIn_1 = new JLabel("---------------------------------------\r\n---------------------\r\n");
	lblKindlyFillIn_1.setForeground(Color.BLACK);
	lblKindlyFillIn_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
	lblKindlyFillIn_1.setBounds(0, 383, 483, 28);
	pannel.add(lblKindlyFillIn_1);
	
	JLabel lblKindlyFillIn_1_2 = new JLabel("---------------------------------------\r\n---------------------\r\n");
	lblKindlyFillIn_1_2.setForeground(Color.BLACK);
	lblKindlyFillIn_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
	lblKindlyFillIn_1_2.setBounds(0, 136, 483, 28);
	pannel.add(lblKindlyFillIn_1_2);
	
	JLabel lblKindlyFillIn_1_2_1 = new JLabel("---------------------------------------\r\n---------------------\r\n");
	lblKindlyFillIn_1_2_1.setForeground(Color.BLACK);
	lblKindlyFillIn_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
	lblKindlyFillIn_1_2_1.setBounds(0, 32, 483, 28);
	pannel.add(lblKindlyFillIn_1_2_1);
	
	JLabel Top_label_1_1 = new JLabel("How many more spots needed ?");
	Top_label_1_1.setForeground(Color.RED);
	Top_label_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
	Top_label_1_1.setBounds(10, 58, 432, 40);
	pannel.add(Top_label_1_1);
	
	JRadioButton Zero = new JRadioButton("Zero");
	Zero.setFont(new Font("Tahoma", Font.PLAIN, 25));
	Zero.setBounds(20, 104, 103, 40);
	pannel.add(Zero);
	
	JRadioButton One = new JRadioButton("One");
	One.setFont(new Font("Tahoma", Font.PLAIN, 25));
	One.setBounds(194, 104, 103, 40);
	pannel.add(One);
	
	JRadioButton Two = new JRadioButton("Two");
	Two.setFont(new Font("Tahoma", Font.PLAIN, 25));
	Two.setBounds(373, 104, 103, 40);
	pannel.add(Two);

	
	//Button actions
	Zero.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Zero.isSelected() == true)
			{
				One.setSelected(false);
				Two.setSelected(false);
				spot_2.setEditable(false);
				hr_2.setEditable(false);
				min_2.setEditable(false);
				spot_3.setEditable(false);
				hr_3.setEditable(false);
				min_3.setEditable(false);
			}
		}
	});
	
	One.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(One.isSelected() == true)
			{
				Zero.setSelected(false);
				Two.setSelected(false);
				
				spot_2.setEditable(true);
				hr_2.setEditable(true);
				min_2.setEditable(true);
				
				spot_3.setEditable(false);
				hr_3.setEditable(false);
				min_3.setEditable(false);
			}
		}
	});
	Two.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(Two.isSelected()==true)
			{
			Zero.setSelected(false);
			One.setSelected(false);
			
			spot_2.setEditable(true);
			hr_2.setEditable(true);
			min_2.setEditable(true);
			
			spot_3.setEditable(true);
			hr_3.setEditable(true);
			min_3.setEditable(true);
			}
		}
	});
	
	Back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_Book c = new Customer_Book();
			c.book(current_user);
		}
	});
	
	checkout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
		
		if(Zero.isSelected() == true)
		{
			frame.setVisible(false);
			
			double total = 0.1*(hrs_1*60 + mins_1);
			String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String id = "";
			  for (int i = 0; i < 4; i++) {
			    id += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			  }
			Customer_pay cp = new Customer_pay();
			cp.pay(current_user,v_num,String.valueOf(p1),"0","0",id,"0","0",String.valueOf(total),hrs1,mins1,0,0,0,0,1);
		}
		
		else if(One.isSelected() == true)
		{	Back_end be = new Back_end();
			int temp = Integer.parseInt(hr_2.getText())*60 + Integer.parseInt(min_2.getText());
			if(spot_2.getText().isBlank() == true || hr_2.getText().isBlank() == true || min_2.getText().isBlank() == true)
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(spot_2.getText().equals("0") == true || (hr_2.getText().equals("0") == true && min_2.getText().equals("0") == true))
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(be.spot_exists(Integer.parseInt(spot_2.getText())) == false)
			{
				JOptionPane.showMessageDialog(null,"Choose other spot","Spot already booked.",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(temp <30 || temp> 180)
			{
				JOptionPane.showMessageDialog(null, "Fill time again","Time Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else {
			frame.setVisible(false);
			int mins2 = Integer.parseInt(min_2.getText());
			int hrs2 = Integer.parseInt(hr_2.getText());
			double total = 0.1*(hrs_1*60 + mins_1) + 0.1*(hrs2*60 + mins2);
			String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String id = "",id2="";
			  for (int i = 0; i < 4; i++) {
			    id += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			    id2 += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			  }
			Customer_pay cp = new Customer_pay();
			cp.pay(current_user,v_num,String.valueOf(p1),spot_2.getText(),"0",id,id2,"0",String.valueOf(total),hrs1,mins1,hrs2,mins2,0,0,2);
		}
		}
		
		else if(Two.isSelected() == true)
		{
			int temp = Integer.parseInt(hr_3.getText())*60 + Integer.parseInt(min_3.getText());
			int temp2 = Integer.parseInt(hr_2.getText())*60 + Integer.parseInt(min_2.getText());
			Back_end be = new Back_end();
			
			if(spot_2.getText().isBlank() == true || hr_2.getText().isBlank() == true || min_2.getText().isBlank() == true)
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(spot_2.getText().equals("0") == true || (hr_2.getText().equals("0") == true && min_2.getText().equals("0") == true))
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(spot_3.getText().isBlank() == true || hr_3.getText().isBlank() == true || min_3.getText().isBlank() == true)
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(spot_3.getText().equals("0") == true || (hr_3.getText().equals("0") == true && min_3.getText().equals("0") == true))
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Blanks Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(be.spot_exists(Integer.parseInt(spot_2.getText())) == false)
			{
				JOptionPane.showMessageDialog(null,"Choose another spot2","Spot already booked.",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(be.spot_exists(Integer.parseInt(spot_3.getText())) == false)
			{
				JOptionPane.showMessageDialog(null,"Choose another spot3","Spot already booked.",JOptionPane.INFORMATION_MESSAGE);
			}
		
			else if(temp <30 || temp> 180)
			{
				JOptionPane.showMessageDialog(null, "Fill time again","Time Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(temp2 <30 || temp2> 180)
			{
				JOptionPane.showMessageDialog(null, "Fill time again","Time Error",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else
			{
			frame.setVisible(false);
			
			int mins2 = Integer.parseInt(min_2.getText());
			int hrs2 = Integer.parseInt(hr_2.getText());
			int mins3 = Integer.parseInt(min_3.getText());
			int hrs3 = Integer.parseInt(hr_3.getText());
			double total = 0.1*(hrs_1*60 + mins_1) + 0.1*(hrs2*60 + mins2) + 0.1*(hrs3*60 + mins3);
			String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String id = "",id2="",id3="";
			  for (int i = 0; i < 4; i++) {
			    id += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			    id2 += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			    id3 += alpha.charAt((int) Math.floor(Math.random() * alpha.length()));
			  }
			Customer_pay cp = new Customer_pay();
			cp.pay(current_user,v_num,String.valueOf(p1),spot_2.getText(),spot_3.getText(),id,id2,id3,String.valueOf(total),hrs1,mins1,hrs2,mins2,hrs3,mins3,3);
			}
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,"Choose one of Zero, One or Two.","Error",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		}
		
	});
	
	}
}
