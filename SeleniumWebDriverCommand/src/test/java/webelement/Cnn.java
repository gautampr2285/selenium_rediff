package webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.TestBase;

public class Cnn extends TestBase{
	
	@Test
	
	public void appTest() {
	WebDriver driver = launchbrowser("Chrome");
	driver.get("http://cnn.com");
	boolean b =driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[3]/ul/li[1]/a")).isDisplayed();
	System.out.println("Visible" +b);
	//svg.menu-icon
	driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[3]/ul/li[1]/a")).click();
	}
	
}
