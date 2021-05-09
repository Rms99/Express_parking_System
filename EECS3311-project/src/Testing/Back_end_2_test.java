package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import system.Back_end;
import system.Back_end_2;

public class Back_end_2_test {

	int counter = (int) (Math.random()*100000);
	String s = String.valueOf(counter) + "@test.com";
	
	//Back_end_2 class test cases
	@Test
	public void test1() {
		Back_end_2 be2 = new Back_end_2();
		int z = be2.mpeo_add("Fname", "Lname", "abc123@gmail.com", "221");
		assertEquals(0,z);
	}
	@Test
	public void test2() {
		Back_end_2 be2 = new Back_end_2();
		int z = be2.mpeo_add("Fname", "Lname", "mr99@gmail.com", "1001");
		assertEquals(1,z);
	}
	
	@Test
	public void test3() {
		Back_end_2 be2 = new Back_end_2();		
		int z = be2.mpeo_add("Testing", "Testing", s, String.valueOf(counter));
			assertEquals(2,z);
		
	}
	@Test
	public void test4() {
		Back_end_2 be2 = new Back_end_2();		
		int t = be2.mpeo_add("Testing", "Testing", "testing@gmail.com", "test101");
		assertEquals(2,t);
		boolean z = be2.mpeo_delete("officer","testing@gmail.com");
			assertEquals(true,z);
	}
	@Test
	public void test5() {
		Back_end_2 be2 = new Back_end_2();
		boolean z = be2.mpeo_delete("officer","00000000");
			assertEquals(false,z);
	}
	
	@Test
	public void test_cust_add_1() {
		Back_end_2 be2 = new Back_end_2();
		int z = be2.cust_add("test","test",s,String.valueOf(counter));
			assertEquals(2,z);
	}
	
	@Test
	public void test_cust_add_2() {
		Back_end_2 be2 = new Back_end_2();
		int z = be2.cust_add("test","test","abc@gmail.com",String.valueOf(counter));
			assertEquals(0,z);
	}
	
	@Test
	public void test_spot_add_and_delete() {
		Back_end_2 be2 = new Back_end_2();
		be2.spot_add("Test", "Test", "Test1234@gmail.com", "Test", "Test", "Test", "test001", "test");
		boolean z = be2.delete_booking("Test1234@gmail.com", "test001");
			assertEquals(true,z);
	}
	
	@Test
	public void test_spot_add_and_delete2() {
		Back_end_2 be2 = new Back_end_2();
		be2.spot_add("Test", "Test", "Test1234@gmail.com", "Test", "Test", "Test", "test001", "test");
		boolean z = be2.delete_booking("Test1234@gmail.com", "test001");
			assertEquals(true,z);
	}
	
	@Test
	public void test_spot_pay_status() {
		Back_end_2 be2 = new Back_end_2();
		boolean z = be2.pay_status("check", "check001@gmail.com");
			assertEquals(true,z);
	}
	
	@Test
	public void test_spot_pay_status1() {
		Back_end_2 be2 = new Back_end_2();
		boolean z = be2.pay_status("check", "check001@gmail.com");
			assertEquals(true,z);
	}
	
	@Test
	public void test_o_delete_booking() {
		Back_end_2 be2 = new Back_end_2();
		be2.spot_add("Test-o", "Test-o", "Test1234@gmail.com", "Test-o", "Test-o", "Test-o", "test001-o", "test-o");
		boolean z = be2.o_delete_booking("Test-o");
			assertEquals(true,z);
	}
	
	@Test
	public void test_o_delete_booking_2() {
		Back_end_2 be2 = new Back_end_2();
		be2.spot_add("Test-o1", "Test-o1", "Test1234@gmail.com", "Test-o1", "Test-o1", "Test-o1", "test001-o1", "test-o1");
		boolean z = be2.o_delete_booking("Test-o1");
			assertEquals(true,z);
	}
	
	//Back_end class test cases
	
	@Test
	public void test_correct_email_1() {
		Back_end be = new Back_end();
		boolean z = be.correct_email("1234@gmail.com");
			assertEquals(true,z);
	}
	
	@Test
	public void test_correct_email_2() {
		Back_end be = new Back_end();
		boolean z = be.correct_email("1234");
			assertEquals(false,z);
	}

	@Test
	public void test_cust_exists_1() {
		Back_end be = new Back_end();
		boolean z = be.cust_exists("xyz@gmail.com", "1234");
			assertEquals(true,z);
	}
	
	@Test
	public void test_cust_exists_2() {
		Back_end be = new Back_end();
		boolean z = be.cust_exists("tumtutjsj", "sdfghjhghhj");
			assertEquals(false,z);
	}
	
	@Test
	public void test_offcr_exists_1() {
		Back_end be = new Back_end();
		boolean z = be.ofcr_exists("tumtutjsj", "sdfghjhghhj");
			assertEquals(false,z);
	}
	
	@Test
	public void test_offcr_exists_2() {
		Back_end be = new Back_end();
		boolean z = be.ofcr_exists("hui@gmail.com", "2001");
			assertEquals(true,z);
	}
	
	@Test
	public void test_admin_exists_1() {
		Back_end be = new Back_end();
		boolean z = be.admin_exists("tumtutjsj", "sdfghjhghhj");
			assertEquals(false,z);
	}
	
