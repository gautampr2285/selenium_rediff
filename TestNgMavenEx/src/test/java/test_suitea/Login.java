package test_suitea;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	@BeforeTest
	
	public void InitializeBrowser() {
		
		System.out.println("-------@Before Test@@-----");
	}
	
	@AfterTest
	
	public void CloseBrowser() {
		
		System.out.println("------@@AFter Test@@@------");
	}
	
	@BeforeMethod
	public void Before_Method() {
		System.out.println("-------@Before Method@@-----");
	}
	
	@AfterMethod
	public void After_Method() {
		System.out.println("-------@After Method@@-----");
	}
	
	@Test
	
	public void doLogin() {
		String expectedResult = "ABC";
		String actualResult = "ABC";
		
		Assert.assertEquals(expectedResult, actualResult);
		//Assert.assertTrue(5<2, "Fail condition");
		//Assert.fail("Custom Messgae");
	}
	
	@Test
	public void logout() {
		
		System.out.println("Logout");
	}

}
