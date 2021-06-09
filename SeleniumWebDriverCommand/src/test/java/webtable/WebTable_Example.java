package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

public class WebTable_Example extends TestBase {
	
	@Test
	
	public void Webtable_Example() {
		
		launchbrowser("Chrome");
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		String Company = "Bajaj HindusthanSuga";
		
		List<WebElement> Names=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> Current_Price=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		System.out.println(Names.size());
		
		for(int i=0;i<Names.size();i++) {
			
			if(Company.equals(Names.get(i).getText()))
				
				System.out.println(Names.get(i).getText()+"-----------"+Current_Price.get(i).getText());
			
		}
	}
	
	

}
