package webelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;

public class MultiSelect extends TestBase{
	
	@Test
	
	public void multiselect() throws InterruptedException {
		
		WebDriver driver = launchbrowser("Chrome");
		driver.get("https://html.com/attributes/select-multiple/");
		
		WebElement w = driver.findElement(By.xpath("//div[@class='render']/select"));
		
		Select s = new Select(w);
		List<WebElement> t = s.getOptions();
		
		for(WebElement i :t) {
			System.out.println(i.getText());
		}
		
		//System.out.println(t);
		
		Boolean  b= s.isMultiple();
		System.out.println(b);
		
		s.selectByIndex(0);
		
		Thread.sleep(2000);
		s.selectByVisibleText("Greater flamingo");
		//Thread.sleep(2000);
		
		//driver.quit();
	}

}
