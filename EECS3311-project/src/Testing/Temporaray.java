package Testing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import system.Back_end;

public class Temporaray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Back_end Be = new Back_end();
		String temp = "C:\\Users\\16478\\Desktop\\eecs3311\\database\\temp.csv";// A temporary file for deleting data
		String parking_db ="C:\\Users\\16478\\Desktop\\eecs3311\\database\\parking_db.csv";// Parking Spots database
		String Bid = "1000001";
		String hold = "";
		int counter =0;
		try {
		BufferedReader br = new BufferedReader(new FileReader(parking_db));

		while((hold = br.readLine()) != null) {
			String[] values = hold.split(",");
			if(values[0].equals(Bid) == true)
			{
				counter = 1;
			}
		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	if(counter ==0 )
	{
	System.out.println("false");
	}
	else
	{
		System.out.println("true");
	}
	}

}
