package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Customer_ops {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private static JButton Cancel_btn;
	private static JButton View_btn;
	private static JButton Book_btn;
	Customer_ops()
	{
		frame = new JFrame("CUSTOMER_OPTIONS");
		pannel = new JPanel();
		
	}
	
	public void options(String email) {	
		
		String current_user = email;
	
	pannel.setBackground(new Color(0, 255, 204));
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(pannel);
	pannel.setLayout(null);
	frame.setVisible(true);
	frame.setResizable(false);
	back = new JButton("Logout");
	back.setFont(new Font("Tahoma", Font.BOLD,20));
	back.setForeground(new Color(0, 0, 0));
	back.setBackground(new Color(0, 51, 255));
	back.setBounds(0, 418, 152, 45);
	pannel.add(back);
	
	JLabel Top = new JLabel("Choose from below");
	Top.setFont(new Font("Times New Roman", Font.BOLD, 35));
	Top.setBounds(101, 10, 291, 45);
	pannel.add(Top);
	
	JLabel lblNewLabel = new JLabel("BOOK, VIEW and CANCEL");
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setBounds(121, 66, 260, 25);
	pannel.add(lblNewLabel);
	
	Book_btn = new JButton("BOOK");
	Book_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_Book b = new Customer_Book();
			b.book(current_user);
		}
	});
	Book_btn.setFont(new Font("Tahoma", Font.BOLD, 25));
	Book_btn.setBounds(101, 124, 291, 84);
	pannel.add(Book_btn);
	
	View_btn = new JButton("VIEW Bookings");
	View_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_viewB vb = new Customer_viewB();
			vb.view(current_user);
		}
	});
	View_btn.setFont(new Font("Tahoma", Font.BOLD, 25));
	View_btn.setBounds(101, 224, 291, 84);
	pannel.add(View_btn);
	
	Cancel_btn = new JButton("Cancel Bookings");
	Cancel_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_cancel c = new Customer_cancel();
			c.cancel(current_user);
		}
	});
	Cancel_btn.setFont(new Font("Tahoma", Font.BOLD, 25));
	Cancel_btn.setBounds(101, 324, 291, 84);
	pannel.add(Cancel_btn);
	
	//Button actions below
	
	back.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Main_GUI.showframe();
		}
	});
	
	}
}
