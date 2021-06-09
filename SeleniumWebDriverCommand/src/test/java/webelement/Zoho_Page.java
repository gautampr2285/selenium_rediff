package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.TestBase;

public class Zoho_Page extends TestBase{
	
	@Test
	public void ZohoLogin() throws InterruptedException {
		
		
		WebDriver driver = launchbrowser("Chrome");
		driver.get("https://www.zoho.com/signup.html");
		//Thread.sleep(5000);
		//Boolean b = driver.findElement(By.xpath("//span[@id='signup-termservice']")).isEnabled();
		//System.out.println(b);
		Boolean b1 = driver.findElement(By.xpath("//input[@id='tos']")).isEnabled();
		System.out.println(b1);
		//driver.findElement(By.xpath("//span[@id='signup-termservice']")).click();
		
		int i = 1;
		
		while(i<=10) {
			if(driver.findElement(By.xpath("//input[@id='tos']")).isEnabled())
				break;
			
			else {
				Thread.sleep(10000);
				i++;	
			}
		}
		
		driver.findElement(By.xpath("//span[@id='signup-termservice']")).click();
		String text = driver.findElement(By.xpath("//div[@class='signup-form']/h3")).getText();
		System.out.println(text);
		
		
		
		driver.quit();
	}

}
