package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CustomerCommunication {
	
	@Test
	
	public void checkMail(ITestContext context) {
		
		System.out.println("Checking Mail for Confirmation");
		String BookingID = (String) context.getAttribute("BookingNum");
		System.out.println("Booking Number is "+BookingID);
	}

}
