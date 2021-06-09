package testRediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import keywords.ApplicationKeyword;
import testBase.BaseTest;

public class Session extends BaseTest {
	
	@Test
	
	public void dologin(){
		
		//System.out.println("Do-Login");
		test.log(Status.INFO, "Logging In");
		//i=100;
		//con.setAttribute("i_val", i);
		apps.openbrowser("Chrome");
		//apps.reportFailure("Error in opening Broswer",false);
		apps.navigate("url");
		//int i =100/0;
		apps.type("user_name_xpath", "ashishthakur1983");
		apps.type("password_id", "pass@1234");
		apps.click("login_button_xpath");
			
	}
	
	@Test
	
	public void DoLogOut() {
		
		System.out.println("Do-Logout");
	}

}
