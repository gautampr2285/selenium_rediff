package explicitWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class Waiting extends TestBase{
	
	@Test
	
	public void Explicit() {
		
		launchbrowser("Chrome");
		driver.get("https://www.awwwards.com/");
		driver.findElement(By.xpath("//a[@class='text-black open_login']")).click();
		
		IsElementPresent("//input[@name='_username']");
		//System.out.println(b);
		driver.findElement(By.xpath("//input[@name='_username']")).click();
		driver.findElement(By.xpath("//input[@name='_username']")).sendKeys("dfdfsf");
		
	}
	
	public boolean IsElementPresent(String e_xpath) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(e_xpath)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e_xpath)));
			
		}catch(Exception e) {
			return false;
		}
		return true;
		
	}

}
