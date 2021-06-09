package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class Drop_down extends TestBase{
	
	@Test
	
	public void select() {
		
		WebDriver driver = launchbrowser("Chrome");
		driver.get("https://www.qtpselenium.com/contact-us");
		WebElement droplist = driver.findElement(By.name("country_id"));
		//System.out.println(droplist);
		Select s = new Select(droplist);
		List<WebElement> l = s.getOptions();
		System.out.println("All Ortions are"+l);
		for(WebElement i :l) {
			System.out.println(i.getText());
		}
		s.selectByIndex(1);
		s.selectByIndex(2);
		s.selectByIndex(3);	
		
		driver.quit();
	} 
	

}