	@Test
	public void test_admin_exists_2() {
		Back_end be = new Back_end();
		boolean z = be.admin_exists("A-100", "eecs3311");
			assertEquals(true,z);
	}
	
	@Test
	public void test_mpeo_already_1() {
		Back_end be = new Back_end();
		boolean z = be.mpeo_already("officer", "sdfghjhghhj");
			assertEquals(false,z);
	}
	
	@Test
	public void test_mpeo_already_2() {
		Back_end be = new Back_end();
		boolean z = be.mpeo_already("officer", "hui@gmail.com");
			assertEquals(true,z);
	}
	
	@Test
	public void test_o_UID_1() {
		Back_end be = new Back_end();
		boolean z = be.O_UID_already_exists("2001");
			assertEquals(true,z);
	}
	
	@Test
	public void test_o_UID_2() {
		Back_end be = new Back_end();
		boolean z = be.O_UID_already_exists("asdfoiuy");
			assertEquals(false,z);
	}
	
	@Test
	public void test_spot_exists_1() {
		Back_end be = new Back_end();
		boolean z = be.spot_exists(223);
			assertEquals(false,z);
	}
	
	@Test
	public void test_spot_exists_2() {
		Back_end be = new Back_end();
		boolean z = be.spot_exists(2000000000);
			assertEquals(true,z);
	}
	
	@Test
	public void test_card_true_1() {
		Back_end be = new Back_end();
		boolean z = be.card_true("378282246999999988888888888666666666");
			assertEquals(false,z);
	}
	
	@Test
	public void test_card_true_2() {
		Back_end be = new Back_end();
		boolean z = be.card_true("378282246310005");
			assertEquals(true,z);
	}
	
	@Test
	public void test_show_bookings_1() {
		Back_end be = new Back_end();
		
		ArrayList<String> test1 = new ArrayList<String>();
		ArrayList<String> test2 = new ArrayList<String>();
		test1.add("B_ID");
		test1.add("V_num");
		test1.add("DOB");
		test1.add("Exp_time");
		test1.add("Pay_stat");
		test2 = be.show_bookings("email");
			assertEquals(test1,test2);
	}
	@Test
	public void test_admin_show_bookings_1() {
		Back_end be = new Back_end();
		
		ArrayList<String> test1 = new ArrayList<String>();
		ArrayList<String> test2 = new ArrayList<String>();
		test1 = be.admin_show_bookings();
		test2 = be.admin_show_bookings();
			assertEquals(test1,test2);
	}
	
	@Test
	public void test_booking_exists() {
		Back_end be = new Back_end();
		boolean test2;
		test2 = be.booking_exists("B_ID", "email");
			assertEquals(true,test2);
	}
	
	@Test
	public void test_booking_exists_2() {
		Back_end be = new Back_end();
		boolean test2;
		test2 = be.booking_exists("B_D", "eml");
			assertEquals(false,test2);
	}

	@Test
	public void test_admin_show_bookings_2() {
		Back_end be = new Back_end();
		
		ArrayList<String> test1 = new ArrayList<String>();
		ArrayList<String> test2 = new ArrayList<String>();
		test1 = be.admin_show_bookings();
		test2 = be.admin_show_bookings();
		Object[] test_1 = test1.toArray(); 
		Object[] test_2 = test2.toArray(); 
			assertEquals(test_1[1],test_2[1]);
	}
	
	@Test
	public void test_officer_show_bookings_1() {
		Back_end be = new Back_end();
		
		ArrayList<String> test1 = new ArrayList<String>();
		ArrayList<String> test2 = new ArrayList<String>();
		test1 = be.officer_show_bookings("email");
		test2 = be.officer_show_bookings("email");
			assertEquals(test1,test2);
	}
	
	@Test
	public void test_officer_show_bookings_2() {
		Back_end be = new Back_end();
		
		ArrayList<String> test1 = new ArrayList<String>();
		ArrayList<String> test2 = new ArrayList<String>();
		test1 = be.officer_show_bookings("email");
		test2 = be.officer_show_bookings("email");
		Object[] test_1 = test1.toArray(); 
		Object[] test_2 = test2.toArray(); 
			assertEquals(test_1[1],test_2[1]);
	}
	
	@Test
	public void test_officer_spot_exists_1() {
		Back_end be = new Back_end();
		boolean test2 = be.spot_exists_2(10000);
			assertEquals(true,test2);
	}
	
	@Test
	public void test_officer_spot_exists_2() {
		Back_end be = new Back_end();
		boolean test2 = be.spot_exists_2(123456789);
		
			assertEquals(false,test2);
	}

	@Test
	public void test_officer_spot_exists_3() {
		Back_end be = new Back_end();
		boolean test2 = be.o_booking_exists("100000");
		
			assertEquals(true,test2);
	}
	
	@Test
	public void test_officer_spot_exists_4() {
		Back_end be = new Back_end();
		boolean test2 = be.o_booking_exists("1000001111");
		
			assertEquals(false,test2);
	}
	
	@Test
	public void test_time_exists_4() {
		Back_end be = new Back_end();
		boolean test2 = be.time_exists("2:30:00 PM", "abc@gmail.com");
		if(test2 == false)
		{
			assertEquals(false,test2);
		}
		else
		{
			assertEquals(true,test2);
		}
	}

}

