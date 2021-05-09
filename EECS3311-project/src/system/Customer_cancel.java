package system;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Customer_cancel {
	private static JFrame frame;
	private static JPanel pannel;

	Customer_cancel()
	{
		frame = new JFrame("Customer_Cancellation_Page");
		pannel = new JPanel();
	}
	
	public void cancel(String s)
	{
		String current_user = s;
		pannel.setBackground(new Color(0, 255, 204));
		frame.setSize(599, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setResizable(false);
		JLabel heading = new JLabel("Cancelation Page");
		heading.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		heading.setBounds(156, 10, 256, 44);
		pannel.add(heading);
		
		JButton back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD, 25));
		back.setBounds(200, 285, 131, 52);
		pannel.add(back);
		
		JLabel lblPutTheBooking = new JLabel("Put the Booking ID that you want to cancel.");
		lblPutTheBooking.setForeground(Color.RED);
		lblPutTheBooking.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblPutTheBooking.setBounds(97, 55, 411, 44);
		pannel.add(lblPutTheBooking);
		
		JLabel lblBookingId = new JLabel("Booking ID");
		lblBookingId.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBookingId.setBounds(32, 135, 164, 44);
		pannel.add(lblBookingId);
		
		JTextField ID = new JTextField();
		ID.setBounds(247, 135, 261, 44);
		pannel.add(ID);
		ID.setColumns(10);
		
		JButton delete = new JButton("Cancel");
		delete.setFont(new Font("Tahoma", Font.BOLD, 38));
		delete.setBounds(145, 210, 245, 52);
		pannel.add(delete);
		frame.setVisible(true);
		
		//button actions
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Customer_ops o = new Customer_ops();
				o.options(current_user);
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back_end be = new Back_end();
				if(ID.getText().isBlank() == true)
				{
					JOptionPane.showMessageDialog(null,"Empty Blank Submitted","Empty Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.booking_exists(ID.getText(), current_user) == false)
				{
					JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` is invalid","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.time_exists(ID.getText(), current_user) == false)
				{
					JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` cannot be deleted now.","Time Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					Back_end_2 be2 = new Back_end_2();
					boolean a = be2.delete_booking(ID.getText(), current_user);
					if(a == true)
					{
					JOptionPane.showMessageDialog(null,"Booking deleted","success",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Booking ID -> `" + ID.getText() + "` is invalid","Error",JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
	}
}
