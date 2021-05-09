package system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Back_end {

	String c_reg_db ="C:\\Users\\16478\\Desktop\\eecs3311\\database\\c_reg_db.csv";  // Registered Customer database (c_reg_db.csv)
	String a_reg_db = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\a_reg_db.csv"; // Registered Administrator database (a_reg_db.csv)
	String o_reg_db = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\o_reg_db.csv"; // Registered Officer database (o_reg_db.csv)
	String temp = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\temp.csv";// A temporary file for deleting data
	String parking_db ="C:\\Users\\16478\\Desktop\\eecs3311\\database\\parking_db.csv";// Parking Spots database
	
	public boolean correct_email(String email)
	{
		if(email.contains("@") == true && email.contains("."))
				{
					return true;
				}
		return false;
	}
	public boolean cust_exists(String id, String pass)
	{	
		String cid=id;
		String cpass=pass;
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(c_reg_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(cid) && values[3].trim().equals(cpass))
			{
				br.close();
				return true;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}
	
	public boolean ofcr_exists(String id, String pass)
	{	
		String cid=id;
		String cpass=pass;
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(o_reg_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(cid) && values[3].trim().equals(cpass))
			{
				br.close();
				return true;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}
	
	public boolean admin_exists(String id, String pass)
	{	
		String cid=id;
		String cpass=pass;
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(a_reg_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[0].trim().equals(cid) && values[1].trim().equals(cpass))
			{
				br.close();
				return true;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}
	
	public boolean mpeo_already(String type, String email)
	{	
		String em = email;
		String temp ="";
		if(type.equals("officer") == true)
		{
			temp = o_reg_db;
		}
		String hold = "";
		
		try {
			FileReader fr = new FileReader(temp);
		BufferedReader br = new BufferedReader(fr);

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(em))
			{
				fr.close();
				br.close();
				return true;
			}
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return false;
	}
	
	public boolean O_UID_already_exists(String uid)
	{	
		String hold = "";
		String id = uid;
		try {
			FileReader fr = new FileReader(o_reg_db);
		BufferedReader br = new BufferedReader(fr);

		while((hold = br.readLine()) != null) {
			String values[] = hold.split(",");
			if(values[3].trim().equals(id))
			{
				fr.close();
				br.close();
				return true;
			}
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return false;
	}
	
	public boolean cust_already(String email)
	{	
		String hold = "";
		
		try {
			FileReader fr = new FileReader(c_reg_db);
		BufferedReader br = new BufferedReader(fr);

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(email))
			{
				fr.close();
				br.close();
				return true;
			}
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return false;
	}
	public boolean spot_exists(int spot)
	{	
		String spot_1 = String.valueOf(spot);
		String hold = "";
		
		try {
			FileReader fr = new FileReader(parking_db);
		BufferedReader br = new BufferedReader(fr);

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[0].trim().equals(spot_1))
			{
				if(values[5].equalsIgnoreCase("paid"))
				{
				fr.close();
				br.close();
				return false;
				}
			}
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return true;
	}
	
	public boolean card_true(String card)
	{
		int n= card.length();
		int[] c = new int[n];
		
		for(int i=0; i<n;i++)
		{
			c[i] = Integer.parseInt(card.substring(i, i+1));
		}
		
		for(int i=n-2; i>=0; i=i-2)
		{
			int temp = c[i];
			temp = temp * 2;
			if(temp > 10)
			{
				temp = ((temp % 10) +1);
			}
			c[i] = temp;
		}
		
		int sum = 0;
		for(int i=0; i<n;i++)
		{
			sum += c[i];
		}
		if(sum % 10 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public ArrayList<String> show_bookings(String id)
	{	
		ArrayList<String> table = new ArrayList<String>();
		String cid=id;
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(cid))
			{
				table.add(values[6]);
				table.add(values[4]);
				table.add(values[8]);
				table.add(values[1]);
				table.add(values[5]);
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		return table;
		
	}

	public boolean booking_exists(String Bid, String email)
	{	
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(email) && values[6].trim().equals(Bid))
			{
				br.close();
				return true;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}

	public boolean time_exists(String Bid, String email)
	{	
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(email) && values[6].trim().equals(Bid))
			{
				LocalTime now = LocalTime.now();
				LocalTime limit = LocalTime.parse( values[1] );
				Boolean isLate = now.isAfter( limit );
				if(isLate == false)
				{
				br.close();
				return true;
				}
				else
				{
					br.close();
					return false;
				}
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}

	public ArrayList<String> admin_show_bookings()
	{	
		ArrayList<String> table = new ArrayList<String>();
		String hold = ""; int n =0;
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(n > 0)
			{
				table.add(values[0]);//spot
				table.add(values[2]);//email
				table.add(values[8]);//DOB
				table.add(values[1]);//time
				table.add(values[5]);//status
			}
			n = n+1;	
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		return table;
		
	}

	public boolean o_booking_exists(String Bid)
	{	
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[0].trim().equals(Bid))
			{
				br.close();
				return true;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}

	public boolean o_time_exists(String Bid)
	{	
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[6].trim().equals(Bid))
			{
				LocalTime now = LocalTime.now();
				LocalTime limit = LocalTime.parse( values[1] );
				Boolean isLate = now.isAfter( limit );
				if(isLate == false)
				{
				br.close();
				return false;
				}
				else
				{
					br.close();
					return true;
				}
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	return false;
	}

	public boolean spot_exists_2(int spot)
	{	
		String spot_1 = String.valueOf(spot);
		String hold = "";
		
		try {
			FileReader fr = new FileReader(parking_db);
		BufferedReader br = new BufferedReader(fr);

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[0].equals(spot_1))
			{
				fr.close();
				br.close();
				return false;
			}
		}
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return true;
	}

	public ArrayList<String> officer_show_bookings(String id)
	{	
		ArrayList<String> table = new ArrayList<String>();
		String cid=id;
		String hold = "";
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[2].trim().equals(cid))
			{
				table.add(values[0]);//spot
				table.add(values[2]);//email
				table.add(values[8]);//DOB
				table.add(values[1]);//time
				table.add(values[5]);//status
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		return table;
		
	}
}
