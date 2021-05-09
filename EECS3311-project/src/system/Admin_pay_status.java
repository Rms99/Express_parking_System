package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class Admin_pay_status {
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JTable table;
	
	Admin_pay_status()
	{
		frame = new JFrame("Admin Change Status");
		pannel = new JPanel();
		status();
	}
	
	public void status()
	{
		JTable table = new JTable();
		Object[] Columns = {"Spot number", "Email", "Date of Booking", "Expiry Time", "Payment Status"};
		DefaultTableModel model = new DefaultTableModel();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 1132, 610);
		frame.getContentPane().setLayout(null);
		
		
		model.setColumnIdentifiers(Columns);
		table.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionForeground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN,17));
		table.setRowHeight(30);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.red);
		pane.setBackground(Color.white);
		pane.setBounds(289, 10, 819, 515);
		frame.getContentPane().add(pane);
		
		JButton Back = new JButton("Back");
		
		Back.setFont(new Font("Tahoma", Font.BOLD, 20));
		Back.setBounds(0, 537, 141, 36);
		frame.getContentPane().add(Back);
		
		JLabel Heading = new JLabel("Change Status");
		Heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		Heading.setForeground(Color.BLACK);
		Heading.setBounds(10, 10, 228, 65);
		frame.getContentPane().add(Heading);
		
		JButton refresh = new JButton("Refresh");
		refresh.setFont(new Font("Tahoma", Font.BOLD, 20));
		refresh.setBounds(10, 375, 269, 65);
		frame.getContentPane().add(refresh);
		
		JLabel lblNewLabel = new JLabel("Click The Refresh Button to ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 438, 317, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel S = new JLabel("Spot:");
		S.setFont(new Font("Tahoma", Font.BOLD, 20));
		S.setBounds(10, 85, 59, 36);
		frame.getContentPane().add(S);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(10, 151, 91, 36);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JTextField Spot = new JTextField();
		Spot.setColumns(10);
		Spot.setBounds(79, 85, 200, 36);
		frame.getContentPane().add(Spot);
		
		JTextField email = new JTextField();
		email.setColumns(10);
		email.setBounds(79, 151, 200, 36);
		frame.getContentPane().add(email);
		
		JLabel lblTheTable = new JLabel("update the table");
		lblTheTable.setForeground(Color.BLUE);
		lblTheTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTheTable.setBounds(10, 466, 317, 36);
		frame.getContentPane().add(lblTheTable);
		
		JButton Change = new JButton("Change");
		Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Change.setFont(new Font("Tahoma", Font.BOLD, 20));
		Change.setBounds(10, 197, 269, 70);
		frame.getContentPane().add(Change);
		
		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Tahoma", Font.BOLD, 20));
		clear.setBounds(10, 292, 269, 70);
		frame.getContentPane().add(clear);
		
		JLabel lblRequestedSpotsTable = new JLabel("Requested spots table.");
		lblRequestedSpotsTable.setForeground(new Color(0, 0, 255));
		lblRequestedSpotsTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequestedSpotsTable.setBounds(605, 527, 317, 36);
		frame.getContentPane().add(lblRequestedSpotsTable);
		
		Object[] row = new Object[6];
		
		
		frame.setVisible(true);
		//pannel.add(table);
		
		//Button actions below
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Admin_main am = new Admin_main();
				am.admin_mp();
			}
		});
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = model.getRowCount();
				for(int i= n -1;i>=0;i--)
				{
					model.removeRow(i);
				}
			}
		});
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.revalidate();
				int n = model.getRowCount();
				for(int i= n -1;i>=0;i--)
				{
					model.removeRow(i);
				}
				Back_end be = new Back_end();
				ArrayList<String> values = new ArrayList<String>();
				values = be.admin_show_bookings();
				String items[] = values.toArray(new String[0]);
				for(int i=0; i<values.size();i=i+5)
				{
					row[0] = items[i];
					row[1] = items[i+1];
					row[2] = items[i+2];
					row[3] = items[i+3];
					row[4] = items[i+4];
					model.addRow(row);
				}
			}
		});
		Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.revalidate();
				Back_end_2 be2 = new Back_end_2();
				Back_end be = new Back_end();
				if(Spot.getText().isBlank() || email.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null,"Empty Blank Submitted","Empty Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.cust_already(email.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"Wrong email","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.spot_exists_2(Integer.parseInt(Spot.getText())))
				{
					JOptionPane.showMessageDialog(null,"Wrong Spot","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
				be2.pay_status(Spot.getText(), email.getText());
				JOptionPane.showMessageDialog(null,"Hit the refresh button.","Sucess",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		}
}
