package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Customer_reg {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	Customer_reg()
	{
		frame = new JFrame("CUSTOMER_REGISTRATION_PAGE");
		pannel = new JPanel();
		register();
	}
	
	public void register() {	
	
	pannel.setBackground(new Color(0, 255, 204));
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(pannel);
	pannel.setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
	back = new JButton("BACK");
	back.setFont(new Font("Tahoma", Font.BOLD,20));
	back.setForeground(new Color(0, 0, 0));
	back.setBackground(new Color(0, 51, 255));
	back.setBounds(163, 418, 152, 45);
	pannel.add(back);
	
	JLabel Ln = new JLabel("Last Name");
	Ln.setFont(new Font("Tahoma", Font.BOLD, 20));
	Ln.setBounds(47, 205, 107, 32);
	pannel.add(Ln);
	
	JLabel pass = new JLabel("Password");
	pass.setFont(new Font("Tahoma", Font.BOLD, 20));
	pass.setBounds(47, 285, 107, 32);
	pannel.add(pass);
	
	JTextField Cln = new JTextField();
	Cln.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Cln.setBounds(191, 205, 250, 30);
	pannel.add(Cln);
	Cln.setColumns(10);
	
	JLabel Top = new JLabel("Register Page for the customer");
	Top.setFont(new Font("Times New Roman", Font.BOLD, 35));
	Top.setBounds(10, 61, 466, 45);
	pannel.add(Top);
	
	JLabel lblNewLabel = new JLabel("      Enter your Name, Email and Password");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setBounds(10, 116, 466, 25);
	pannel.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("  Click Register");
	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	lblNewLabel_1.setBounds(163, 376, 152, 32);
	pannel.add(lblNewLabel_1);
	
	JButton Registerdb = new JButton("Register");
	Registerdb.setFont(new Font("Tahoma", Font.BOLD, 25));
	Registerdb.setBounds(163, 327, 152, 45);
	pannel.add(Registerdb);
	
	JLabel lblWelcome = new JLabel("Welcome");
	lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 37));
	lblWelcome.setBounds(163, 10, 152, 45);
	pannel.add(lblWelcome);
	
	JLabel email = new JLabel("Email");
	email.setFont(new Font("Tahoma", Font.BOLD, 20));
	email.setBounds(47, 245, 107, 32);
	pannel.add(email);
	
	JTextField cemail = new JTextField();
	cemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
	cemail.setColumns(10);
	cemail.setBounds(191, 245, 250, 30);
	pannel.add(cemail);
	
	JTextField Cfn = new JTextField();
	Cfn.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Cfn.setColumns(10);
	Cfn.setBounds(191, 165, 250, 30);
	pannel.add(Cfn);
	
	JLabel Fn = new JLabel("First Name");
	Fn.setFont(new Font("Tahoma", Font.BOLD, 19));
	Fn.setBounds(47, 165, 107, 32);
	pannel.add(Fn);
	
	JPasswordField cpass = new JPasswordField();
	cpass.setBounds(191, 285, 250, 32);
	pannel.add(cpass);
	
	//Button actions below
	
	Registerdb.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			Back_end_2 be2 = new Back_end_2();
			Back_end be = new Back_end();
			int temp = be2.cust_add(Cfn.getText(), Cln.getText(), cemail.getText(), cpass.getText());
			
			
			if(Cfn.getText().isBlank()== true || Cln.getText().isBlank()== true || cemail.getText().isBlank()== true || cpass.getText().isBlank()== true)
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(temp == 0)
			{
				JOptionPane.showMessageDialog(null,"Customer already exists for " + cemail.getText() +"."
						,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(be.correct_email(cemail.getText()) == false)
			{
				JOptionPane.showMessageDialog(null,"Incorrect email -> "
						+ "\n '@' or '.' missing.","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(temp ==2 )
			{
				JOptionPane.showMessageDialog(null,"HI," + Cfn.getText() +" "+Cln.getText() +"\nYou have been registered. "
						+ "\nKindly Login to the previous page.","Registere -> " + cemail.getText(),JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
	
	back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_login c = new Customer_login();
			c.login();
		}
	});
	
	}
}
