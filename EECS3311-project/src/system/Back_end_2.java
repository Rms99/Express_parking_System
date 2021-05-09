package system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Back_end_2 {
	String c_reg_db ="C:\\Users\\16478\\Desktop\\eecs3311\\database\\c_reg_db.csv";  // Registered Customer database (c_reg_db.csv)
	String a_reg_db = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\a_reg_db.csv"; // Registered Administrator database (a_reg_db.csv)
	String o_reg_db = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\o_reg_db.csv"; // Registered Officer database (o_reg_db.csv)
	String temp = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\temp.csv";// A temporary file for deleting data
	String parking_db ="C:\\Users\\16478\\Desktop\\eecs3311\\database\\parking_db.csv";// Parking Spots database
	
	Back_end be = new Back_end();
	public boolean mpeo_delete(String type, String email)
	{
		if(be.mpeo_already(type,email) == false)
		{
			return false;
		}
		else
		{
			File oldFile = new File(o_reg_db);
			File newFile = new File(temp);
			String hold = "";

			try {
			FileReader fr = new FileReader(oldFile);	
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(temp,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			while((hold = br.readLine()) != null) {
				String[] values = hold.split(",");
				if(!values[2].trim().equals(email))
				{
					pw.println(values[0] + "," +values[1] + "," +values[2] + "," +values[3] + ",");
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			oldFile.delete();
			File newname = new File(o_reg_db);
			newFile.renameTo(newname);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		return true;
	}
	
	public int mpeo_add(String fname, String lname, String email, String uid)
	{
		if(be.O_UID_already_exists(uid) == true)
		{
			return 0;
		}
		else if(be.mpeo_already("officer", email) == true)
		{
			return 1;
		}
		else
		{

			try {
			FileWriter fw = new FileWriter(o_reg_db,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
				
			pw.println(fname + "," +lname + "," +email + "," +uid + ",");
			
			pw.flush();
			pw.close();
			bw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		return 2;
	}

	public int cust_add(String fname, String lname, String email, String password)
	{
		if(be.cust_already(email) == true)
		{
			return 0;
		}
		else
		{

			try {
			FileWriter fw = new FileWriter(c_reg_db,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
				
			pw.println(fname + "," +lname + "," +email + "," +password + ",");
			
			pw.flush();
			pw.close();
			bw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		}
		return 2;
	}

	public void spot_add(String spot, String time, String email, String card_number, String vehicle, String status, String ID, String type )
	{
		Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
        String td = dateFormat.format(date); 
			try {
			FileWriter fw = new FileWriter(parking_db,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
				
			pw.println(spot + "," +time + "," +email + "," +card_number + "," +vehicle+ "," +status+ "," +ID+ "," +type + "," + td + ",");
			
			pw.flush();
			pw.close();
			bw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean delete_booking(String id, String email)
	{
			File oldFile = new File(parking_db);
			File newFile = new File(temp);
			String hold = "";

			try {
			FileReader fr = new FileReader(oldFile);	
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(temp,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			while((hold = br.readLine()) != null) {
				String[] values = hold.split(",");
				if(!values[6].trim().equals(id) )
				{  
					pw.println(values[0] + "," +values[1] + "," +values[2] + "," +values[3] + ","+values[4] + ","+values[5] + ","+values[6] 
							+ ","+values[7] + ","+values[8] + ",");
				}
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			br.close();
			oldFile.delete();
			File newname = new File(parking_db);
			newFile.renameTo(newname);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean pay_status(String pspot, String mail)
	{
			File oldFile = new File(parking_db);
			File newFile = new File(temp);
			String hold="";
			try {
				FileReader fr = new FileReader(oldFile);	
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(temp,true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
			while((hold = br.readLine()) != null) 
			{
				String[] values = hold.split(",");
				String spot = values[0];String time = values[1];
				String email = values[2];String credit = values[3];
				String V_num = values[4];String stat = values[5];
				String id = values[6];String type = values[7]; String dob = values[8];
				
				if(spot.equals(pspot))
				{
					if(email.equals(mail))
					{
						if(stat.equalsIgnoreCase("paid"))
						{
							pw.println(spot + "," + time+ "," + email+ "," + credit+ "," + V_num + "," + "not paid" + "," + id+ "," + type +"," + dob);
						}
						else
						{
							pw.println(spot + "," + time+ "," + email+ "," + credit+ "," + V_num + "," + "paid" + "," + id+ "," + type +"," + dob);
						}
					}
					else
					{
						pw.println(spot + "," + time+ "," + email+ "," + credit+ "," + V_num + "," + stat + "," + id+ "," + type +"," + dob);
					}
				}
				else
				{
					pw.println(spot + "," + time+ "," + email+ "," + credit+ "," + V_num + "," + stat + "," + id+ "," + type + "," + dob);
				}
				
			}
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			oldFile.delete();
			File newname = new File(parking_db);
			newFile.renameTo(newname);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean o_delete_booking(String pspot)
	{
		File oldFile = new File(parking_db);
		File newFile = new File(temp);
		String hold="";
		try {
			FileReader fr = new FileReader(oldFile);	
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(temp,true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
		while((hold = br.readLine()) != null) 
		{
			String[] values = hold.split(",");
			String spot = values[0];String time = values[1];
			String email = values[2];String credit = values[3];
			String V_num = values[4];String stat = values[5];
			String id = values[6];String type = values[7]; String dob = values[8];
			
			if(spot.equals(pspot))
			{
				pw.println(spot+"(Expired)" + "," + time+ "," + email+ "," + credit+ "," + V_num + "," + stat + "," + id+ "," + type + "," + dob);
			}
			else
			{
				pw.println(spot+  "," + time+ "," + email+ "," + credit+ "," + V_num + "," + stat + "," + id+ "," + type + "," + dob);
			}
			
		}
		pw.flush();
		pw.close();
		fr.close();
		br.close();
		bw.close();
		fw.close();
		oldFile.delete();
		File newname = new File(parking_db);
		newFile.renameTo(newname);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
	return true;
	}

}
