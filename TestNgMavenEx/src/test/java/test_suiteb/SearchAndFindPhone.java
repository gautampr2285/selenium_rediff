package test_suiteb;

import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.Test;
 
public class SearchAndFindPhone {
	
	//boolean flag = true;
	@Test(priority = 1)
	//ITestContext is used to pass value in the test case.
	//test case within the same class can share the data very easily.
	
	public void search(ITestContext context) {
		/*if(flag=true) {
			throw new SkipException("Skipping Test");
		}*/
		System.out.println("Searching Phone");
		context.setAttribute("PhoneName", "OnePlus7 Pro");
		}
	
	@Test(priority = 2)
	public void selectphone(ITestContext context) {
		
		String name = (String) context.getAttribute("PhoneName");
		System.out.println("Selecting Phone"+name);
		
	}
	
	@Test(priority = 3)
	
	public void Checkout() {
		
		System.out.println("Checking Out");
		
	}
	
	
	

}
