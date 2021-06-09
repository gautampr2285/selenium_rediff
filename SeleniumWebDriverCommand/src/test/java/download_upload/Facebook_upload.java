package download_upload;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.TestBase;

public class Facebook_upload extends TestBase{
	
	@Test
	
	public void upload_FB() {
		
		launchbrowser("Chrome");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("gomzi.sam@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Gautam51210$");
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		driver.manage().window().maximize();
		//driver.switchTo().alert().getText();
		
		driver.findElement(By.xpath("//div[@class='qzhwtbm6 knvmm38d']/span[1]/span[text()='Gautam Prakash']")).click();
		
	}

}
