package system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_mpeo {

	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JLabel lblNewLabel;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmailId;
	private JLabel lblUniqueId;
	Admin_mpeo()
	{
		frame = new JFrame("ADMIN_MANAGE_OFFICERS");
		pannel = new JPanel();
		officer();
	}
	
	public void officer()
	{
		pannel.setBackground(new Color(255, 153, 153));
		frame.setSize(563, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(UIManager.getColor("Button.background"));
		back.setBounds(195, 518, 150, 70);
		pannel.add(back);
		
		lblNewLabel = new JLabel("Manage Parking Officer's");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(113, 10, 321, 54);
		pannel.add(lblNewLabel);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblFirstName.setBounds(17, 86, 153, 36);
		pannel.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLastName.setBounds(17, 146, 153, 36);
		pannel.add(lblLastName);
		
		lblEmailId = new JLabel("Email ID:");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmailId.setBounds(17, 206, 153, 36);
		pannel.add(lblEmailId);
		
		lblUniqueId = new JLabel("Unique ID:");
		lblUniqueId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUniqueId.setBounds(17, 266, 153, 36);
		pannel.add(lblUniqueId);
		
		JTextField ofn = new JTextField();
		ofn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ofn.setText("NA");
		ofn.setBounds(221, 86, 257, 36);
		pannel.add(ofn);
		ofn.setColumns(10);
		
		JTextField oln = new JTextField();
		oln.setText("NA");
		oln.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oln.setColumns(10);
		oln.setBounds(221, 146, 257, 36);
		pannel.add(oln);
		
		JTextField oeid = new JTextField();
		oeid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oeid.setText("NA");
		oeid.setColumns(10);
		oeid.setBounds(221, 206, 257, 36);
		pannel.add(oeid);
		
		JTextField ouid = new JTextField();
		ouid.setText("NA");
		ouid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ouid.setColumns(10);
		ouid.setBounds(221, 266, 257, 36);
		pannel.add(ouid);
		
		JButton Add_officer = new JButton("ADD");
		
		Add_officer.setToolTipText("ADD an officer");
		Add_officer.setForeground(Color.BLACK);
		Add_officer.setFont(new Font("Tahoma", Font.BOLD, 25));
		Add_officer.setBackground(UIManager.getColor("Button.background"));
		Add_officer.setBounds(17, 324, 250, 120);
		pannel.add(Add_officer);
		
		JButton Remove_officer = new JButton("REMOVE");
		Remove_officer.setToolTipText("Remove an officer, only fill email id");
		Remove_officer.setForeground(Color.BLACK);
		Remove_officer.setFont(new Font("Tahoma", Font.BOLD, 25));
		Remove_officer.setBackground(UIManager.getColor("Button.background"));
		Remove_officer.setBounds(287, 324, 250, 120);
		pannel.add(Remove_officer);
		
		JLabel lblNewLabel_1 = new JLabel("If you want to remove an officer just fill his/her ");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(17, 453, 522, 25);
		pannel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email ID box and fill 'NA' in all other boxes.");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(17, 492, 522, 25);
		pannel.add(lblNewLabel_1_1);
		
		//button actions
		Add_officer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back_end_2 be2 = new Back_end_2();
				Back_end be = new Back_end();
				int temp = be2.mpeo_add(ofn.getText(), oln.getText(), oeid.getText(), ouid.getText());
				if(temp == 0)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in UID Again.\n " + ouid.getText() 
							,"<- UID Already Exists.",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(temp == 1)
				{
					JOptionPane.showMessageDialog(null,"Check the email id ->" + oeid.getText()+ ".\n"
							+ "Officer already exists.","Error-officer already registered.",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(ofn.getText().isBlank()== true || oln.getText().isBlank()== true || oeid.getText().isBlank()== true || ouid.getText().isBlank()== true)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(ofn.getText().equalsIgnoreCase("NA")==true  || oln.getText().equalsIgnoreCase("NA")==true 
						|| oeid.getText().equalsIgnoreCase("NA")==true || ouid.getText().equalsIgnoreCase("NA")==true)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in the the blanks.","Empty Forum Submitted",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.correct_email(oeid.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"Incorrect email -> "+ "\n '@' or '.' missing.","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Officer ->" + ofn.getText() +" "+oln.getText() +", "
							+ "Added.\n" + "Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		Remove_officer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back_end_2 be2 = new Back_end_2();
				if(ofn.getText().equalsIgnoreCase("NA")==false || oln.getText().equalsIgnoreCase("NA")==false || ouid.getText().equalsIgnoreCase("NA")==false)
				{
					JOptionPane.showMessageDialog(null,"Kindly Fill in email ID box only.\n Leave other boxes"
							+ "empty.","Only Fill Email box",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be2.mpeo_delete("officer",oeid.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"Check the email id ->" + oeid.getText()+ ".\n"
							+ "Officer does not exist.","Error-officer not in system.",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Officer ->" + oeid.getText() +", Deleted.\n" + "Successfully.","Success",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_main ma = new Admin_main();
				ma.admin_mp();

			}
		});
		
	}
}
