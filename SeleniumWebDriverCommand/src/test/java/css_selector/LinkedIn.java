package css_selector;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class LinkedIn extends TestBase {
	
	@Test
	public void linkedin() {
		WebDriver driver = launchbrowser("Chrome");
		driver.get("https://in.linkedin.com/");
		driver.get("https://www.linkedin.com/login?fromSignIn=true&session_redirect=https%3A%2F%2Fin.linkedin.com%2Fjobs&trk=guest_homepage-jobseeker_nav-header-signin");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//WebElement text = driver.findElement(By.xpath("html/body/div/main/div[2]/div[1]/div[1]/p"));
		//System.out.println(text);
		//WebElement username = driver.findElement(By.id("username"));
		//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("abc");
		driver.findElement(By.cssSelector("input#username")).sendKeys("abc");
		//username.sendKeys("abc");
	}
	

}
