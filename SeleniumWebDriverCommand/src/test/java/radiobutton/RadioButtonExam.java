package radiobutton;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.TestBase;

public class RadioButtonExam extends TestBase{
	
	@Test
	
	public void RadioButton() {
		
		launchbrowser("Chrome");
		driver.get("https://www.chabadpotomac.com/templates/articlecco_cdo/aid/1094542/jewish/HS-Registration-Form-New-Student.htm");
		List<WebElement> web_radio=driver.findElements(By.xpath("//input[@name='reading_proficiency']"));
		System.out.println("Total radion button:"+web_radio.size());
		
		
	
	}

}
