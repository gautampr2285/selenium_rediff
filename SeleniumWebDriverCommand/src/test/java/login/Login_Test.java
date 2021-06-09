package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class Login_Test extends TestBase{
	
	@Test
	
	public void login() {
		WebDriver driver = launchbrowser("Chrome"); 
		driver.get("https://www.linkedin.com/login?fromSignIn=true&session_redirect=https%3A%2F%2Fin.linkedin.com%2Fjobs&trk=guest_homepage-jobseeker_nav-header-signin");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("abc");
	}

}
