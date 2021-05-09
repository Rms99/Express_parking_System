package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Admin_login {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JLabel lblNewLabel;
	private JLabel lblAdminLoginId;
	private JLabel lblPassword;
	private JButton a_login;
	Admin_login()
	{
		frame = new JFrame("ADMIN_LOGIN");
		pannel = new JPanel();
		ad_login();
	}
	public void ad_login()
	{
		pannel.setBackground(new Color(255, 153, 153));
		frame.setSize(500, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(UIManager.getColor("Button.background"));
		back.setBounds(178, 317, 115, 45);
		pannel.add(back);
		
		lblNewLabel = new JLabel("Admin Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(73, 24, 340, 60);
		pannel.add(lblNewLabel);
		
		lblAdminLoginId = new JLabel("Admin Login ID:");
		lblAdminLoginId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId.setBounds(10, 108, 206, 51);
		pannel.add(lblAdminLoginId);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(79, 178, 137, 60);
		pannel.add(lblPassword);
		
		JTextField alogin = new JTextField();
		alogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		alogin.setBounds(226, 108, 212, 48);
		pannel.add(alogin);
		alogin.setColumns(10);
		
		JPasswordField apass = new JPasswordField();
		apass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apass.setColumns(10);
		apass.setBounds(226, 184, 212, 48);
		pannel.add(apass);
		
		a_login = new JButton("LOGIN");
	
		a_login.setForeground(Color.BLACK);
		a_login.setFont(new Font("Tahoma", Font.BOLD, 25));
		a_login.setBackground(UIManager.getColor("Button.background"));
		a_login.setBounds(151, 259, 168, 51);
		pannel.add(a_login);
		
		
		//button actions
		a_login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Back_end be = new Back_end();
				if(be.admin_exists(alogin.getText(), apass.getText())== true)
						{
						frame.setVisible(false);
						Admin_main am = new Admin_main();
						am.admin_mp();
						}
				else if(alogin.getText().isBlank()== true && apass.getText().isBlank()== true)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in the Login Id and password.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"User doesnot exist, kindly check.\n Or \n Contact IT Department","Invalid Admin Details",JOptionPane.INFORMATION_MESSAGE);
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
