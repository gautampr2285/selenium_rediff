package testcase;

import org.testng.annotations.Test;

import keywords.ApplicationKeyword;


public class CreatePortfolio extends ApplicationKeyword {
	
	@Test
	
	public void createPortfolio() {
		
		ApplicationKeyword app = new ApplicationKeyword();
		
		app.openbrowser("Chrome");
		app.navigate("url");
		app.type("user_name_xpath", "ashishthakur1983");
		app.type("password_id", "pass@1234");
		app.click("login_button_xpath");
	}

}
