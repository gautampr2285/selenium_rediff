package download_upload;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class Uploading_Files extends TestBase{
	
	@Test
	
	public void upload() {
		
		launchbrowser("Chrome");
		driver.get("http://files.form.guide/contact-form/contact-form-attachment-1/contactform.php");
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\Gautam\\Downloads\\dropdown.txt");
		driver.findElement(By.name("Submit")).click();
		
	}

}
