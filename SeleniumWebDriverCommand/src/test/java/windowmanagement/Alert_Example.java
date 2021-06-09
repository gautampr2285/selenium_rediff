package windowmanagement;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestBase;

public class Alert_Example extends TestBase{
	
	@Test
	
	public void Alert_Window() {
		
		launchbrowser("Chrome");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());	
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();//ok
		driver.switchTo().defaultContent();
		
	}

}
