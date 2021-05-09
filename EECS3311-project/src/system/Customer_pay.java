package system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Customer_pay {
	private static JFrame frame;
	private static JPanel pannel;
	
	Customer_pay()
	{
		frame = new JFrame("CUSTOMER_PAYMENT_PAGE");
		pannel = new JPanel();
	}
public void pay(String email, String vehicle,String spot1,String spot2,String spot3,String id1,String id2,String id3,String total,int hr1, int min1, int hr2
					,int min2, int hr3, int min3, int how_many)
	{
		String user = email;
		String v_num = vehicle;
		String spot_1= spot1;
		String spot_2 =spot2;
		String spot_3=spot3;
		String bid1 = id1;
		String bid2 =id2;
		String bid3 =id3;
		String Ptotal = total;
		int imp = how_many;
		pannel.setBackground(new Color(0, 255, 204));
		frame.setSize(500, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(pannel);
		pannel.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		JButton back = new JButton("BACK");
		back.setFont(new Font("Tahoma", Font.BOLD,20));
		back.setForeground(new Color(0, 0, 0));
		back.setBackground(UIManager.getColor("Button.background"));
		back.setBounds(304, 256, 152, 45);
		pannel.add(back);
		
		JLabel lblNewLabel = new JLabel("Payment Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(145, 10, 185, 31);
		pannel.add(lblNewLabel);
		
		JLabel lblPriceIs = new JLabel("Price is $3 per 30 mins.");
		lblPriceIs.setForeground(Color.RED);
		lblPriceIs.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPriceIs.setBounds(94, 51, 307, 31);
		pannel.add(lblPriceIs);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCardNumber.setBounds(37, 133, 185, 31);
		pannel.add(lblCardNumber);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date:");
		lblExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExpiryDate.setBounds(37, 174, 185, 31);
		pannel.add(lblExpiryDate);
		
		JLabel lblExpiryDate_1 = new JLabel("CVV: (3 digits)");
		lblExpiryDate_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExpiryDate_1.setBounds(37, 215, 185, 31);
		pannel.add(lblExpiryDate_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotal.setBounds(128, 92, 85, 31);
		pannel.add(lblTotal);
		
		JLabel Total = new JLabel(Ptotal);
		Total.setForeground(Color.RED);
		Total.setFont(new Font("Tahoma", Font.BOLD, 25));
		Total.setBounds(232, 92, 245, 31);
		pannel.add(Total);
		
		JTextField card = new JTextField();
		card.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card.setBounds(232, 133, 224, 31);
		pannel.add(card);
		card.setColumns(10);
		
		JTextField card_D = new JTextField();
		card_D.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card_D.setText("DD-MM-YY");
		card_D.setColumns(10);
		card_D.setBounds(232, 174, 224, 31);
		pannel.add(card_D);
		
		JTextField card_C = new JTextField();
		card_C.setFont(new Font("Tahoma", Font.PLAIN, 19));
		card_C.setColumns(10);
		card_C.setBounds(232, 215, 224, 31);
		pannel.add(card_C);
		
		JButton pay = new JButton("PAY");
		pay.setForeground(Color.BLACK);
		pay.setFont(new Font("Tahoma", Font.BOLD, 20));
		pay.setBackground(UIManager.getColor("Button.background"));
		pay.setBounds(59, 256, 152, 45);
		pannel.add(pay);
		
		JLabel lblTotal_1_1 = new JLabel("$");
		lblTotal_1_1.setForeground(Color.RED);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotal_1_1.setBounds(211, 92, 20, 31);
		pannel.add(lblTotal_1_1);
		
		//button actions
		
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back_end be = new Back_end();
				Back_end_2 be2 = new Back_end_2();
				boolean card_check = be.card_true(card.getText());
				
				if(card_check == true)
				{
					if(card_C.getText().length() == 3)
					{
						
						if(imp == 1)
						{
							Calendar cl = Calendar.getInstance();
							cl.add(Calendar.HOUR, hr1);
							cl.add(Calendar.MINUTE, min1);
							String s = String.valueOf(cl.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl.get(Calendar.MINUTE));
							be2.spot_add(spot_1, s, user, card.getText(), v_num, "not paid", bid1, "Online");
							JOptionPane.showMessageDialog(null,"Booking ID Spot" + spot_1 +" -->" +bid1,"Spot Booked",JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							Customer_ops co = new Customer_ops();
							co.options(email);
						}
					else if(imp == 2 )
						{
							Calendar cl = Calendar.getInstance();
							cl.add(Calendar.HOUR, hr1);
							cl.add(Calendar.MINUTE, min1);
							String s = String.valueOf(cl.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl.get(Calendar.MINUTE));
							be2.spot_add(spot_1, s, user, card.getText(), v_num, "not paid", bid1, "Online");
							Calendar cl2 = Calendar.getInstance();
							cl2.add(Calendar.HOUR, hr2);
							cl2.add(Calendar.MINUTE, min2);
							String s2 = String.valueOf(cl2.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl2.get(Calendar.MINUTE));
							be2.spot_add(spot_2, s2, user, card.getText(), v_num, "not paid", bid2, "Online");
							JOptionPane.showMessageDialog(null,"Booking ID Spot" + spot_1 +" -->" +bid1 +"\n"+""
									+ "Booking ID Spot" + spot_2 +" -->" +bid2 +"\n","Spots Booked",JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							Customer_ops co = new Customer_ops();
							co.options(email);
							
						
						}
						else
						{
							Calendar cl = Calendar.getInstance();
							cl.add(Calendar.HOUR, hr1);
							cl.add(Calendar.MINUTE, min1);
							String s = String.valueOf(cl.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl.get(Calendar.MINUTE));
							be2.spot_add(spot_1, s, user, card.getText(), v_num, "not paid", bid1, "Online");
							Calendar cl2 = Calendar.getInstance();
							cl2.add(Calendar.HOUR, hr2);
							cl2.add(Calendar.MINUTE, min2);
							String s2 = String.valueOf(cl2.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl2.get(Calendar.MINUTE));
							be2.spot_add(spot_2, s2, user, card.getText(), v_num, "not paid", bid2, "Online");
							Calendar cl3 = Calendar.getInstance();
							cl3.add(Calendar.HOUR, hr3);
							cl3.add(Calendar.MINUTE, min3);
							String s3 = String.valueOf(cl3.get(Calendar.HOUR_OF_DAY)) + ":" +String.valueOf(cl3.get(Calendar.MINUTE));
							be2.spot_add(spot_3, s3, user, card.getText(), v_num, "not paid", bid3, "Online");
							JOptionPane.showMessageDialog(null,"Booking ID Spot" + spot_1 +" -->" +bid1 +" "+"\n"+" "
									+ "Booking ID Spot" + spot_2 +" -->" +bid2 +" " +"\n"
									+ "Booking ID Spot" + spot_3 +" -->" +bid3 +"\n",
									"Spots Booked",JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							Customer_ops co = new Customer_ops();
							co.options(email);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid CVV.(3 digits)","Error",JOptionPane.INFORMATION_MESSAGE);
					}
					
					}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Credit card.","Error",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Customer_Book_2 cb2 = new Customer_Book_2();
				int hrr1 = hr1;
				int minn = min1;
				int spot = Integer.parseInt(spot_1);
				cb2.book_2(user, v_num, spot,hrr1, minn);
			}
		});
	}
}
