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
import javax.swing.UIManager;

public class Officer_login {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JLabel lblAdminLoginId;
	private JLabel lblPassword;
	private JButton o_login;
	private JLabel lblNewLabel;
	
	Officer_login()
	{
		frame = new JFrame("Parking_Officer_LOGIN");
		pannel = new JPanel();
		ofc_login();
	}
	public void ofc_login()
	{
		pannel.setBackground(new Color(255, 255, 153));
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(UIManager.getColor("Button.background"));
		back.setBounds(0, 418, 115, 45);
		pannel.add(back);
		lblNewLabel = new JLabel("Parking Officer Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(10, 24, 466, 60);
		pannel.add(lblNewLabel);
		
		lblAdminLoginId = new JLabel("Officer Login ID:");
		lblAdminLoginId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminLoginId.setBounds(10, 108, 206, 51);
		pannel.add(lblAdminLoginId);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPassword.setBounds(79, 178, 137, 60);
		pannel.add(lblPassword);
		
		JTextField ologin = new JTextField();
		ologin.setBounds(226, 108, 212, 48);
		pannel.add(ologin);
		ologin.setColumns(10);
		
		JPasswordField opass = new JPasswordField();
		opass.setColumns(10);
		opass.setBounds(226, 184, 212, 48);
		pannel.add(opass);
		
		o_login = new JButton("LOGIN");
		
		o_login.setForeground(Color.BLACK);
		o_login.setFont(new Font("Tahoma", Font.BOLD, 25));
		o_login.setBackground(UIManager.getColor("Button.background"));
		o_login.setBounds(151, 259, 168, 51);
		pannel.add(o_login);
		
		
		//button actions
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				//Main_GUI m = new Main_GUI();
				Main_GUI.showframe();
			}
		});
		
		o_login.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Back_end be = new Back_end();
				boolean bool = be.ofcr_exists(ologin.getText(), opass.getText());
				if(bool == true)
				{
					frame.setVisible(false);
					Officer_main om = new Officer_main();
					om.ofc_main();
				}
				else if(ologin.getText().isBlank()== true && opass.getText().isBlank()== true)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in the Login Id and password.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"User does not exist, kindly check.\n Or \n Contact Administrator.","Invalid Admin Details",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
			}
		});
	
		
	}
}
