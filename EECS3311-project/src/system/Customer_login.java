package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Customer_login {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	Customer_login()
	{
		frame = new JFrame("CUSTOMER_LOGIN_PAGE");
		pannel = new JPanel();
		login();
	}
	
	public void login() {	
	
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
	back.setBackground(UIManager.getColor("Button.background"));
	back.setBounds(176, 418, 115, 45);
	pannel.add(back);
	
	JLabel Cemail = new JLabel("Email-ID");
	Cemail.setFont(new Font("Tahoma", Font.BOLD, 20));
	Cemail.setBounds(47, 154, 107, 32);
	pannel.add(Cemail);
	
	JLabel Cpass = new JLabel("Password");
	Cpass.setFont(new Font("Tahoma", Font.BOLD, 20));
	Cpass.setBounds(47, 231, 107, 32);
	pannel.add(Cpass);
	
	JTextField Cid = new JTextField();
	Cid.setFont(new Font("Tahoma", Font.PLAIN, 16));
	Cid.setBounds(191, 156, 250, 30);
	pannel.add(Cid);
	Cid.setColumns(10);
	
	JButton Clogin = new JButton("Login");
	Clogin.setFont(new Font("Tahoma", Font.BOLD, 25));
	Clogin.setBounds(47, 288, 200, 45);
	pannel.add(Clogin);
	
	JPasswordField cpswd = new JPasswordField();
	cpswd.setFont(new Font("Tahoma", Font.PLAIN, 16));
	cpswd.setBounds(191, 237, 250, 30);
	pannel.add(cpswd);
	
	JLabel Top = new JLabel("  Login Page for the customer");
	Top.setFont(new Font("Times New Roman", Font.BOLD, 37));
	Top.setBounds(10, 49, 466, 45);
	pannel.add(Top);
	
	JLabel indicator = new JLabel("   Fill in your registered Email and password");
	indicator.setFont(new Font("Tahoma", Font.BOLD, 20));
	indicator.setForeground(Color.RED);
	indicator.setBounds(10, 104, 466, 25);
	pannel.add(indicator);
	
	JLabel bottom = new JLabel("            New Customer choose register button");
	bottom.setFont(new Font("Times New Roman", Font.BOLD, 20));
	bottom.setBounds(10, 356, 466, 32);
	pannel.add(bottom);
	
	JButton btnNewButton = new JButton("Register");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_reg r = new Customer_reg();
			r.register();
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
	btnNewButton.setBounds(257, 288, 200, 45);
	pannel.add(btnNewButton);
	
	JLabel welcome = new JLabel("Welcome");
	welcome.setFont(new Font("Times New Roman", Font.BOLD, 37));
	welcome.setBounds(163, 10, 152, 45);
	pannel.add(welcome);
	
	//button actions
	
	Clogin.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			Back_end be = new Back_end();
			if(be.cust_exists(Cid.getText(), cpswd.getText())== true)
					{
						frame.setVisible(false);
						Customer_ops ac = new Customer_ops();
						ac.options(Cid.getText());
						
					}
			else if(Cid.getText().isBlank()== true && cpswd.getText().isBlank()== true)
			{
				JOptionPane.showMessageDialog(null,"Kindly Fill in the Login Id and password.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"User doesnot exist, kindly check.\n Or Register","Invalid LoginID and Password",JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
	});
	
	back.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//Main_GUI m = new Main_GUI();
			Main_GUI.showframe();
		}
	});
	
	}
}
