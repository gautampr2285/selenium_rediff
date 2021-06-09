package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager {
	
	@Test
	
	public void Discount() {
		
		System.out.println("Applying Discount");
	}
	
	@Parameters({"action"})
	@Test
		
	public void Payment(String Option,ITestContext context) {
			
			if(Option.equals("Pay@hotel"))
				System.out.println("Making Payment at hotel");
			else 
				System.out.println("Making Instant Payment");
		
		String BookingID = "15234165";
		context.setAttribute("BookingNum", BookingID);
			
		}

}
