package runner;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CustomTestNgRunner runner = new CustomTestNgRunner(1);
		runner.createSuite("Booking Suite", false);
		runner.AddTest("Create Booking-Without discount");
		runner.AddTestParam("action", "Without-discount");
		
		List<String> inlcudeMethodsnames = new ArrayList<String>();
		inlcudeMethodsnames.add("SearchHotel");
		inlcudeMethodsnames.add("SelectHotel");
		inlcudeMethodsnames.add("EnterGuestInfo");
		runner.AddTestClass("testcases.BookingHotel", inlcudeMethodsnames);
		
		inlcudeMethodsnames = new ArrayList<String>();
		inlcudeMethodsnames.add("Payment");
		runner.AddTestClass("testcases.PaymentManager", inlcudeMethodsnames);
		
		inlcudeMethodsnames = new ArrayList<String>();
		inlcudeMethodsnames.add("checkMail");
		runner.AddTestClass("testcases.CustomerCommunication", inlcudeMethodsnames);
		
		runner.run();
	}

}
