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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Officer_view {

	
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JTable table;
	Officer_view()
	{
		frame = new JFrame("Admin Change Status");
		pannel = new JPanel();
		view();
	}
	
	
	
	public void view()
	{
		JTable table = new JTable();
		Object[] Columns = {"Spot number", "Email", "Date of Booking", "Expiry Time", "Payment Status"};
		DefaultTableModel model = new DefaultTableModel();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
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
		
		JButton refresh = new JButton("View all Spots.");
		refresh.setFont(new Font("Tahoma", Font.BOLD, 20));
		refresh.setBounds(10, 227, 269, 100);
		frame.getContentPane().add(refresh);
		
		JLabel lblNewLabel = new JLabel("Click The View all Button to");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 438, 317, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(10, 71, 91, 36);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JTextField email = new JTextField();
		email.setColumns(10);
		email.setBounds(89, 71, 192, 36);
		frame.getContentPane().add(email);
		
		JLabel lblTheTable = new JLabel("update the table");
		lblTheTable.setForeground(Color.BLUE);
		lblTheTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTheTable.setBounds(10, 466, 317, 36);
		frame.getContentPane().add(lblTheTable);
		
		JButton Cus_details = new JButton("Customer Details");
		Cus_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Cus_details.setFont(new Font("Tahoma", Font.BOLD, 20));
		Cus_details.setBounds(10, 117, 269, 100);
		frame.getContentPane().add(Cus_details);
		
		JButton clear = new JButton("Clear");
		clear.setFont(new Font("Tahoma", Font.BOLD, 20));
		clear.setBounds(10, 337, 269, 100);
		frame.getContentPane().add(clear);
		
		JLabel lblRequestedSpotsTable = new JLabel("Data Table");
		lblRequestedSpotsTable.setForeground(new Color(0, 0, 255));
		lblRequestedSpotsTable.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRequestedSpotsTable.setBounds(666, 527, 141, 36);
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
		Cus_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.revalidate();
				Back_end_2 be2 = new Back_end_2();
				Back_end be = new Back_end();
				if(email.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null,"Empty Blank Submitted","Empty Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(be.cust_already(email.getText()) == false)
				{
					JOptionPane.showMessageDialog(null,"Wrong email","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					frame.revalidate();
					int n = model.getRowCount();
					for(int i= n -1;i>=0;i--)
					{
						model.removeRow(i);
					}
					ArrayList<String> values = new ArrayList<String>();
					values = be.officer_show_bookings(email.getText());
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
			}
		});
		
		}
}

