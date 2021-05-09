package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Customer_viewB {
	
	private static JFrame frame;
	private static JPanel pannel;
	private static JButton back;
	private JTable table;
	Customer_viewB()
	{
		frame = new JFrame("CUSTOMER_VIEW_BOOKINGS_TABLE");
		pannel = new JPanel();
		//view();
	}
	
	public void view(String current_user) {	
	JTable table = new JTable();
	Object[] Columns = {"Booking ID", "Vehicle NUmber", "Date of Booking", "Expiry Time", "Payment Status"};
	DefaultTableModel model = new DefaultTableModel();
	frame.getContentPane().setBackground(new Color(0, 255, 204));
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setBounds(100, 100, 888, 610);
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
	pane.setBounds(10, 115, 723, 402);
	frame.getContentPane().add(pane);
	
	JButton Back = new JButton("Back");
	
	Back.setFont(new Font("Tahoma", Font.BOLD, 20));
	Back.setBounds(10, 527, 141, 36);
	frame.getContentPane().add(Back);
	
	JLabel Heading = new JLabel("Record of Bookings");
	Heading.setFont(new Font("Tahoma", Font.BOLD, 45));
	Heading.setForeground(Color.BLACK);
	Heading.setBounds(142, 21, 437, 65);
	frame.getContentPane().add(Heading);
	
	JButton refresh = new JButton("Refresh");
	refresh.setFont(new Font("Tahoma", Font.BOLD, 20));
	refresh.setBounds(743, 115, 120, 402);
	frame.getContentPane().add(refresh);
	
	JLabel lblNewLabel = new JLabel("Click The Refresh Button to update the table.");
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel.setBounds(447, 527, 416, 36);
	frame.getContentPane().add(lblNewLabel);
	
	Object[] row = new Object[5];
	
	
	frame.setVisible(true);
	//pannel.add(table);
	
	//Button actions below
	Back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Customer_ops o = new Customer_ops();
			o.options(current_user);
		}
	});
	refresh.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int n = model.getRowCount();
			for(int i= n -1;i>=0;i--)
			{
				model.removeRow(i);
			}
			frame.revalidate();
			Back_end be = new Back_end();
			ArrayList<String> values = new ArrayList<String>();
			values = be.show_bookings(current_user);
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
	
	}
}
